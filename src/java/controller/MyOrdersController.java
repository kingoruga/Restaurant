/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.OnlineUserDAO;
import DAO.OrderDAO;
import static java.util.Arrays.stream;
import java.util.HashMap;
import model.OnlineUser;
import model.Orders;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

public class MyOrdersController implements Controller {
    
    OnlineUserDAO dao;
    OrderDAO orderDao;

    public MyOrdersController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("OnlineUserDAO", OnlineUserDAO.class);
        orderDao = ctx.getBean("orderDAO", OrderDAO.class);
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        OnlineUser user = (OnlineUser) hsr.getSession().getAttribute("user");
        
        if (hsr.getMethod().equals("POST")) {
            Map<String, String[]> map = hsr.getParameterMap();
            
            int orderId = Integer.parseInt(map.get("orderId")[0]);
            String action = map.get("action")[0];
            
            if (action.equals("ADDRESS")) {
                Address a = new Address();
                
                a.setStreet1(map.get("street")[0]);
                a.setCity(map.get("city")[0]);
                a.setState(map.get("state")[0]);
                a.setZip(map.get("zip")[0]);
         
                orderDao.changeOrderAddress(orderId, a);
            }
            
            if (action.equals("DATE")) {
                String date = map.get("date")[0];
                
                orderDao.changeDate(orderId, date);
            }
                    
            System.out.println("hey");
        }
        
        if(user != null){
            Map<String,Object> model = new HashMap<>();
            List<Orders> orders = dao.getOrdersFor(user);
            
            model.put( "user" , user );
            model.put( "orders" , orders );
            model.put( "amounts", getAmountJson(orders) );
            
            return new ModelAndView("myOrders", "model", model );
        }
        return new ModelAndView(new RedirectView("/Restaurants/login.htm"));
    }
    
    private String getAmountJson(List<Orders> orders) {
        Map<String, Map<String, Integer>> foodAmounts = new HashMap<>();

        // for every order
        orders.stream().forEach(o -> {
            // Get all items in the order
            Map<String, Integer> items = orderDao.getAmountOfFoodItemInOrder(o.getOrderId());
            foodAmounts.put(Integer.toString(o.getOrderId()), items);
        });

        String amountJson = foodAmounts.toString().replaceAll("(\\d+)", "\"$1\"").replaceAll("=", ":");
        return amountJson;
    }
    
}

