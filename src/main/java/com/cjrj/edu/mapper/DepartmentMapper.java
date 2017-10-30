package com.cjrj.edu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cjrj.edu.entity.Department;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper extends BaseMapper<Department> {
    @Delete({
        "delete from USER_DEPARTMENT",
        "where DEPT_ID = #{deptId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal deptId);

    @Insert({
        "insert into USER_DEPARTMENT (DEPT_ID, DEPT_NAME, ",
        "DEPT_DESC, CREATEDATE, ",
        "CREATENAME, MODIFYNAME, ",
        "MODIFYDATE, DEL_FLAG)",
        "values (#{deptId,jdbcType=DECIMAL}, #{deptName,jdbcType=VARCHAR}, ",
        "#{deptDesc,jdbcType=VARCHAR}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{createname,jdbcType=VARCHAR}, #{modifyname,jdbcType=NVARCHAR}, ",
        "#{modifydate,jdbcType=TIMESTAMP}, #{delFlag,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select dept_seq.nextval from dual", keyProperty="deptId", before=true, resultType=BigDecimal.class)
    int insertDept(Department record);

    int insertSelective(Department record);

    @Select({
        "select",
        "DEPT_ID, DEPT_NAME, DEPT_DESC, CREATEDATE, CREATENAME, MODIFYNAME, MODIFYDATE, ",
        "DEL_FLAG",
        "from USER_DEPARTMENT",
        "where DEPT_ID = #{deptId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.DepartmentMapper.BaseResultMap")
    Department selectByPrimaryKey(BigDecimal deptId);

    int updateByPrimaryKeySelective(Department record);

    @Update({
        "update USER_DEPARTMENT",
        "set DEPT_NAME = #{deptName,jdbcType=VARCHAR},",
          "DEPT_DESC = #{deptDesc,jdbcType=VARCHAR},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYNAME = #{modifyname,jdbcType=NVARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL}",
        "where DEPT_ID = #{deptId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Department record);

    @Select({
            "select",
            "DEPT_ID, DEPT_NAME, DEPT_DESC, CREATEDATE, CREATENAME, MODIFYNAME, MODIFYDATE, ",
            "DEL_FLAG",
            "from USER_DEPARTMENT"
    })
    @ResultMap("com.cjrj.edu.mapper.DepartmentMapper.BaseResultMap")
    List<Department> selectAllDept();
}