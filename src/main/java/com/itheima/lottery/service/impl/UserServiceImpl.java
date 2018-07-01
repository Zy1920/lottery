package com.itheima.lottery.service.impl;

import com.itheima.lottery.bean.User;
import com.itheima.lottery.dao.UserDao;
import com.itheima.lottery.service.UserService;
import com.itheima.lottery.utils.MD5Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/24  17:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void save(User user) {
        String psw = MD5Utils.encode(user.getPassword(), "%$^");
        user.setPassword(psw);
        userDao.save(user);
    }

    @Override
    public User login(String email, String password) {
        password=MD5Utils.encode(password,"%$^");
        return userDao.findByEmailAndPassword(email,password);
    }

    @Override
    public User reset(String email, String mobile) {
        return  userDao.findByEmailAndMobile(email,mobile);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }
}
