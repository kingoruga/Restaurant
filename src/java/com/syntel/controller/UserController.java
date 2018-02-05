/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.controller;

import javax.servlet.http.HttpSession;
import model.Connector;
import model.OnlineUser;
import model.UserAndAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




/**
 *
 * @author syntel
 */
@Controller
public class UserController {


    
     @RequestMapping(value="login.htm", method=RequestMethod.GET)
    public String login(@ModelAttribute("user") OnlineUser user, ModelMap model, HttpSession session )
    {
        model.put( "userObj" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );
        return "login";   
    }
    
    @RequestMapping(value="register.htm", method=RequestMethod.GET)
    public String register(@ModelAttribute("user") UserAndAddress user, ModelMap model,HttpSession session){ 
        model.put( "userObj" , session.getAttribute( "user" ) != null ? session.getAttribute( "user" ) : "{}" );
        return "register";   
    }
    
     @RequestMapping(value="validate.htm", method=RequestMethod.GET)
    public String loginValidation(@ModelAttribute("user") OnlineUser user, ModelMap model, HttpSession session)
    {        
       Connector con = new Connector();
       user = con.loginQuery(user.getEmail(), user.getPassword());
        if (user != null){
            session.setAttribute("user", user);
            model.put("userObj", user);
            return "redirect:/menuView.htm";   
        }
        else {
            model.put( "userObj" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );
            model.addAttribute("error", "Invalid username/password.");
            return "login";  
        }   
    }
    
     @RequestMapping(value="registerProcess.htm", method=RequestMethod.POST)
    public String registration(@ModelAttribute("user") UserAndAddress user, ModelMap model){
       Connector con = new Connector();
       con.registerNewUserQuery(user.getFirstName(),user.getLastName(), user.getEmail(), user.getPassword(),  user.getStreet(), user.getCity(), user.getState(), user.getZip());
       return "login";       
    }
    
    



}
