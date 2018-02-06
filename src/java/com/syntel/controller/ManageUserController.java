/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import model.Connector;
import model.OnlineUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author syntel
 */

@Controller("/manageUsers")
//@SessionAttributes("users")

public class ManageUserController {
    

    @RequestMapping("/manageUsers.htm")
    public String manageUsers(HttpSession session,ModelMap model){
       // userMgt = new ManageUserDAO();
       Connector con = new Connector();
        List <OnlineUser> users = con.getAllUsers();
        model.put("users", users);
        model.put( "user" , session.getAttribute("user") != null ? session.getAttribute("user") : "{}" );
        OnlineUser user = (OnlineUser)session.getAttribute("user");
        if(user.getIsAdmin()) {
            return "manageUsers";
        }
        return "unauthorized";
    }
    
    @RequestMapping(value="delete.htm", method=RequestMethod.GET)
    public String deleteUser(HttpSession session,ModelMap model, @RequestParam String email){
        Connector con = new Connector();
        con.deleteUserQuery(email);
        List <OnlineUser> users = con.getAllUsers();
        model.put("users", users);
        model.put( "user" , session.getAttribute("user") != null ? session.getAttribute("user") : "{}" );
        return "manageUsers";
    }
    
    @RequestMapping(value="enable.htm", method=RequestMethod.GET)
    public String enableUser(HttpSession session,ModelMap model, @RequestParam String email){
        Connector con = new Connector();
        con.enableUserQuery(email);
        List <OnlineUser> users = con.getAllUsers();
        model.put("users", users);
        model.put( "user" , session.getAttribute("user") != null ? session.getAttribute("user") : "{}" );
        return "manageUsers";
    }
    
     @RequestMapping(value="disable.htm", method=RequestMethod.GET)
    public String disableUser(HttpSession session,ModelMap model, @RequestParam String email){
        Connector con = new Connector();
        con.disableUserQuery(email);
        List <OnlineUser> users = con.getAllUsers();
        model.put("users", users);
        model.put( "user" , session.getAttribute("user") != null ? session.getAttribute("user") : "{}" );
        return "manageUsers";
    }
    
     @RequestMapping(value="/changepassword.htm", method=RequestMethod.GET)
    public void changePassword(HttpSession session,@ModelAttribute("user") OnlineUser user, ModelMap model){
        Connector con = new Connector();
        con.changePasswordQuery(user.getEmail(), user.getPassword());
        model.put( "user" , session.getAttribute("user") != null ? session.getAttribute("user") : "{}" );
       // return "changepassword";
    }

    
}
