package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Menu;
import com.cjrj.edu.mapper.MenuMapper;
import com.cjrj.edu.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements MenuService{
    @Resource
    private MenuMapper menuMapper;

    @Override
    public Set<Menu> findMenus(String username) {
        return menuMapper.findMenus(username);
    }
}
