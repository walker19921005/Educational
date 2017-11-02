package com.cjrj.edu.service;

import java.util.List;


import com.cjrj.edu.entity.LeaveBill;
import com.cjrj.edu.entity.PageHelper;
import com.cjrj.edu.util.ResultDO;


 

public interface LeaveBillService {

	ResultDO<Integer> add(LeaveBill bean);

	List<LeaveBill> list(PageHelper page,String name);

	Long getTotle(String name);

	ResultDO<Integer> del(LeaveBill bean);

	

}
