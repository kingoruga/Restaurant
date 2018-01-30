package com.syntel.DAO;

import com.syntel.domain.OnlineUser;
import com.syntel.domain.Orders;
import java.util.List;

public interface OnlineUserDAO {
    boolean insertUser(OnlineUser user);
    OnlineUser getUser(String username, String password);
    List<Orders> getOrdersFor(OnlineUser user); 
}
