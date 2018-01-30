package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Connector;
import model.FoodItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
    This class acts as the controller for admin area management
*/
@Controller
public class FoodItemController 
{
  
    private List convertFoodDetailsToJson( List items )
    {
        List toReturn = new ArrayList();
        for ( Object item : items )
        {
            if ( !( item instanceof FoodItem ) )
            {
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
        }
        
        return toReturn;
    }
    
    @RequestMapping( value="/getFoodItemsInArea.htm", method=RequestMethod.GET )
    public ModelAndView FoodItemsInArea( @RequestParam("zip") int zipCode )
    {
        Connector dataConnector = new Connector();
        ArrayList items = new ArrayList();
        items.addAll(convertFoodDetailsToJson(dataConnector.getFoodItemDetailsInArea(zipCode)));
        return new ModelAndView( "getFoodItemsInArea" , "itemsInArea" , items );
    }

    @RequestMapping( value="/getFoodItemsAllAreas.htm", method=RequestMethod.GET )
    public ModelAndView FoodItemsAllAreas()
    {
        Connector dataConnector = new Connector();
        ArrayList items = new ArrayList();
        items.addAll(convertFoodDetailsToJson(dataConnector.getFoodItemDetailsAllAreas()));
        return new ModelAndView( "getFoodItemsAllAreas" , "itemsAll" , items );
    }
    
}