package com.cjrj.edu.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.cjrj.edu.entity.Dictionary;
import com.cjrj.edu.entity.vo.ActiviUser;
import com.cjrj.edu.service.DictService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;

@Controller
@RequestMapping("/dict")
public class DictController {
    @Autowired
    private DictService dictService;

    @RequestMapping("/list")
    @ResponseBody
    public Object selectAllDict(@RequestParam("pageNumber")Integer pageNumber,@RequestParam("pageSize")Integer pageSize){
        Page<Dictionary> page=new Page<Dictionary>();
        page=dictService.selectAllDict(page);
        return page;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addDict(Dictionary dictionary){
        ActiviUser activiUser= (ActiviUser) SecurityUtils.getSubject().getSession().getAttribute("user");
        dictionary.setCreatename(activiUser.getUsername());
        dictionary.setCreatedate(new Date());
        dictionary.setDelFlag(new BigDecimal(0));
        int i=dictService.insertSelective(dictionary);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateDict(@RequestBody Dictionary dictionary){
        ActiviUser activiUser= (ActiviUser) SecurityUtils.getSubject().getSession().getAttribute("user");
        dictionary.setModifyname(activiUser.getUsername());
        dictionary.setModifydate(new Date());
        int i=dictService.updateByPrimaryKeySelective(dictionary);
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteDict(@RequestParam("ids") String ids){
        ActiviUser activiUser= (ActiviUser) SecurityUtils.getSubject().getSession().getAttribute("user");
        String[] idstr=ids.split(",");
        int i=0;
        for (String id:
             idstr) {
            Dictionary dictionary=new Dictionary();
            dictionary.setDicId(new BigDecimal(id));
            dictionary.setModifyname(activiUser.getUsername());
            dictionary.setModifydate(new Date());
            dictionary.setDelFlag(new BigDecimal(1));
            i=dictService.updateByPrimaryKeySelective(dictionary);
        }
        if (i>0){
            return "true";
        }else {
            return "false";
        }
    }
}
