package com.cjrj.edu.mapper;

import com.cjrj.edu.entity.Role_Menu;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface Role_MenuMapper {
    @Delete({
        "delete from T_ROLE_MENU",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into T_ROLE_MENU (ID, ROLEID, ",
        "MENUID, CREATEDATE, ",
        "CREATENAME, MODIFYDATE, ",
        "MODIFYNAME, DEL_FLAG)",
        "values (#{id,jdbcType=DECIMAL}, #{roleid,jdbcType=DECIMAL}, ",
        "#{menuid,jdbcType=DECIMAL}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{createname,jdbcType=VARCHAR}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{modifyname,jdbcType=VARCHAR}, #{delFlag,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select user_seq.nextval from dual", keyProperty="id", before=true, resultType=BigDecimal.class)
    int insert(Role_Menu record);

    int insertSelective(Role_Menu record);

    @Select({
        "select",
        "ID, ROLEID, MENUID, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG",
        "from T_ROLE_MENU",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.Role_MenuMapper.BaseResultMap")
    Role_Menu selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Role_Menu record);

    @Update({
        "update T_ROLE_MENU",
        "set ROLEID = #{roleid,jdbcType=DECIMAL},",
          "MENUID = #{menuid,jdbcType=DECIMAL},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Role_Menu record);
}