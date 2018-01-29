/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.DAO;

import com.syntel.domain.OnlineUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author syntel
 */
public class OnlineUserRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        OnlineUser user = new OnlineUser();
        
        user.setUserId(rs.getInt(1));
        user.setFirstName(rs.getString(2));
        user.setLastName(rs.getString(3));
        user.setIsAdmin(rs.getString(4) != null ? rs.getString(4).equalsIgnoreCase("yes") : false);
        user.setPassword(rs.getString(5));
        user.setEmail(rs.getString(6));
        user.setAddressId(rs.getInt(7));
        user.setIsBanned(rs.getString(8).equals("0"));
        
        return user;
    }
}