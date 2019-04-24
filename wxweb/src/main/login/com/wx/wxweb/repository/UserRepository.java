package com.wx.wxweb.repository;

import com.wx.wxweb.entity.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}
