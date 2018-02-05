/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import receiptDelivery.PdfCreator;
import DAO.OrderDAO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import receiptDelivery.TxtCreator;

/*
    This class acts as the controller for admin area management
*/
@Controller
public class FoodItemController 
{
  
    private OrderDAO dao;

    public FoodItemController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("orderDAO", OrderDAO.class);
    }

    private static FoodItem fooditem = new FoodItem();

    public static FoodItem getFoodItem() {
        return fooditem;
    }

    private List convertFoodDetailsToJson( List items )
    {
        List toReturn = new ArrayList();
        for ( Object item : items )
        {
            if ( !( item instanceof FoodItem ) )
            {
                System.out.println("not food");
                continue;
            }
            
            FoodItem foodItem = (FoodItem) item;
            StringBuilder itemStr = new StringBuilder();
            itemStr.append( "{" );
            itemStr.append( "\"name\":" );
            itemStr.append( "\"" + foodItem.getName() + "\"" );
            itemStr.append( "," );
            itemStr.append( "\"des\":" );
            itemStr.append( "\"" + foodItem.getDescription() + "\"" );
            itemStr.append( "," );
            itemStr.append( "\"price\":" );
            itemStr.append( "\"" + foodItem.getPrice() + "\"" );
            itemStr.append( "," );
            itemStr.append( "\"veg\":" );
            itemStr.append( "\"" + foodItem.getIsVeg() + "\"" );
            itemStr.append( "," );
            itemStr.append( "\"image\":" );
            itemStr.append( "\"" + foodItem.getImage() + "\"" );
            itemStr.append( "}" );
            
            toReturn.add( itemStr );
        }
        
        return toReturn;
    }
    
    
    @RequestMapping( value="/getFoodItemsInArea.htm", method=RequestMethod.GET )
    @Deprecated
    //this is not working the way it should,getFoodItemsInArea in connector returns strings not FoodItems
    public ModelAndView FoodItemsInArea( @RequestParam("zip") int zipCode )
    {
        Connector dataConnector = new Connector();
        List items = convertFoodDetailsToJson(dataConnector.getFoodItemsInArea(zipCode));
        return new ModelAndView( "menuView" , "items" , items );
    }
    
    @RequestMapping( value="/getFoodItemsForUser.htm", method=RequestMethod.GET )
    public ModelAndView FoodItemsInArea( @RequestParam("email") String email )
    {
        Connector dataConnector = new Connector();
        List items = convertFoodDetailsToJson(dataConnector.foodAvailableFor(email));
        return new ModelAndView( "menuView" , "items" , items );
    }
    
     @RequestMapping( value="/menuView.htm", method = RequestMethod.GET )
    public ModelAndView FoodItemsAllAreas(HttpServletRequest request, HttpServletResponse response) 
    {
        Map<String,Object> model = new HashMap<>();
        Connector dataConnector = new Connector();
        OnlineUser user = (OnlineUser) request.getSession().getAttribute("user");
        model.put( "user" , user );
        if (user == null) {
            model.put( "user" , "{}" );
            model.put( "items" , convertFoodDetailsToJson(dataConnector.selectAllFoodItems()) );
            return new ModelAndView("menuView", "model", model);
        }
        else
        {
            model.put( "food" , dataConnector.foodAvailableFor(user.getEmail()) );
            return new ModelAndView("order", "model", model );
        }
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
            @RequestParam(value="print",required=false,defaultValue="") String printType,
            HttpServletRequest request, HttpServletResponse response) 
    {
        Map<String,Object> model = new HashMap<>();
        Connector dataConnector = new Connector();
        OnlineUser user = (OnlineUser) request.getSession().getAttribute("user");
        model.put( "user" , user );
        if ( user == null )
        {
            return new ModelAndView( new RedirectView( "/Restaurants/login.htm" ) );
        }
        
        System.out.println( printType );

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
            List<String> orderDetails = new ArrayList<>();
                orderDetails.add(street); 
                orderDetails.add(city);
                orderDetails.add(state);
                orderDetails.add(zip);
                orderDetails.add(price);
                orderDetails.add(payment);
                orderDetails.add(deliver);
                orderDetails.add(time);
                orderDetails.add(food);
            if(printType.equals("PDF")){
                PdfCreator createPdf = new PdfCreator();
                try {
                    createPdf.generatePdfReceipt(orderDetails);
                }
                catch(IOException e){
                    e.getStackTrace();
                }
            }
            if(printType.equals("text")){
                TxtCreator createTxt = new TxtCreator();
                createTxt.generateTxtReceipt(orderDetails);
            }
            return new ModelAndView(new RedirectView("myOrders.htm"));
        }

        model.put( "food" , dataConnector.foodAvailableFor(user.getEmail()) );
        return new ModelAndView("order", "model", model);
    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
}