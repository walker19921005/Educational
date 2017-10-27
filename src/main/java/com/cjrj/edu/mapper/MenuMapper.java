package com.cjrj.edu.mapper;

import com.cjrj.edu.entity.Menu;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {
    @Delete({
        "delete from T_MENU",
        "where MENU_ID = #{menuId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal menuId);

    @Insert({
        "insert into T_MENU (MENU_ID, MENU_NAME, ",
        "PARENTID, SEQUENCES, ",
        "MENU_ICON, MENU_URL, ",
        "ENABLE, CREATEDATE, ",
        "CREATENAME, MODIFYDATE, ",
        "MODIFYNAME, DEL_FLAG)",
        "values (#{menuId,jdbcType=DECIMAL}, #{menuName,jdbcType=VARCHAR}, ",
        "#{parentid,jdbcType=DECIMAL}, #{sequences,jdbcType=DECIMAL}, ",
        "#{menuIcon,jdbcType=VARCHAR}, #{menuUrl,jdbcType=VARCHAR}, ",
        "#{enable,jdbcType=DECIMAL}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{createname,jdbcType=VARCHAR}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{modifyname,jdbcType=VARCHAR}, #{delFlag,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select menu_seq.nextval from dual", keyProperty="menuId", before=true, resultType=BigDecimal.class)
    int insert(Menu record);

    int insertSelective(Menu record);

    @Select({
        "select",
        "MENU_ID, MENU_NAME, PARENTID, SEQUENCES, MENU_ICON, MENU_URL, ENABLE, CREATEDATE, ",
        "CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG",
        "from T_MENU",
        "where MENU_ID = #{menuId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.MenuMapper.BaseResultMap")
    Menu selectByPrimaryKey(BigDecimal menuId);

    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update T_MENU",
        "set MENU_NAME = #{menuName,jdbcType=VARCHAR},",
          "PARENTID = #{parentid,jdbcType=DECIMAL},",
          "SEQUENCES = #{sequences,jdbcType=DECIMAL},",
          "MENU_ICON = #{menuIcon,jdbcType=VARCHAR},",
          "MENU_URL = #{menuUrl,jdbcType=VARCHAR},",
          "ENABLE = #{enable,jdbcType=DECIMAL},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL}",
        "where MENU_ID = #{menuId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Menu record);
}