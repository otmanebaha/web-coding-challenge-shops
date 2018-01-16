package org.shops.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import static org.shops.configuration.Configuration.*;

@Document(collection = "shops")
public class Shop {
	@Id
	private ObjectId _id;
	private String picture;
	private String name;
	private String email;
	private String city;
	//liked means the state of the shop either "LIKE" or "DISLIKE" or "NoLIKENoDISLIKE"
	private int liked=NoLIKENoDISLIKE;
	//The time that the shop won't be displayed
	private Long timeOfDislike;	
	private org.shops.entities.Point location;
		
	public Shop() {	
	}
	
	public Shop(ObjectId _id, String picture, String name, String email, String city, int liked, org.shops.entities.Point location) {
		super();
		this._id = _id;
		this.picture = picture;
		this.name = name;
		this.email = email;
		this.city = city;
		this.liked = liked;
		this.location = location;		
	}

	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public org.shops.entities.Point getLocation() {
		return location;
	}

	public void setLocation(org.shops.entities.Point location) {
		this.location = location;
	}

	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}

	public Long getTimeOfDislike() {
		return timeOfDislike;
	}

	public void setTimeOfDislike(Long timeOfDislike) {
		this.timeOfDislike = timeOfDislike;
	}
	
	
}
