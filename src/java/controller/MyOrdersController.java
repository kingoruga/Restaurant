/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.OnlineUserDAO;
import model.OnlineUser;
import model.Orders;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MyOrdersController implements Controller {
    
    OnlineUserDAO dao;

    public MyOrdersController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("OnlineUserDAO", OnlineUserDAO.class);
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        OnlineUser user = (OnlineUser) hsr.getSession().getAttribute("user");
        List<Orders> orders = dao.getOrdersFor(user);
        return new ModelAndView("myOrders", "orders", orders);
    }

}

