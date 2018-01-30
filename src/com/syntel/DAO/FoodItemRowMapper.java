/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.DAO;

import com.syntel.domain.Address;
import com.syntel.domain.FoodItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author syntel
 */
public class FoodItemRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        FoodItem f = new FoodItem();
        
        f.setFoodItemId(rs.getInt(1));
        f.setName(rs.getString(2));
        f.setDescription(rs.getString(3));
        f.setPrice(rs.getFloat(4));
        f.setType(rs.getString(5));
        f.setIsVeg(rs.getString(6).equals("1"));
        // f.setImage(rs.getBlob(7))
        
        return f;
    }
}
