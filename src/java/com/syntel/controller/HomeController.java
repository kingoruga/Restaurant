/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.controller;

import javax.servlet.http.HttpSession;
import model.OnlineUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author syntel
 */
@Controller
public class HomeController {
    
    @RequestMapping("index.htm")
    public String Index(HttpSession session,@ModelAttribute("user") OnlineUser user, ModelMap model){
        model.put( "user" , session.getAttribute("user") != null ? session.getAttribute("user") : "{}" );

        return "index";
    }
    
}
