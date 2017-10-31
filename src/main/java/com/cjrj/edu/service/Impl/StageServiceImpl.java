package com.cjrj.edu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjrj.edu.entity.Stage;
import com.cjrj.edu.mapper.StageMapper;
import com.cjrj.edu.service.StageService;
@Service
public class StageServiceImpl implements StageService {

	@Autowired
	StageMapper stageMapper;
	/**
	 * 查询所有
	 * @return
	 */
	@Override
	public List<Stage> getStageList() {
		// TODO Auto-generated method stub
		return stageMapper.getStageList();
	}

}
