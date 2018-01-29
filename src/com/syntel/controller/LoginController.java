package com.syntel.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.syntel.DAO.OnlineUserDAO;
import com.syntel.domain.OnlineUser;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends SimpleFormController {

    OnlineUserDAO dao;

    public LoginController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("OnlineUserDAO", OnlineUserDAO.class);
        setCommandClass(OnlineUser.class);
        setCommandName("user");
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception{
        OnlineUser user= (OnlineUser) command;
        OnlineUser returnedUser = dao.getUser(user.getEmail(), user.getPassword());

        if (returnedUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", returnedUser);
            return new ModelAndView("userSuccess", "user", returnedUser);
        }
        
        else
            return new ModelAndView(new RedirectView("/"));
            //return new ModelAndView("userFailure");
    }
}
