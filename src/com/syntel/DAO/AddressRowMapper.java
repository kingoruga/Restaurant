package com.syntel.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.syntel.domain.Address;
import org.springframework.jdbc.core.RowMapper;

public class AddressRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Address a = new Address();
        
        a.setAddressId(rs.getInt(1));
        a.setStreet1(rs.getString(2));
        a.setCity(rs.getString(3));
        a.setZip(Integer.toString(rs.getInt(4)));
        a.setState(rs.getString(5));
        
        return a;
    }
}
