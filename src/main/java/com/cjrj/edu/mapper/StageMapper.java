package com.cjrj.edu.mapper;

import com.cjrj.edu.entity.Stage;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
@Repository
public interface StageMapper {
    @Delete({
        "delete from T_STAGE",
        "where STAGE_ID = #{stageId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal stageId);

    @Insert({
        "insert into T_STAGE (STAGE_ID, STAGE_NAME, ",
        "CREATEDATE, CREATENAME, ",
        "MODIFYDATE, MODIFYNAME, ",
        "DEL_FLAG)",
        "values (#{stageId,jdbcType=DECIMAL}, #{stageName,jdbcType=VARCHAR}, ",
        "#{createdate,jdbcType=TIMESTAMP}, #{createname,jdbcType=VARCHAR}, ",
        "#{modifydate,jdbcType=TIMESTAMP}, #{modifyname,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="select stage_seq.nextval from dual", keyProperty="stageId", before=true, resultType=BigDecimal.class)
    int insert(Stage record);

    int insertSelective(Stage record);

    @Select({
        "select",
        "STAGE_ID, STAGE_NAME, CREATEDATE, CREATENAME, MODIFYDATE, MODIFYNAME, DEL_FLAG",
        "from T_STAGE",
        "where STAGE_ID = #{stageId,jdbcType=DECIMAL}"
    })
    @ResultMap("com.cjrj.edu.mapper.StageMapper.BaseResultMap")
    Stage selectByPrimaryKey(BigDecimal stageId);

    int updateByPrimaryKeySelective(Stage record);

    @Update({
        "update T_STAGE",
        "set STAGE_NAME = #{stageName,jdbcType=VARCHAR},",
          "CREATEDATE = #{createdate,jdbcType=TIMESTAMP},",
          "CREATENAME = #{createname,jdbcType=VARCHAR},",
          "MODIFYDATE = #{modifydate,jdbcType=TIMESTAMP},",
          "MODIFYNAME = #{modifyname,jdbcType=VARCHAR},",
          "DEL_FLAG = #{delFlag,jdbcType=DECIMAL}",
        "where STAGE_ID = #{stageId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Stage record);
    
    /**
	 * 查询所有
	 * @return
	 */
	public List<Stage> getStageList();
}