/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author syntel
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author syntel
 */
public class FoodItem {
    private int foodItemId;
    private String name;
    private String description;
    private float price;
    private String type;
    private String veg;
    private String image;
    private ArrayList<Availability> availability = new ArrayList<Availability>();

    public FoodItem(int foodItemId, String name, String description, float price, String type, String veg) {
        this.foodItemId = foodItemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.veg = veg;        
    }
    
    
    
    public void addAvailability(Availability av) {
        this.availability.add(av);
    }

    public void setAvailability(ArrayList<Availability> availability) {
        this.availability = availability;
    }
    
    public ArrayList<Availability> getAvailability(){
        return this.availability;
    }
    
    
	public int getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVeg() {
		return veg;
	}

    @Override
    public String toString() {
        return "FoodItem{" + "foodItemId=" + foodItemId + ", name=" + name + ", description=" + description + ", price=" + price + ", type=" + type + ", veg=" + veg + ", image=" + image + ", availability=" + availability + '}';
    }
	public void setVeg(String veg) {
		this.veg = veg;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

    public FoodItem() {
    }

	
    
    
}

