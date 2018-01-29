package com.syntel.controller;

import com.syntel.DAO.OnlineUserDAO;
import com.syntel.domain.OnlineUser;
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
        setCommandName("user");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception{
        OnlineUser user = (OnlineUser) command;
        
        if (dao.insertUser(user)) {
            OnlineUser returnedUser = dao.getUser(user.getEmail(), user.getPassword());
            HttpSession session = request.getSession();
            session.setAttribute("user", returnedUser);
            return new ModelAndView(new RedirectView("/"));
        }
        
        else
            return new ModelAndView("registerFail");
    }

}
