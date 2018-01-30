
package controller;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import java.sql.*;
import model.FoodItem;



 class FoodRowMapper implements RowMapper 
{
     
      @Override
      public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
            
            System.out.println("TEst");
            FoodItem fitem = new FoodItem();
            fitem.setName(rs.getString(1));
            System.out.println("TEst1");
            fitem.setDescription(rs.getString(2));
            System.out.println("TEst2");
            fitem.setPrice(rs.getFloat(3));
            System.out.println("TEst3");
            fitem.setType(rs.getString(4));
            System.out.println("TEst4");
            fitem.setVeg(rs.getString(5));
            System.out.println("TEst5");
            return fitem;
        }      
}