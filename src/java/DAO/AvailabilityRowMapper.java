
package DAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import java.sql.*;
import model.Availability;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



 class AvailabilityRowMapper implements RowMapper 
{
     
      @Override
      public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
            DateFormat output = new SimpleDateFormat("dd-MMM-yy");
            DateFormat input = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            java.util.Date date;
            Availability av = new Availability();
            try{
                
                av.setZip(rs.getInt(1));
            
                av.setMeal(rs.getString(2));
                date = input.parse(rs.getString(3));            
                av.setStart_date(output.format(date));
            
                date=input.parse(rs.getString(4));
                av.setEnd_date(output.format(date));            
                
            }catch(ParseException e){
                System.out.println(e.getMessage());
            }
            return av;
            
                        
           
        }      
}