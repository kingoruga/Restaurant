package com.syntel.DAO;

import com.syntel.domain.Address;
import com.syntel.domain.OnlineUser;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class OnlineUserDAOImpl implements OnlineUserDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insertUser(OnlineUser user) {
        // If we're able to get the user they already exist
        if (getUser(user.getEmail(), user.getPassword()) != null)
            return false;
        
        // First insert the address
        String p_query = "insert into "
                + "address (street, city, zip_code, state) "
                + "values (?,?,?,?)";
        Object[] params = {
            user.getAddress().getStreet1(), user.getAddress().getCity(), 
            user.getAddress().getZip(), user.getAddress().getState() };
        jdbcTemplate.update(p_query, params);
        
        // Then painstaking make a query from the same information,
        // just to get the key to use later
        p_query = "select * from address where street=? and city=? and zip_code=? and state=?";
        AddressRowMapper k = new AddressRowMapper();
        List result = jdbcTemplate.query(p_query, params, k);
        int key = ((Address) (result.get(0))).getAddressId();
        
        // Then insert the user into the database
        p_query = "insert into "
                + "online_user (first_name, last_name, password, email, address_id, status) "
                + "values (?,?,?,?,?,?)";
        Object[] secondParams = { user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), key, user.isIsBanned() ? "Disabled" : "Enabled" };
        jdbcTemplate.update(p_query, secondParams);
        
        return true;
    }

    @Override
    public OnlineUser getUser(String email, String password) {
        
        // Get user information
        String p_query = "select * from online_user where email=? and password=?";
        Object[] params = { email, password };
        int[] args = { Types.VARCHAR, Types.VARCHAR };
        OnlineUserRowMapper rowMapper = new OnlineUserRowMapper();
        List result = jdbcTemplate.query(p_query, params, args, rowMapper);
        
        if (result.size() > 0) {
            OnlineUser user = (OnlineUser) result.get(0);
            
            // Get users address information
            p_query = "select * from address where address_id=?";
            Object[] secondParams = { user.getAddressId() };
            int[] secondArgs = { Types.NUMERIC };
            AddressRowMapper addressRowMapper = new AddressRowMapper();
            result = jdbcTemplate.query(p_query, secondParams, secondArgs, addressRowMapper);
            Address address = (Address) result.get(0);
            
            user.setAddress(address);
            return user;
        }
        else
            return null;
    }

}
