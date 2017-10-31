package com.cjrj.edu.mapper;

import com.cjrj.edu.entity.Examine;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ExamineMapper {
    @Delete({
        "delete from T_EXAMINE",
        "where EX_ID = #{exId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal exId);

    @Insert({
        "insert into T_EXAMINE (EX_ID, EX_COURSE, ",
        "CONID, EX_SCORE, ",
        "TEACHID, REGITNAME, ",
        "REGITDATE, MODIFYNAME, ",
        "MODIFYDATE, DEL_FLAG, ",
        "STUID, REMARK)",
        "values (#{exId,jdbcType=DECIMAL}, #{exCourse,jdbcType=VARCHAR}, ",
        "#{conid,jdbcType=DECIMAL}, #{exScore,jdbcType=DECIMAL}, ",
        "#{teachid,jdbcType=DECIMAL}, #{regitname,jdbcType=VARCHAR}, ",
        "#{regitdate,jdbcType=TIMESTAMP}, #{modifyname,jdbcType=VARCHAR}, ",
        "#{modifydate,jdbcType=TIMESTAMP}, #{delFlag,jdbcType=DECIMAL}, ",
        "#{stuid,jdbcType=DECIMAL}, #{remark,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select examine_seq.nextval from dual", keyProperty="exId", before=true, resultType=BigDecimal.class)
    int insert(Examine record);

    int insertSelective(Examine record);

    @Select({
        "select",
        "EX_ID, EX_COURSE, CONID, EX_SCORE, TEACHID, REGITNAME, REGITDATE, MODIFYNAME, ",
        "MODIFYDATE, DEL_FLAG, STUID, REMARK",
        "from T_EXAMINE",
        "where EX_ID = #{exId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.ExamineMapper.BaseResultMap")
    Examine selectByPrimaryKey(BigDecimal exId);

    int updateByPrimaryKeySelective(Examine record);

    @Update({
        "update T_EXAMINE",
        "set EX_COURSE = #{exCourse,jdbcType=VARCHAR},",
          "CONID = #{conid,jdbcType=DECIMAL},",
          "EX_SCORE = #{exScore,jdbcType=DECIMAL},",
          "TEACHID = #{teachid,jdbcType=DECIMAL},",
          "REGITNAME = #{regitname,jdbcType=VARCHAR},",
          "REGITDATE = #{regitdate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL},",
          "STUID = #{stuid,jdbcType=DECIMAL},",
          "REMARK = #{remark,jdbcType=VARCHAR}",
        "where EX_ID = #{exId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Examine record);
}