package com.itheima.lottery.service;

import com.itheima.lottery.bean.User;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/24  17:43
 */
public interface UserService {
    void save(User user);
    User login(String email, String password);
    User reset(String email, String mobile);

    void update(User user);
}
