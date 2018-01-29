package com.syntel.controller;

import com.syntel.DAO.OnlineUserDAO;
import com.syntel.domain.OnlineUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegisterController extends SimpleFormController {

    private OnlineUserDAO dao;

    public RegisterController() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
        dao = ctx.getBean("OnlineUserDAO", OnlineUserDAO.class);
        setCommandClass(OnlineUser.class);
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception{
        OnlineUser user = (OnlineUser) command;
        if (dao.insertUser(user))
            return new ModelAndView("registerSuccess","user",user);
        else
            return new ModelAndView("registerFail");
    }

}
