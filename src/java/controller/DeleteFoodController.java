/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FoodDAO;
import model.FoodItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author LS5002117
 */
public class DeleteFoodController extends SimpleFormController {
    
    public DeleteFoodController() {
        setCommandClass(FoodItem.class);
        setCommandName("deletefood");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        FoodItem fooditem=(FoodItem)command;        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../applicationContext.xml");
        FoodDAO foodDOA=(FoodDAO)ctx.getBean("foodDOA");
        foodDOA.deleteFoodQuery(fooditem);
        
       // userManager.add(user);
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
