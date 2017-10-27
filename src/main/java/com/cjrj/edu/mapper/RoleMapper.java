package com.cjrj.edu.mapper;

import com.cjrj.edu.entity.Role;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface RoleMapper {
    @Delete({
        "delete from T_ROLE",
        "where ROLE_ID = #{roleId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal roleId);

    @Insert({
        "insert into T_ROLE (ROLE_ID, ROLE_NAME, ",
        "ROLE_DESC, PARENTID, ",
        "CREATEDATE, CREATENAME, ",
        "MODIFYDATE, MODIFYNAME, ",
        "DEL_FLAG, ENABLE)",
        "values (#{roleId,jdbcType=DECIMAL}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleDesc,jdbcType=VARCHAR}, #{parentid,jdbcType=DECIMAL}, ",
        "#{createdate,jdbcType=TIMESTAMP}, #{createname,jdbcType=VARCHAR}, ",
        "#{modifydate,jdbcType=TIMESTAMP}, #{modifyname,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=DECIMAL}, #{enable,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select role_seq.nextval from dual", keyProperty="roleId", before=true, resultType=BigDecimal.class)
    int insertRole(Role record);

    int insertSelective(Role record);

    @Select({
        "select",
        "ROLE_ID, ROLE_NAME, ROLE_DESC, PARENTID, CREATEDATE, CREATENAME, MODIFYDATE, ",
        "MODIFYNAME, DEL_FLAG, ENABLE",
        "from T_ROLE",
        "where ROLE_ID = #{roleId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.RoleMapper.BaseResultMap")
    Role selectByPrimaryKey(BigDecimal roleId);

    int updateByPrimaryKeySelective(Role record);

    @Update({
        "update T_ROLE",
        "set ROLE_NAME = #{roleName,jdbcType=VARCHAR},",
          "ROLE_DESC = #{roleDesc,jdbcType=VARCHAR},",
          "PARENTID = #{parentid,jdbcType=DECIMAL},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL},",
          "ENABLE = #{enable,jdbcType=DECIMAL}",
        "where ROLE_ID = #{roleId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Role record);
}