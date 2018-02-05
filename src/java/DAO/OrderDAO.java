package DAO;

import model.Address;
import model.OnlineUser;
import model.Orders;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderDAO {
    boolean insertOrder(Orders order, Address address, OnlineUser user, Date deliveryDate, String foodData);
    boolean changeOrderAddress(int orderId, Address address);
    boolean changeDate(int orderId, String date);
    Map<String, Integer> getAmountOfFoodItemInOrder(int orderId);
}