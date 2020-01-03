package com.hwx.blog.service.impl;

import com.hwx.blog.entity.User;
import com.hwx.blog.mapper.UserMapper;
import com.hwx.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
