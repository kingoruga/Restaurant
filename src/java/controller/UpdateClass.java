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

public class UpdateClass extends SimpleFormController {

    public UpdateClass() {
        setCommandClass(FoodItem.class);
        setCommandName("update");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        FoodItem f = (FoodItem) command;

        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        FoodDAO foodDOA = (FoodDAO) ctx.getBean("foodDOA");
        foodDOA.deleteFoodQuery(f);
        foodDOA.createFoodQuery(f);

        return new ModelAndView("managePackages");
    }
}
