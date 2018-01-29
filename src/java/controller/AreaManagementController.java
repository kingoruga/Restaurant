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
public class AreaManagementController 
{
    @RequestMapping( value="remove.htm" ,method=RequestMethod.GET )
    public ModelAndView removeArea( @RequestParam("zip") int zipCode )
    {
        Connector dataConnector = new Connector();
        dataConnector.removeZipFromServiceArea( zipCode );
        return new ModelAndView( "manageAreas" , "areaList" , dataConnector.getAreas() );
    }
    
    @RequestMapping( value="add.htm" ,method=RequestMethod.GET )
    public ModelAndView addArea( @RequestParam("zip") int zipCode )
    {
        Connector dataConnector = new Connector();
        dataConnector.addZipToServiceArea( zipCode );
        return new ModelAndView( "manageAreas" , "areaList" , dataConnector.getAreas() );
    }
    
    @RequestMapping( value={"/manageAreas.htm"} ,method=RequestMethod.GET )
    public ModelAndView allArea()
    {
        Connector dataConnector = new Connector();
        return new ModelAndView( "manageAreas" , "areaList" , dataConnector.getAreas() );
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
    public ModelAndView packagesInArea( @RequestParam("zip") int zipCode )
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
        return new ModelAndView( "manageAreaPackages" , "model" , model );
    }
    
    @RequestMapping( value="/modifyAreaPackage.htm", method=RequestMethod.GET )
    public ModelAndView modifyPackageArea( @RequestParam("zip") int zipCode , @RequestParam("item") String itemId , @RequestParam("command") String command )
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
        return packagesInArea( zipCode );
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
