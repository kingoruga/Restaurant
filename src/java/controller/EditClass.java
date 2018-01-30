/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.FoodItem;
import model.Availability;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author LS5002117
 */
public class EditClass extends SimpleFormController {
    
    private static FoodItem foodItem;
    private static ArrayList<Availability> av;
    private static int index = 0;
        
    public EditClass() {
        setCommandClass(FoodItem.class);
        setCommandName("edit");
        
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        
        FoodItem fooditem=(FoodItem)command;        
            ApplicationContext ctx=new ClassPathXmlApplicationContext("test.xml");
            FoodDAO foodDOA=(FoodDAO)ctx.getBean("foodDOA");
         
         if(foodItem!=null) {
                           
                fooditem.setAvailability(foodItem.getAvailability());
                foodDOA.deleteFoodQuery(foodItem);
                foodDOA.createFoodQuery(fooditem);     
            
                System.out.println(fooditem);
                System.out.println(foodItem);
                
                foodItem=null;
                return new ModelAndView("managePackages");    
                      

        }else{
            
            foodItem = foodDOA.getFoodQuery(fooditem);   
            av = foodItem.getAvailability();
            
            System.out.println(foodItem);
        
       // userManager.add(user);
            return new ModelAndView("editfood","update",foodItem);
        }
               
        
        
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
