package com.cjrj.edu.service;

import com.cjrj.edu.entity.Menu;

import java.util.Set;

public interface MenuService {
    Set<Menu> findMenus(String username);
}
