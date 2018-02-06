/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.FoodItem;
import model.Availability;
import model.AvailabilityWrapper;
import DAO.FoodDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.OnlineUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
/**
 *
 * @author syntel
 */

@Controller
public class PackageController {
    
   private static FoodItem foodItem = null;
    
   @RequestMapping(value = "/createfood.htm", method = RequestMethod.GET)
   public String food(HttpSession session, Model model){
       model.addAttribute("createfood",new FoodItem());
       model.addAttribute("user" , session.getAttribute( "user" ) != null ? session.getAttribute("user" ) : "{}" );
      return "createfood";
   }
    
    @RequestMapping(value="createfood" ,method=RequestMethod.POST)
    public String addFood(@ModelAttribute("createfood") FoodItem fooditem ){
        foodItem = fooditem;
        foodItem.createAvailability(new ArrayList<Availability>());
      
      return "redirect:availability.htm";
    }
    
   @RequestMapping(value = "/availability.htm", method = RequestMethod.GET)
   public String availability(Model model, HttpSession session ){
       model.addAttribute("availability",new Availability());
       model.addAttribute( "user" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );
      return "availability";   }
   
   
   @RequestMapping(value="availability" ,method=RequestMethod.POST)
    public String addAvailability(@ModelAttribute("availability") Availability av){  
      foodItem.setAvailability(av);          
      return "redirect:commit.htm";
    }
   
   
   
   @RequestMapping(value = "/commit.htm", method = RequestMethod.GET)
   public String commit(Model model, HttpSession session ){
       model.addAttribute("commit",new Availability());
       model.addAttribute( "user" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );
      return "commit";   
   }   
    
    
    @RequestMapping(value="commit" ,method=RequestMethod.POST)
    public String commitChanges(@ModelAttribute("commit") Availability av){                 
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../applicationContext.xml");
        FoodDAO foodDOA=(FoodDAO)ctx.getBean("foodDAO");
        foodDOA.createFoodQuery(foodItem);              
        foodItem=null;    
      return "redirect:managePackages.htm";
    }
    
    
   @RequestMapping(value = "/findfood.htm", method = RequestMethod.GET)
   public String find(Model model, HttpSession session ){
       model.addAttribute("findfood",new FoodItem());
       model.addAttribute( "user" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );
      return "findfood";   }   
    
    
    @RequestMapping(value="findfood" ,method=RequestMethod.POST)
    public ModelAndView findFood(@ModelAttribute("findfood") FoodItem fitem){   
        if(foodItem==null){
            ApplicationContext ctx=new ClassPathXmlApplicationContext("../applicationContext.xml");
            FoodDAO foodDOA=(FoodDAO)ctx.getBean("foodDAO");
            foodItem = foodDOA.getFoodQuery(fitem);       
        
            fitem = foodItem;
        
      
            return new ModelAndView("editfood","editfood",fitem);
        }else{
            
            fitem.createAvailability(foodItem.getAvailability());            
            foodItem=fitem;
                 
            return new ModelAndView("redirect:editav.htm");
            
        }
                
       
    }    
    
    @RequestMapping(value = "/editfood.htm", method = RequestMethod.GET)
    public String edit(Model model , HttpSession session ){
       model.addAttribute("editfood",new FoodItem());
       model.addAttribute( "user" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );
      return "editfood";   
    }   
    
    
    @RequestMapping(value = "/deletefood.htm", method = RequestMethod.GET)
    public String delete(Model model , HttpSession session ){
       model.addAttribute("deletefood",new FoodItem());
       model.addAttribute( "user" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );
      return "deletefood";   
    }   
    
    
    @RequestMapping(value="deletefood" ,method=RequestMethod.POST)
    public ModelAndView deleteFood(@ModelAttribute("deletefood") FoodItem fitem){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../applicationContext.xml");
        FoodDAO foodDAO=(FoodDAO)ctx.getBean("foodDAO");
        foodDAO.deleteFoodQuery(fitem);     
      return new ModelAndView("redirect:managePackages.htm");
    }
    
    
    @RequestMapping(value = "/editav.htm", method = RequestMethod.GET)
    public String editAv(Model model , HttpSession session ){        
        AvailabilityWrapper avwrap = new AvailabilityWrapper();
        avwrap.setAv(foodItem.getAvailability());
        model.addAttribute("editav",avwrap);      
        model.addAttribute( "user" , session.getAttribute( "user" ) != null ? session.getAttribute("user") : "{}" );            
      return "editav";   }   
    
    
    @RequestMapping(value="editav" ,method=RequestMethod.POST)
    public ModelAndView addAv(@ModelAttribute("editav") AvailabilityWrapper avwrap){    
        foodItem.createAvailability(avwrap.getAv());      
        ApplicationContext ctx=new ClassPathXmlApplicationContext("../applicationContext.xml");
        FoodDAO foodDAO=(FoodDAO)ctx.getBean("foodDAO");          
        foodDAO.deleteFoodQuery(foodItem);            
        foodDAO.createFoodQuery(foodItem);       
        foodItem=null;
       return new ModelAndView("redirect:managePackages.htm");
    }   
    
    @RequestMapping(value="managePackages.htm",method=RequestMethod.GET )
    public ModelAndView packageIndex( HttpSession session )
    {
        OnlineUser user = (OnlineUser)session.getAttribute("user");
        
        if(user.getIsAdmin()){
              return new ModelAndView( "managePackages" , "user" , 
                session.getAttribute( "user" ) != null ? session.getAttribute("user" ) : "{}" );
        }
      return new ModelAndView( "unauthorized");
    }
    
}
