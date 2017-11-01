package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Role_User;
import com.cjrj.edu.entity.Student;
import com.cjrj.edu.entity.User;
import com.cjrj.edu.mapper.Role_UserMapper;
import com.cjrj.edu.mapper.StudentMapper;
import com.cjrj.edu.mapper.UserMapper;
import com.cjrj.edu.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private Role_UserMapper roleUserMapper;


    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    @Transactional
    public int insertSelective(User record) {
        userMapper.insertSelective(record);
        record = findByUsername(record.getUsername());
        Role_User roleUser = new Role_User();
        roleUser.setUserid(record.getUserId());
        if (record.getDeptid().equals(new BigDecimal(1))) {
            return 0;
        } else if (record.getDeptid().equals(new BigDecimal(2))) {
            Student student = new Student();
            student.setUserid(record.getUserId());
            studentMapper.insertSelective(student);
            roleUser.setRoleid(new BigDecimal(4));
            return roleUserMapper.insertSelective(roleUser);
        }else {
            return 0;
        }
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }
}
