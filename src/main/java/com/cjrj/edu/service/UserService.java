package com.cjrj.edu.service;

import com.cjrj.edu.entity.User;

public interface UserService {
    User findByUsername(String username);
    int insertSelective(User record);
    User findByEmail(String email);
}
