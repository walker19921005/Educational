package com.cjrj.edu.mapper;

import com.cjrj.edu.entity.Student;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {
    @Delete({
        "delete from USER_STUDENT",
        "where STU_ID = #{stuId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal stuId);

    @Insert({
        "insert into USER_STUDENT (STU_ID, USERID, ",
        "STU_NAME, SEX, STU_IPHONE, ",
        "STU_PHONE, STU_ADDRESS, ",
        "STU_BIRTHDAY, ENROLDATE, ",
        "CREATEDATE, CREATENAME, ",
        "MODIFYDATE, MODIFYNAME, ",
        "DEL_FLAG, LINKMAN, ",
        "LINKMAN_IPHONE, GRADUATEDATE, ",
        "ICON, CLASSID)",
        "values (#{stuId,jdbcType=DECIMAL}, #{userid,jdbcType=DECIMAL}, ",
        "#{stuName,jdbcType=VARCHAR}, #{sex,jdbcType=DECIMAL}, #{stuIphone,jdbcType=VARCHAR}, ",
        "#{stuPhone,jdbcType=VARCHAR}, #{stuAddress,jdbcType=VARCHAR}, ",
        "#{stuBirthday,jdbcType=TIMESTAMP}, #{enroldate,jdbcType=TIMESTAMP}, ",
        "#{createdate,jdbcType=TIMESTAMP}, #{createname,jdbcType=VARCHAR}, ",
        "#{modifydate,jdbcType=TIMESTAMP}, #{modifyname,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=DECIMAL}, #{linkman,jdbcType=VARCHAR}, ",
        "#{linkmanIphone,jdbcType=VARCHAR}, #{graduatedate,jdbcType=TIMESTAMP}, ",
        "#{icon,jdbcType=VARCHAR}, #{classid,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select student_seq.nextval from dual", keyProperty="stuId", before=true, resultType=BigDecimal.class)
    int insertStudent(Student record);

    int insertSelective(Student record);

    @Select({
        "select",
        "STU_ID, USERID, STU_NAME, SEX, STU_IPHONE, STU_PHONE, STU_ADDRESS, STU_BIRTHDAY, ",
        "ENROLDATE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG, LINKMAN, ",
        "LINKMAN_IPHONE, GRADUATEDATE, ICON, CLASSID",
        "from USER_STUDENT",
        "where STU_ID = #{stuId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.StudentMapper.BaseResultMap")
    Student selectByPrimaryKey(BigDecimal stuId);

    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update USER_STUDENT",
        "set USERID = #{userid,jdbcType=DECIMAL},",
          "STU_NAME = #{stuName,jdbcType=VARCHAR},",
          "SEX = #{sex,jdbcType=DECIMAL},",
          "STU_IPHONE = #{stuIphone,jdbcType=VARCHAR},",
          "STU_PHONE = #{stuPhone,jdbcType=VARCHAR},",
          "STU_ADDRESS = #{stuAddress,jdbcType=VARCHAR},",
          "STU_BIRTHDAY = #{stuBirthday,jdbcType=TIMESTAMP},",
          "ENROLDATE = #{enroldate,jdbcType=TIMESTAMP},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL},",
          "LINKMAN = #{linkman,jdbcType=VARCHAR},",
          "LINKMAN_IPHONE = #{linkmanIphone,jdbcType=VARCHAR},",
          "GRADUATEDATE = #{graduatedate,jdbcType=TIMESTAMP},",
          "ICON = #{icon,jdbcType=VARCHAR},",
          "CLASSID = #{classid,jdbcType=DECIMAL}",
        "where STU_ID = #{stuId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Student record);
}