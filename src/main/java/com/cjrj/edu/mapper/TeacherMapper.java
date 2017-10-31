package com.cjrj.edu.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.cjrj.edu.entity.Teacher;
@Repository
public interface TeacherMapper {
    @Delete({
        "delete from USER_TEACHER",
        "where TEACH_ID = #{teachId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal teachId);

    @Insert({
        "insert into USER_TEACHER (TEACH_ID, USERID, ",
        "TEACH_NAME, TEACH_AGE, ",
        "SEX, TEACH_ADDRESS, ",
        "TEACH_IPHONE, TEACH_DESC, ",
        "ENTRYDATE, CREATEDATE, ",
        "CREATENAME, MODIFYDATE, ",
        "MODIFYNAME, DEL_FLAG, ",
        "TEACH_BIRTHDAY, ICON)",
        "values (#{teachId,jdbcType=DECIMAL}, #{userid,jdbcType=DECIMAL}, ",
        "#{teachName,jdbcType=VARCHAR}, #{teachAge,jdbcType=DECIMAL}, ",
        "#{sex,jdbcType=DECIMAL}, #{teachAddress,jdbcType=VARCHAR}, ",
        "#{teachIphone,jdbcType=VARCHAR}, #{teachDesc,jdbcType=VARCHAR}, ",
        "#{entrydate,jdbcType=TIMESTAMP}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{createname,jdbcType=VARCHAR}, #{modifydate,jdbcType=TIMESTAMP}, ",
        "#{modifyname,jdbcType=VARCHAR}, #{delFlag,jdbcType=DECIMAL}, ",
        "#{teachBirthday,jdbcType=TIMESTAMP}, #{icon,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select teacher_seq.nextval from dual", keyProperty="teachId", before=true, resultType=BigDecimal.class)
    int insertTeacher(Teacher record);

    int insertSelective(Teacher record);

    @Select({
        "select",
        "TEACH_ID, USERID, TEACH_NAME, TEACH_AGE, SEX, TEACH_ADDRESS, TEACH_IPHONE, TEACH_DESC, ",
        "ENTRYDATE, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG, TEACH_BIRTHDAY, ",
        "ICON",
        "from USER_TEACHER",
        "where TEACH_ID = #{teachId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.TeacherMapper.BaseResultMap")
    Teacher selectByPrimaryKey(BigDecimal teachId);

    int updateByPrimaryKeySelective(Teacher record);

    @Update({
        "update USER_TEACHER",
        "set USERID = #{userid,jdbcType=DECIMAL},",
          "TEACH_NAME = #{teachName,jdbcType=VARCHAR},",
          "TEACH_AGE = #{teachAge,jdbcType=DECIMAL},",
          "SEX = #{sex,jdbcType=DECIMAL},",
          "TEACH_ADDRESS = #{teachAddress,jdbcType=VARCHAR},",
          "TEACH_IPHONE = #{teachIphone,jdbcType=VARCHAR},",
          "TEACH_DESC = #{teachDesc,jdbcType=VARCHAR},",
          "ENTRYDATE = #{entrydate,jdbcType=TIMESTAMP},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL},",
          "TEACH_BIRTHDAY = #{teachBirthday,jdbcType=TIMESTAMP},",
          "ICON = #{icon,jdbcType=VARCHAR}",
        "where TEACH_ID = #{teachId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Teacher record);
    
    /**
     * 查询所有教师
     * @return
     */
    public List<Teacher>getTeachList();
}