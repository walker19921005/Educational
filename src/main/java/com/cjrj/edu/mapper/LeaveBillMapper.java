package com.cjrj.edu.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.cjrj.edu.entity.LeaveBill;

 


public interface LeaveBillMapper {

	Integer add(LeaveBill bean);

	List<LeaveBill> list(@Param("start")int start,@Param("end")int end,@Param("name")String name);

	Long getTotle(@Param("name")String name);

	Integer del(@Param("id")Long id);

	LeaveBill findLeaveBillById(Long id);

	Integer updateStatus(LeaveBill leaveBill);

}
