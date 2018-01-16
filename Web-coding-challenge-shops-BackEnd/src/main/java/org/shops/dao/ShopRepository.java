package org.shops.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.shops.entities.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ShopRepository extends MongoRepository<Shop, ObjectId>{
	//The list of shops that are not liked and not disliked
	@Query("{ 'liked' : { $nin: [ 1, -1 ]} }")
		List<Shop> ShopsNotLikedNotDisliked();	
	
	//The list of shops that are liked
	@Query("{ 'liked' : { $nin: [ 0, -1 ]} }")
		List<Shop> ShopsLiked();
	
	//The list of shops that are disliked
	@Query("{ 'liked' : { $nin: [ 0, 1 ]} }")
		List<Shop> ShopsDisliked();
	
	
}
