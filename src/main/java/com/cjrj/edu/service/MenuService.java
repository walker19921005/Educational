package com.cjrj.edu.service;

import com.cjrj.edu.entity.Menu;
import com.cjrj.edu.entity.vo.MenuVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface MenuService {
    List<MenuVO> findMenus(String username, BigDecimal parentid);
}
