package com.cjrj.edu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cjrj.edu.entity.Role_User;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface Role_UserMapper extends BaseMapper<Role_User> {
    @Delete({
        "delete from T_ROLE_USER",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into T_ROLE_USER (ID, ROLEID, ",
        "USERID, CREATEDATE, ",
        "CREATENAME, MODIFYDATE, ",
        "MODIFYNAME, DEL_FLAG)",
        "values (#{id,jdbcType=DECIMAL}, #{roleid,jdbcType=DECIMAL}, ",
        "#{userid,jdbcType=DECIMAL}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{createname,jdbcType=VARCHAR}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{modifyname,jdbcType=VARCHAR}, #{delFlag,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select user_seq.nextval from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insertRoleUser(Role_User record);

    int insertSelective(Role_User record);

    @Select({
        "select",
        "ID, ROLEID, USERID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG",
        "from T_ROLE_USER",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.Role_UserMapper.BaseResultMap")
    Role_User selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Role_User record);

    @Update({
        "update T_ROLE_USER",
        "set ROLEID = #{roleid,jdbcType=DECIMAL},",
          "USERID = #{userid,jdbcType=DECIMAL},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Role_User record);
}