package com.cjrj.edu.service;

import com.cjrj.edu.entity.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> findRoles(String username);
    Set<Role> selectAllRoles();
}
