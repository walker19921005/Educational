package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Menu;
import com.cjrj.edu.entity.vo.MenuVO;
import com.cjrj.edu.mapper.MenuMapper;
import com.cjrj.edu.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements MenuService{
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuVO> findMenus(String username, BigDecimal parentid) {
        List<MenuVO> list=menuMapper.findMenus(username,parentid);
        return list;
    }
}
