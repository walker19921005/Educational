package com.cjrj.edu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cjrj.edu.entity.User;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Delete({
        "delete from T_USER",
        "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal userId);

    @Insert({
        "insert into T_USER (USER_ID, USERNAME, ",
        "PASSWORD, CREATEDATE, ",
        "CREATENAME, MODIFYDATE, ",
        "MODIFYNAME, DEL_FLAG, ",
        "EMAIL, DEPTID, SALT, ",
        "LOCKED)",
        "values (#{userId,jdbcType=DECIMAL}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{createname,jdbcType=VARCHAR}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{modifyname,jdbcType=VARCHAR}, #{delFlag,jdbcType=DECIMAL}, ",
        "#{email,jdbcType=VARCHAR}, #{deptid,jdbcType=DECIMAL}, #{salt,jdbcType=VARCHAR}, ",
        "#{locked,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select user_seq.nextval from dual", keyProperty="userId", before=true, resultType=BigDecimal.class)
    int insertUser(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "USER_ID, USERNAME, PASSWORD, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, ",
        "DEL_FLAG, EMAIL, DEPTID, SALT, LOCKED",
        "from T_USER",
        "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(BigDecimal userId);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update T_USER",
        "set USERNAME = #{username,jdbcType=VARCHAR},",
          "PASSWORD = #{password,jdbcType=VARCHAR},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL},",
          "EMAIL = #{email,jdbcType=VARCHAR},",
          "DEPTID = #{deptid,jdbcType=DECIMAL},",
          "SALT = #{salt,jdbcType=VARCHAR},",
          "LOCKED = #{locked,jdbcType=DECIMAL}",
        "where USER_ID = #{userId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(User record);

    @Select({
            "select",
            "USER_ID, USERNAME, PASSWORD, DEL_FLAG, EMAIL, DEPTID, SALT, LOCKED",
            "from T_USER",
            "where USERNAME = #{username}"
    })
    User findByUsername(String username);
}