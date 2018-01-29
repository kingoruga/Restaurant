package com.syntel.DAO;

import com.syntel.domain.OnlineUser;

public interface OnlineUserDAO {
    boolean insertUser(OnlineUser user);
    OnlineUser getUser(String username, String password);
}
