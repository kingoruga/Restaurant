/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Address;
import model.FoodItem;
import model.OnlineUser;
import model.Orders;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

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
                + "online_user (first_name, last_name, is_admin, password, email, address_id, status) "
                + "values (?,?,?,?,?,?,?)";
        Object[] secondParams = {
                user.getFirstName(), user.getLastName(), "no",
                user.getPassword(), user.getEmail(), key,
                user.isIsBanned() ? "Disabled" : "Enabled" };
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

    @Override
    public List<Orders> getOrdersFor(OnlineUser user) {
        
        // Get user information
        String p_query = "select * from orders where user_id=?";
        Object[] params = { user.getUserId() };
        int[] args = { Types.NUMERIC };
        OrdersRowMapper rowMapper = new OrdersRowMapper();
        List<Orders> result = (List<Orders>) jdbcTemplate
                .query(p_query, params, args, rowMapper)
                .stream().map(o -> (Orders) o)
                .collect(toList());
        
        // Fill each order with it's array of items and it's address
        for(Orders o: result) {
            
            // get food ids
            p_query = "select distinct food_item_id from order_items where order_id=?";
            Object[] foodParams = { o.getOrderId() };
            int[] foodArgs = { Types.NUMERIC };
            
            ArrayList<FoodItem> food = (ArrayList<FoodItem>) jdbcTemplate 
                // Get every id associated with this order 
                .query(p_query, foodParams, foodArgs, (rs) -> {
                    List<Integer> rid = new ArrayList<>();
                    while (rs.next())
                        rid.add(rs.getInt(1));
                    return rid;
                // Get food item associated with that id
                }).stream().map((id) -> {
                    String fQuery = "select * from food_item where food_item_id=?";
                    Object[] fParam = { id };
                    int[] fArg = { Types.NUMERIC };
                    List fResult = jdbcTemplate.query(fQuery, fParam, fArg, new FoodItemRowMapper());
                    return (FoodItem) fResult.get(0);
                }).collect(toList());
            
            o.setItems(food);
            
            // get address
            p_query = "select * from address where address_id=?";
            Object[] addressParams = { o.getAddressId()};
            int[] addressArgs = { Types.NUMERIC };
            List aResult = jdbcTemplate.query(p_query, addressParams, addressArgs, new AddressRowMapper());
            if (aResult.size() > 0)
                o.setOrderAddress((Address) aResult.get(0));
        }
            
        
        return result;
    }
}

