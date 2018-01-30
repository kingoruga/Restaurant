/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import model.FoodItem;
import model.Availability;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author syntel
 */
public class FoodDAO {
    
    JdbcTemplate jdbcTemplate;
     
   public void setDataSource(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }        
   
   public FoodItem getFoodQuery(FoodItem fitem){   
        
        Availability av = new Availability();
	Object o[]={fitem.getName()};
	int argsTypes[]={Types.VARCHAR};
	RowMapper mapper=new FoodRowMapper();
	List l= jdbcTemplate.query ( "select name,description, price,type,is_veg from food_item where name=?",o,argsTypes,mapper);
	Iterator it=l.iterator();
	fitem=(FoodItem)it.next(); 
        
        mapper = new AvailabilityRowMapper();
        
        l = jdbcTemplate.query("Select zip_code,time,begin_date,end_date from Availability where food_item_id=(Select food_item_id from food_item where name=?)",o,argsTypes,mapper);
        it = l.iterator();
        
        while(it.hasNext()){
            av = (Availability) it.next();
            
           fitem.addAvailability(av);
        }
        return fitem;        
       
   }
   
   /*
   public void getMenu(ArrayList<String> items){
        Object o[]={name};
	int argsTypes[]={Types.VARCHAR};
	items= jdbcTemplate.query ( "select name from food_item");
	
   }
    */
    
    
    public void createFoodQuery(FoodItem item) {     
    	
    	try {            
            
            ArrayList<Availability> av = item.getAvailability();
                            
            String p_query="Insert into Food_item (name,description,price,type,is_veg) values(?,?,?,?,?)";
            jdbcTemplate.update(p_query,new Object[]{
            item.getName(),item.getDescription(),item.getPrice(),item.getType(),item.getVeg()});
            
            p_query="Insert into Availability (food_item_id,zip_code,time,begin_date,end_date) values ((select food_item_id from food_item where name=?),?,?,?,?)";
            for(int i=0;i<av.size();i++){
                
                jdbcTemplate.update(p_query,new Object[]{
                item.getName(),av.get(i).getZip(),av.get(i).getMeal(),av.get(i).getStart_date(),av.get(i).getEnd_date()
                });
                
                
            }
                                   	    	
    	}catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}    	    	
    	    			
    	
    }
    
    public void deleteFoodQuery(FoodItem item){
        
        try {            
                            
            String p_query="Delete from Food_item where name=?";
            jdbcTemplate.update(p_query,new Object[]{
            item.getName()});
                        	    	
    	}catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}    
    }
    
}
