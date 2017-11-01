package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Role_User;
import com.cjrj.edu.mapper.Role_UserMapper;
import com.cjrj.edu.service.RoleUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleUserServiceImpl extends ServiceImpl<Role_UserMapper,Role_User> implements RoleUserService{
    @Resource
    private Role_UserMapper roleUserMapper;

    @Override
    public int insertSelective(Role_User record) {
        return roleUserMapper.insertSelective(record);
    }
}
