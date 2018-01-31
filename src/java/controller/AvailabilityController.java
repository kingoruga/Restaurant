/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Availability;
import model.FoodItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author LS5002117
 */

public class AvailabilityController extends SimpleFormController {
    
    public AvailabilityController() {
        setCommandClass(Availability.class);
        setCommandName("avail");
        
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{

        Availability availability =(Availability)command;

        /*

        FoodItemController fclass = new FoodItemController();
        
        FoodItem fitem = fclass.getFoodItem();
        
        System.out.println(availability);
        
        fitem.setAvailability(availability);
        */
                
               
        return new ModelAndView("redirect:commit.htm");
    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     * @Override protected ModelAndView onSubmit( HttpServletRequest request,
     * HttpServletResponse response, Object command, BindException errors)
     * throws Exception { ModelAndView mv = new ModelAndView(getSuccessView());
     * //Do something... return mv; }
     */
}
