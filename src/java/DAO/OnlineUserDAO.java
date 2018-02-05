/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.OnlineUser;
import model.Orders;
import java.util.List;

public interface OnlineUserDAO {
    boolean insertUser(OnlineUser user);
    OnlineUser getUser(String username, String password);
    List<Orders> getOrdersFor(OnlineUser user); 
}
