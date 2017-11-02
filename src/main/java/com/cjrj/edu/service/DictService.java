package com.cjrj.edu.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.cjrj.edu.entity.Dictionary;

import java.util.List;

public interface DictService {
    Page<Dictionary> selectAllDict(Page page);
    int insertSelective(Dictionary record);
    int updateByPrimaryKeySelective(Dictionary record);
}
