/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OnlineUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LogoutController  {

   /* @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        HttpSession session = hsr.getSession();
        session.setAttribute("user", null);
        return new ModelAndView(new RedirectView("/Restaurant"));
    }  */
    
    @RequestMapping(value="logout.htm")
    public String logout(@ModelAttribute("user") OnlineUser user, ModelMap model,HttpSession session ){
        session.setAttribute("user", null);
        return "redirect:/index.htm";
    }
    
}
