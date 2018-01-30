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
public class UpdateClass extends SimpleFormController {
    
       
    
    public UpdateClass() {
        setCommandClass(FoodItem.class);
        setCommandName("update");
        
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        FoodItem fitem=(FoodItem)command;
        
                      
        ApplicationContext ctx=new ClassPathXmlApplicationContext("test.xml");
        FoodDAO foodDOA=(FoodDAO)ctx.getBean("foodDOA");
        foodDOA.deleteFoodQuery(fitem);
        foodDOA.createFoodQuery(fitem);
        
       
        return new ModelAndView("managePackages");
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
