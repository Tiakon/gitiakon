package com.tiakon.service;

import com.tiakon.entity.User;

/**
 * Created by Hoictas on 2017/8/8.
 */
public interface UserService {
    User login(User user) throws Exception;
}
