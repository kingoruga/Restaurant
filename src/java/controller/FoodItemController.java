
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.FoodItem;
import model.Availability;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author LS5002117
 */
public class FoodItemsController extends SimpleFormController {
    
    private static FoodItem fooditem = new FoodItem();
    
    
    public static FoodItem getFoodItem(){
        return fooditem;
    }
    
    
    
    public FoodItemController() {
        setCommandClass(FoodItem.class);
        setCommandName("fooditem");
        
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        FoodItem fitem=(FoodItem)command;
        
        fooditem = fitem;
        
        //Availability av = new Availability();
        
        /*
                
        ApplicationContext ctx=new ClassPathXmlApplicationContext("test.xml");
        FoodDOA foodDOA=(FoodDOA)ctx.getBean("foodDOA");
        foodDOA.createFoodQuery(fooditem);
        
        */
        return new ModelAndView("redirect:availability.htm");
    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     * @Override protected ModelAndView onSubmit( HttpServletRequest request,
     * HttpServletResponse response, Object command, BindException errors)
     * throws Exception { ModelAndView mv = new ModelAndView(getSuccessView());
     * //Do something... return mv; }
     */

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
    
    @RequestMapping( value="/menuView.htm" )
    public ModelAndView FoodItemsAllAreas()
    {
        Connector dataConnector = new Connector();
        List items = convertFoodDetailsToJson(dataConnector.selectAllFoodItems());
        return new ModelAndView( "menuView" , "items" , items );
    }
    

}
