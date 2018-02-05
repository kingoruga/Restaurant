/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import model.Connector;
import model.OnlineUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
    This class is used as a controller for the manage orders admin page.
    It returns a ModelAndView for the url mapping: manageOrders.htm?col=...
    The col parameter is used by the controller to determine the exact method
        to use to pass along the list of orders to the view.
*/
@Controller
@RequestMapping(value="/manageOrders.htm")
public class OrderController 
{
    @RequestMapping
    public ModelAndView getOrdersBy( HttpSession session, @RequestParam(value="col",required=false,defaultValue="") String columnName, @ModelAttribute("user") OnlineUser user )
    {
        Map<String,Object> model = new HashMap<>();
        model.put( "user" , session.getAttribute( "user" ) );
        if ( model.get( "user" ) == null )
        {
            model.put("user" ,"{}" );
        }
        
        //verify that columnName is valid
        switch (columnName) {
            case "price":
            case "order_id":
            case "payment_type":
                model.put( "orderList" , new Connector().selectOrdersSortColumn( columnName ) );
                break;
            case "email":
            case "last_name":
                model.put( "orderList" , new Connector().selectOrdersSortCustomerColumn( columnName ) );
                break;
            default:
                model.put( "orderList" , new Connector().selectOrdersSortAddressZip() );
                break;
        }
        
         if(user.getIsAdmin()){
             return new ModelAndView( "manageOrders" , "model" , model  );
        }
        return new ModelAndView( "unauthorized" );
    }
    
}
