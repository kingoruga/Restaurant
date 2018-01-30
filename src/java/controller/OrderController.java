/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Connector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
    This class is used as a controller for the manage orders admin page.
    It returns a ModelAndView for the url mapping: manageOrders.htm?col=...
    The col parameter is used by the controller to determine the exact method
        to use to pass along the list of orders to the view.
*/
//@Controller
@RequestMapping(value="/manageOrders.htm")
public class OrderController 
{
    @RequestMapping
    public ModelAndView getOrdersBy( @RequestParam(value="col",required=false,defaultValue="") String columnName )
    {
        //verify that columnName is valid
        switch (columnName) {
            case "price":
            case "order_id":
            case "payment_type":
                return new ModelAndView( "manageOrders" , "orderList" , new Connector().selectOrdersSortColumn( columnName ) );
            case "email":
            case "last_name":
                return new ModelAndView( "manageOrders" , "orderList" , new Connector().selectOrdersSortCustomerColumn( columnName ) );
            default:
                return new ModelAndView( "manageOrders" , "orderList" , new Connector().selectOrdersSortAddressZip() );
        }
    }
    
}
