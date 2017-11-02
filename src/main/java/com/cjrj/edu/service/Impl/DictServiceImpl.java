package com.cjrj.edu.service.Impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cjrj.edu.entity.Dictionary;
import com.cjrj.edu.mapper.DictionaryMapper;
import com.cjrj.edu.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictServiceImpl extends ServiceImpl<DictionaryMapper,Dictionary> implements DictService {
    @Resource
    private DictionaryMapper dictionaryMapper;


    @Override
    public Page<Dictionary> selectAllDict(Page page) {
        return page.setRecords(dictionaryMapper.selectAllDict(page));
    }

    @Override
    public int insertSelective(Dictionary record) {
        return dictionaryMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKeySelective(record);
    }
}
