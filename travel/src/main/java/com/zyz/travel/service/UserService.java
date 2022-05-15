package com.zyz.travel.service;

import com.zyz.travel.domain.User;

public interface UserService {
    boolean regist(User user);

    Boolean active(String code);

    User login(User user);
}
