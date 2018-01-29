package com.syntel.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.syntel.DAO.OnlineUserDAO;
import com.syntel.domain.OnlineUser;
import org.springframework.web.servlet.view.RedirectView;

import java.net.CookieHandler;
import java.net.CookieManager;

public class LoginController extends SimpleFormController {

    OnlineUserDAO dao;

    public LoginController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("OnlineUserDAO", OnlineUserDAO.class);
        setCommandClass(OnlineUser.class);
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        OnlineUser user=(OnlineUser)command;
        OnlineUser returnedUser = dao.getUser(user.getEmail(), user.getPassword());

        // CookieManager cm = new CookieManager();
        // CookieHandler.setDefault(cm);

        if (returnedUser != null)
            return new ModelAndView("userSuccess", "user", returnedUser);
        else
            return new ModelAndView(new RedirectView("/"));
            //return new ModelAndView("userFailure");
    }
}
