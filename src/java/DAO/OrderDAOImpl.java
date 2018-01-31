package DAO;

import model.Address;
import model.OnlineUser;
import model.Orders;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Override
    public boolean insertOrder(Orders order, Address address, OnlineUser user, Date deliveryDate, String foodData) {

        Address a = getAddress(address);
        int key;

        if (a == null) {
            // insert the address
            String p_query = "INSERT INTO "
                    + "ADDRESS (STREET, CITY, ZIP_CODE, STREET) "
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
                "where USER_ID=? and ADDRESS_ID=? and PAYMENT_TYPE=? and ORDER_DATE=?";
        Object[] orderParams = { user.getUserId(), key, order.getPaymentMethod(), now };
        int[] orderArgs = { Types.NUMERIC, Types.NUMERIC, Types.VARCHAR, Types.DATE };
        int orderId = jdbcTemplate.query(p_query, orderParams, orderArgs, ok -> {
            ok.next();
            return ok.getInt(1);
        });

        String[] items = foodData.split("\\|");
        for(String item: items) {

            System.out.println(item);

            List<Integer> values = Arrays.stream(item.split(",")).map(Integer::parseInt).collect(toList());
            int id = values.get(0);
            int quantity = values.get(1);

            String orderQuery = "insert into ORDER_ITEMS (ORDER_ID, FOOD_ITEM_ID, QUANTITY) VALUES (?, ?, ?)";
            Object[] orderItemParams = { orderId, id, quantity };
            jdbcTemplate.update(orderQuery, orderItemParams);
        }

        return true;
    }

}
