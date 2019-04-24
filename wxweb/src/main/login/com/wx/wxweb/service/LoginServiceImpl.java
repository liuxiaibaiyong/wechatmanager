package com.wx.wxweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wx.wxweb.entity.Permission;
import com.wx.wxweb.entity.Role;
import com.wx.wxweb.entity.User;
import com.wx.wxweb.repository.RoleRepository;
import com.wx.wxweb.repository.UserRepository;
import com.wx.wxweb.tool.PwdEncoder;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //添加用户
    public User addUser(Map<String, Object> map) {
        User user = new User();
        user.setName(map.get("username").toString());
        user.setPassword(PwdEncoder.MD5.encoderPassword(map.get("password").toString(), user.getName(), 1024));
        
        userRepository.save(user);
        return user;
    }

    //添加角色
    public Role addRole(Map<String, Object> map) {
        User user = userRepository.findOne(Long.valueOf(map.get("userId").toString()));
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;
    }

    //查询用户通过用户名
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}