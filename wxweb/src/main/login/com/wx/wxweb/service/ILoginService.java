package com.wx.wxweb.service;

import java.util.Map;

import com.wx.wxweb.entity.Role;
import com.wx.wxweb.entity.User;

public interface ILoginService {

	User addUser(Map<String, Object> map);

	Role addRole(Map<String, Object> map);

	User findByName(String name);
   
}
