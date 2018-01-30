/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.DAO;

import com.syntel.domain.Address;
import com.syntel.domain.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author syntel
 */
public class OrdersRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Orders o = new Orders();
        
        o.setOrderId(rs.getInt(1));
        o.setUserId(rs.getInt(2));
        o.setAddressId(rs.getInt(3));
        o.setPaymentMethod(rs.getString(4));
        o.setOrderDate(rs.getString(5));
        o.setPrice(rs.getFloat(6));
        o.setDeliveryDate(rs.getString(7));
        o.setTime(rs.getString(8));
        
        return o;
    }
}
