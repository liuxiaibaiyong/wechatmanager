package com.wx.wxweb.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
	@RequestMapping(value = "/first") 
	@ResponseBody
    public String first() {
        return "1";
    }
}
