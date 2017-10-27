package com.cjrj.edu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cjrj.edu.entity.Menu;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.cjrj.edu.entity.vo.MenuVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
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
    int insertMenu(Menu record);

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

    @Select({
            "SELECT ",
            "m.MENU_ID, m.MENU_NAME, m.PARENTID, m.SEQUENCES, m.MENU_ICON, m.MENU_URL, m.ENABLE ",
            "from T_MENU m",
            "LEFT JOIN T_ROLE_MENU rm ON m.MENU_ID = rm.MENUID",
            "LEFT JOIN T_ROLE r ON rm.ROLEID = r.ROLE_ID ",
            "LEFT JOIN T_ROLE_USER ru ON r.ROLE_ID = ru.ROLEID",
            "LEFT JOIN T_USER u ON ru.USERID = u.USER_ID ",
            "WHERE u.USERNAME=#{username} AND m.PARENTID=#{parentid} AND m.ENABLE=1 ORDER BY m.SEQUENCES"
    })
    List<MenuVO> findMenus(@Param("username") String username,@Param("parentid") BigDecimal parentid);
}