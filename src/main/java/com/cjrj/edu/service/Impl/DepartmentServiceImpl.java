package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Department;
import com.cjrj.edu.mapper.DepartmentMapper;
import com.cjrj.edu.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department> implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAllDept() {
        return departmentMapper.selectAllDept();
    }
}
