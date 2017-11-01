package com.cjrj.edu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cjrj.edu.entity.Role;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends BaseMapper<Role> {
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

    @Select({
            "SELECT ",
            "ROLE_ID, ROLE_NAME, ROLE_DESC, PARENTID, CREATEDATE, CREATENAME, MODIFYDATE, ",
            "MODIFYNAME, DEL_FLAG, ENABLE",
            "from T_ROLE r",
            "LEFT JOIN T_ROLE_USER ru",
            "ON r.ROLE_ID = ru.ROLEID",
            "where ru.USERID= = #{username}"
    })
    Set<Role> findRoles(@Param("username") String username);

    @Select({
            "SELECT ",
            "ROLE_ID, ROLE_NAME, ROLE_DESC, PARENTID, DEL_FLAG, ENABLE",
            "from T_ROLE"
    })
    Set<Role> selectAllRoles();

    @Select({
            "SELECT ",
            "r.ROLE_ID, r.ROLE_NAME, r.ROLE_DESC, r.PARENTID, r.DEL_FLAG, r.ENABLE",
            "from T_ROLE r LEFT JOIN T_ROLE_USER ru ON r.ROLE_ID = ru.ROLEID ",
            "WHERE ru.USERID=#{userId}"
    })
    List<Role> findRolesByUserId(BigDecimal userId);
}