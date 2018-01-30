package com.syntel.domain;

import static com.syntel.domain.Orders.surroundWithQuotes;
import java.util.ArrayList;

public class FoodItem {

    private int FoodItemId;
    private String Name;
    private String Description;
    private float Price;
    private String Type;
    private boolean IsVeg;
    private String Image;
    private ArrayList<Availability> Availability;

    public FoodItem() {

    }

    public FoodItem(int id, String name, String description, float price, String type, boolean veg, String image, ArrayList availability) {
        this.FoodItemId = id;
        this.Name = name;
        this.Description = description;
        this.Price = price;
        this.Type = type;
        this.IsVeg = veg;
        this.Image = image;
        this.Availability = availability;
    }

    public int getFoodItemId() {
        return FoodItemId;
    }

    public void setFoodItemId(int FoodItemId) {
        this.FoodItemId = FoodItemId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public boolean getIsVeg() {
        return IsVeg;
    }

    public void setIsVeg(boolean IsVeg) {
        this.IsVeg = IsVeg;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public ArrayList<Availability> getAvailability() {
        return Availability;
    }

    public void createAvailability(ArrayList<Availability> a) {
        this.Availability = a;
    }

    public void setAvailability(Availability a) {
        this.Availability.add(a);
    }

    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append( "{" );
        toReturn.append( surroundWithQuotes( "food_item_id" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Integer.toString(FoodItemId) ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "name" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Name ) );

        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "description" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Description ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "price" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Float.toString( Price ) ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "type" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Type ) );
        
        toReturn.append( "," );
        toReturn.append( surroundWithQuotes( "is_veg" ) );
        toReturn.append( ":" );
        toReturn.append( surroundWithQuotes( Boolean.toString(IsVeg) ) );
        
        toReturn.append( "}" );
        return toReturn.toString();
    }
}
