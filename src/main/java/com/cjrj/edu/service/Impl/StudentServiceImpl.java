package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Role;
import com.cjrj.edu.entity.Student;
import com.cjrj.edu.mapper.RoleMapper;
import com.cjrj.edu.mapper.StudentMapper;
import com.cjrj.edu.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService{
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Page<Student> selectAllStudent(Page page) {
        List<Student> list=studentMapper.selectAllStudent(page);
        for (Student stu :
                list) {
            List<Role> roleList= roleMapper.findRolesByUserId(stu.getUserid());
            BigDecimal[] roles = new BigDecimal[roleList.size()];
            for (int i=0;i<roles.length;i++) {
                roles[i]=roleList.get(i).getRoleId();
            }
            stu.setRoleId(roles);
        }

        return page.setRecords(list);
    }
}
