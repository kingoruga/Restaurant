package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import model.Connector;
import model.FoodItem;
import model.OnlineUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
    This class acts as the controller for admin area management
*/
@Controller
public class AreaManagementController 
{
    @RequestMapping( value="area/remove.htm" ,method=RequestMethod.GET )
    public String removeArea( @RequestParam("zip") int zipCode )
    {
        Connector dataConnector = new Connector();
        dataConnector.removeZipFromServiceArea( zipCode );
        return "redirect:/manageAreas.htm";
    }
    
    @RequestMapping( value="area/add.htm" ,method=RequestMethod.GET )
    public String addArea( @RequestParam("zip") int zipCode )
    {
        Connector dataConnector = new Connector();
        dataConnector.addZipToServiceArea( zipCode );
        return "redirect:/manageAreas.htm";
    }
    
    @RequestMapping( value={"/manageAreas.htm"} ,method=RequestMethod.GET )
    public ModelAndView allArea( HttpSession session )
    {
        Connector dataConnector = new Connector();
        Map<String,Object> model = new HashMap<>();
        model.put( "user" , session.getAttribute( "user" ) != null ? session.getAttribute( "user" ) : "{}");
        model.put( "areaList" , dataConnector.getAreas() );
        OnlineUser user = (OnlineUser)session.getAttribute("user");
        if(user.getIsAdmin()){
             return new ModelAndView( "manageAreas" , "model" , model  );
        }
        return new ModelAndView( "unauthorized" );
    }
    
    private List convertFoodToJson( List items )
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
            itemStr.append( "\"id\":" );
            itemStr.append( "\"" + foodItem.getFoodItemId() + "\"" );
            itemStr.append( "}" );
            toReturn.add( itemStr.toString() );
        }
        
        return toReturn;
    }
    
    @RequestMapping( value="/manageAreaPackages.htm", method=RequestMethod.GET )
    public ModelAndView packagesInArea( HttpSession session, @RequestParam("zip") int zipCode )
    {
        Connector dataConnector = new Connector();
        //passing along multiple things for the model,so using a map
        Map<String, Object> model = new HashMap<>();
        //just a zip code
        model.put( "zip" , zipCode );
        //map each food item to just its name and collect into a list that goes into the model
        //  also puts quotes around the names for json
        model.put( "allfood" , convertFoodToJson( dataConnector.selectAllFoodItems() )
        );
        //list of strings containing names of the food items that are available
        //  also puts quotes around the names for json
        model.put( "available" , dataConnector.getFoodItemsInArea( zipCode )
            .stream()
            .map( str -> "\"" + str.toString() + "\"" ) 
            .collect( Collectors.toList() ) 
        );
        model.put( "user" , session.getAttribute( "user" ) != null ? session.getAttribute( "user" ) : "{}");
        return new ModelAndView( "manageAreaPackages" , "model" , model );
    }
    
    @RequestMapping( value="area/modifyAreaPackage.htm", method=RequestMethod.GET )
    public String modifyPackageArea( @RequestParam("zip") int zipCode , @RequestParam("item") String itemId , @RequestParam("command") String command )
    {
        Connector dataConnector = new Connector();
        
        if ( command.equals( "add" ) )
        {    
            dataConnector.addPackagetoArea( zipCode, itemId );
        }
        else if ( command.equals( "remove" ) )
        {
            dataConnector.removePackageFromArea( zipCode, itemId );
        }
        
        //otherwise do nothing and just return the page
        //return packagesInArea( zipCode );
        return "redirect:/manageAreaPackages.htm?zip=" + zipCode;
    }
    
    /*
    AreaModel am = new AreaModel();

    public boolean addArea(int zip){
        return am.addArea(zip);
    }
    public boolean removeArea(int zip){
        return am.removeArea(zip);
    }
    public List<String> getAreas(){
        return am.getAreas();
    }
    public List<String> getFoodInAreas(int zip){
        return am.getFoodInAreas(zip);
    }
    public boolean addPackagetoArea(int zip,String packageNo){
        return am.addPackagetoArea(zip, packageNo);
    }
    public boolean removePackageFromArea(int zip,String packageNo){
        return am.removePackageFromArea(zip,packageNo);
    }
    */
}
