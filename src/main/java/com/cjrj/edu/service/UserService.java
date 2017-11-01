package com.cjrj.edu.service;

import com.cjrj.edu.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    User findByUsername(String username);

    int insertSelective(User record);

    User findByEmail(String email);

    List<User> selectAllUser();
}
