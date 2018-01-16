package org.shops.controllers;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import org.bson.types.ObjectId;
import org.shops.dao.ShopRepository;
import org.shops.entities.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.shops.configuration.Configuration.*;

@RestController
@CrossOrigin("*")
public class ShopController {
	@Autowired
	ShopRepository shopsRepository;
	
	//Get all the shops
	@RequestMapping(value="/Shops",method=RequestMethod.GET)
    public List<Shop> getShops() {
		List <Shop> listShopsDisliked=shopsRepository.ShopsDisliked();
		for (Shop shop : listShopsDisliked) {
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			long time = calendar.getTimeInMillis();
			if(shop.getTimeOfDislike()<=time){
				shop.setLiked(NoLIKENoDISLIKE);
				shop.setTimeOfDislike(new Long(0));
				shopsRepository.save(shop);
			}
		}
		List <Shop> listShopsNoLikedNotDisliked=shopsRepository.ShopsNotLikedNotDisliked();
		Collections.sort(listShopsNoLikedNotDisliked, new Comparator<Shop>()
		{
			@Override
			public int compare(Shop shop1, Shop shop2) {
				return Double.compare(shop1.getLocation().distance(), shop2.getLocation().distance());
			}
		});		
        return listShopsNoLikedNotDisliked;
	}
	
	//Get the preferred shops
	@RequestMapping(value="/MyShops",method=RequestMethod.GET)
    public List<Shop> getShopsLiked(){
   	 return shopsRepository.ShopsLiked();
    }
	
	//Delete a shop with his "id" passed as parameter
	@RequestMapping(value="/Shops/{id}", method=RequestMethod.DELETE)
	public boolean deleteShop(@PathVariable ObjectId id){	 
		shopsRepository.delete(id);
		 return true;
	}
	
	//Update the shop that is liked with his "id" passed as parameter
	@RequestMapping(value="/Shops/like", method=RequestMethod.PUT)
	public List<Shop> updateShopWhileLiking(@RequestBody ObjectId id){
		Shop shop=shopsRepository.findOne(id);
		shop.setLiked(LIKE);
		shopsRepository.save(shop);
		 return  shopsRepository.ShopsNotLikedNotDisliked();
	}
	
	//Update the shop that is disliked with his "id" passed as parameter
	@RequestMapping(value="/Shops/dislike", method=RequestMethod.PUT)
	public List<Shop> updateShopWhileDisliking(@RequestBody ObjectId id){
		Shop shop=shopsRepository.findOne(id);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.add(calendar.MINUTE, 120);
		long time = calendar.getTimeInMillis();
		shop.setTimeOfDislike(time);
		shop.setLiked(DISLIKE);
		shopsRepository.save(shop);
		 return  shopsRepository.ShopsNotLikedNotDisliked();
	}
	
	//Update the shop that is not liked and not disliked with his "id" passed as parameter
	@RequestMapping(value="/Shops/noLikeNoDislike", method=RequestMethod.PUT)
	public List<Shop> updateShopWhileNoLikingNoDisliking(@RequestBody ObjectId id){
		Shop shop=shopsRepository.findOne(id);
		shop.setLiked(NoLIKENoDISLIKE);
		shopsRepository.save(shop);
		 return  shopsRepository.ShopsLiked();
	}
	
	
}
