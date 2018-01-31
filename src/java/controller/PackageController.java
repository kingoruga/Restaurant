package controller;

import model.Connector;
import model.FoodItem;

public class PackageController {


    private Connector conn = new Connector();


    public void createNewItem(FoodItem item) {

        conn.createFoodQuery(item);
    }

    public void deleteFoodItem(String name) {

        conn.removeFoodQuery(name);
    }

    public void getFoodItem(FoodItem item) {

        conn.getFoodQuery(item);
    }


}
