package controller;

import DAO.OnlineUserDAO;
import DAO.OrderDAO;
import model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class FoodItemController {

    private OrderDAO dao;

    public FoodItemController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("orderDAO", OrderDAO.class);
    }

    private static FoodItem fooditem = new FoodItem();

    public static FoodItem getFoodItem() {
        return fooditem;
    }

    private List convertFoodDetailsToJson(List items) {
        List toReturn = new ArrayList();
        for (Object item : items) {
            if (!(item instanceof FoodItem)) {
                System.out.println("not food");
                continue;
            }

            FoodItem foodItem = (FoodItem) item;
            StringBuilder itemStr = new StringBuilder();
            itemStr.append("{");
            itemStr.append("\"name\":");
            itemStr.append("\"" + foodItem.getName() + "\"");
            itemStr.append(",");
            itemStr.append("\"des\":");
            itemStr.append("\"" + foodItem.getDescription() + "\"");
            itemStr.append(",");
            itemStr.append("\"price\":");
            itemStr.append("\"" + foodItem.getPrice() + "\"");
            itemStr.append(",");
            itemStr.append("\"veg\":");
            itemStr.append("\"" + foodItem.getIsVeg() + "\"");
            itemStr.append(",");
            itemStr.append("\"image\":");
            itemStr.append("\"" + foodItem.getImage() + "\"");
            itemStr.append("}");

            toReturn.add(itemStr);
        }

        return toReturn;
    }

    //this is not working the way it should,getFoodItemsInArea in connector returns strings not FoodItems
    public ModelAndView FoodItemsInArea(@RequestParam("zip") int zipCode) {
        Connector dataConnector = new Connector();
        List items = convertFoodDetailsToJson(dataConnector.getFoodItemsInArea(zipCode));
        return new ModelAndView("menuView", "items", items);
    }

    public ModelAndView FoodItemsInArea(@RequestParam("email") String email) {
        Connector dataConnector = new Connector();
        List items = convertFoodDetailsToJson(dataConnector.foodAvailableFor(email));
        return new ModelAndView("menuView", "items", items);
    }

    @RequestMapping( value="/menuView.htm", method = RequestMethod.GET )
    public ModelAndView FoodItemsAllAreas(HttpServletRequest request,
                                          HttpServletResponse response) {

        Connector dataConnector = new Connector();
        OnlineUser user = (OnlineUser) request.getSession().getAttribute("user");

        if (user == null) {
            List items = convertFoodDetailsToJson(dataConnector.selectAllFoodItems());
            return new ModelAndView("menuView", "items", items);
        }

        return new ModelAndView("order", "food", dataConnector.foodAvailableFor(user.getEmail()));
    }

    @RequestMapping( value="/menuView.htm", method = RequestMethod.POST )
    public ModelAndView addOrder(
            @RequestParam("street") String street,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("zip") String zip,
            @RequestParam("deliver") String deliver,
            @RequestParam("time") String time,
            @RequestParam("price") String price,
            @RequestParam("payment") String payment,
            @RequestParam("food") String food,
            HttpServletRequest request, HttpServletResponse response) {

        Connector dataConnector = new Connector();

        OnlineUser user = (OnlineUser) request.getSession().getAttribute("user");

        // Address
        Address address = new Address();
        address.setStreet1(street);
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);

        // Order
        Orders order = new Orders();
        order.setUserId(user.getUserId());
        order.setPaymentMethod(payment);
        order.setPrice(Float.parseFloat(price));

        // parse date
        Date deliveryDate;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            deliveryDate = df.parse(deliver);
        } catch (ParseException e) {
            deliveryDate = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(deliveryDate);
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.split(" ")[0] + (12 * (time.split(" ")[1].equals("PM") ? 1 : 0))));
        Date deliveryTime = cal.getTime(); // returns new date object, one hour in the future

        // Do the insert
        if (dao.insertOrder(order, address, user, deliveryTime, removeLastChar(food))) {
            return new ModelAndView("index.htm");
        }

        return new ModelAndView("order", "food", dataConnector.foodAvailableFor(user.getEmail()));
    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }


}
