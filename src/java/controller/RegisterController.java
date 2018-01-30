/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.OnlineUserDAO;
import model.OnlineUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

public class RegisterController extends SimpleFormController {

    private OnlineUserDAO dao;

    public RegisterController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("OnlineUserDAO", OnlineUserDAO.class);
        setCommandClass(OnlineUser.class);
        setCommandName("userModel");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception{
        OnlineUser user = (OnlineUser) command;
        
        if (dao.insertUser(user)) {
            OnlineUser returnedUser = dao.getUser(user.getEmail(), user.getPassword());
            HttpSession session = request.getSession();
            session.setAttribute("user", returnedUser);
        }
        
        return new ModelAndView(new RedirectView("/Restaurant"));
        
    }

}
