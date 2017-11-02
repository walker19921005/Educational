package com.cjrj.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SysController {
    @RequestMapping("/dict")
    public String getPage() {
        return "sys/dict";
    }
}
