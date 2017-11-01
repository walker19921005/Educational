package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Role;
import com.cjrj.edu.mapper.RoleMapper;
import com.cjrj.edu.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService{
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Set<Role> findRoles(String username) {
        return roleMapper.findRoles(username);
    }

    @Override
    public Set<Role> selectAllRoles() {
        return roleMapper.selectAllRoles();
    }
}
