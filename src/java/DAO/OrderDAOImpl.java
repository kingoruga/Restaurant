package DAO;

import model.Address;
import model.OnlineUser;
import model.Orders;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class OrderDAOImpl implements OrderDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Address getAddress(Address address) {
        String p_query = "select * from address where street=? and city=? and zip_code=? and state=?";
        AddressRowMapper k = new AddressRowMapper();
        Object[] params = {
                address.getStreet1(), address.getCity(),
                address.getZip(), address.getState() };
        List result = jdbcTemplate.query(p_query, params, k);

        if (result.size() > 0)
            return (Address) (result.get(0));
        return null;
    }
    
    // Either just get the key if it exists on the object or insert it and
    // then get the key
    private int getAddressKey(Address address) {
        Address a = getAddress(address);
        int key;

        if (a == null) {
            // insert the address
            String p_query = "INSERT INTO "
                    + "ADDRESS (STREET, CITY, ZIP_CODE, STATE) "
                    + "VALUES (?,?,?,?)";
            Object[] params = {
                    address.getStreet1(), address.getCity(),
                    address.getZip(), address.getState()};
            jdbcTemplate.update(p_query, params);

            // Then painstaking make a query from the same information,
            // just to get the key to use later
            p_query = "SELECT * FROM address WHERE street=? AND city=? AND zip_code=? AND state=?";
            AddressRowMapper k = new AddressRowMapper();
            List result = jdbcTemplate.query(p_query, params, k);
            key = ((Address) (result.get(0))).getAddressId();
        }
        
        else {
            key = a.getAddressId();
        }
        
        return key;
    }

    @Override
    public boolean insertOrder(Orders order, Address address, OnlineUser user, Date deliveryDate, String foodData) {

        int key = getAddressKey(address);
        
        // Then insert order
        String p_query = "insert into "
                + "ORDERS (USER_ID, ADDRESS_ID, PAYMENT_TYPE, ORDER_DATE, PRICE, DELIVERY_DATE) "
                + "values (?, ?, ?, ?, ?, ?)";
        java.sql.Date now = new java.sql.Date(new Date().getTime());
        java.sql.Date then = new java.sql.Date(deliveryDate.getTime());
        Object[] userParams = {
                user.getUserId(), key, order.getPaymentMethod(),
                now, order.getPrice(), then  };
        jdbcTemplate.update(p_query, userParams);

        // Once again, painstakingly make a query to get the same information
        p_query = "select ORDER_ID from orders " +
                "where USER_ID=? and ADDRESS_ID=? and PAYMENT_TYPE=? and ORDER_DATE=? ORDER BY order_id desc";
        Object[] orderParams = { user.getUserId(), key, order.getPaymentMethod(), now };
        int[] orderArgs = { Types.NUMERIC, Types.NUMERIC, Types.VARCHAR, Types.DATE };
        int orderId = jdbcTemplate.query(p_query, orderParams, orderArgs, ok -> {
            ok.next();
            return ok.getInt(1);
        });

        String[] items = foodData.split("\\|");
        for(String item: items) {

            List<Integer> values = Arrays.stream(item.split(",")).map(Integer::parseInt).collect(toList());
            int id = values.get(0);
            int quantity = values.get(1);
            
            String orderQuery = "insert into ORDER_ITEMS (ORDER_ID, FOOD_ITEM_ID, QUANTITY) VALUES (?, ?, ?)";
            Object[] orderItemParams = { orderId, id, quantity };
            jdbcTemplate.update(orderQuery, orderItemParams);
        }

        return true;
    }

    @Override
    public boolean changeOrderAddress(int orderId, Address address) {
        try {
            int key = getAddressKey(address);
            String p_query = "update orders "
                    + "set address_id=? "
                    + "where order_id=?";
            Object[] params = { key, orderId };
            jdbcTemplate.update(p_query, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean changeDate(int orderId, String date) {
        try {
            Date javaDate = new SimpleDateFormat("yy-MM-dd HH:mm:ss").parse(date);
            java.sql.Date now = new java.sql.Date(javaDate.getTime());
            
            String p_query = "update orders "
                    + "set delivery_date=? "
                    + "where order_id=?";
            Object[] params = { now, orderId };
            int[] args = { Types.DATE, Types.NUMERIC };
            jdbcTemplate.update(p_query, params, args);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Map<String, Integer> getAmountOfFoodItemInOrder(int orderId) {
        String p_query = "select food_item_id, quantity from order_items "
                + "where order_id=? ";
        Object[] params = { orderId };
        return jdbcTemplate.query(p_query, params, (rs) -> {
            Map<String, Integer> values = new HashMap<>();
            while (rs.next()) {
                values.put(Integer.toString(rs.getInt(1)), rs.getInt(2));
            }
            return values;
        });
    }
    
}