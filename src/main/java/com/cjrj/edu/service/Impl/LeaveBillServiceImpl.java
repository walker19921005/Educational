package com.cjrj.edu.service.Impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cjrj.edu.entity.LeaveBill;
import com.cjrj.edu.entity.PageHelper;
import com.cjrj.edu.mapper.LeaveBillMapper;
import com.cjrj.edu.service.LeaveBillService;
import com.cjrj.edu.util.ResultDO;

@Service("leaveBillService")
public class LeaveBillServiceImpl implements LeaveBillService{
	
	@Resource
	private LeaveBillMapper leaveBillMapper;

	
	public ResultDO<Integer> add(LeaveBill bean) {
		Integer result = leaveBillMapper.add(bean);
		return new ResultDO<Integer>(result);
	}


	
	public List<LeaveBill> list(PageHelper page,String name) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getPage()*page.getRows());
		List<LeaveBill> result = leaveBillMapper.list(page.getStart(),page.getEnd(),name);
		return result;
	}
	
	
	public Long getTotle(String name) {
		Long totle = leaveBillMapper.getTotle(name);
		return totle;
	}
	

	public ResultDO<Integer> del(LeaveBill bean) {
		Integer result = leaveBillMapper.del(bean.getId());
		return new ResultDO<Integer>(result);
	}
	
	
	
}
