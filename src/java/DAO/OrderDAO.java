package DAO;

import model.Address;
import model.OnlineUser;
import model.Orders;

import java.util.Date;

public interface OrderDAO {
    boolean insertOrder(Orders order, Address address, OnlineUser user, Date deliveryDate, String foodData);
}
