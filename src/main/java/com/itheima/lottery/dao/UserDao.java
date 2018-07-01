package com.itheima.lottery.dao;

import com.itheima.lottery.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/24  17:45
 */
public interface UserDao extends JpaRepository<User,String> {
    User findByEmailAndPassword(String email, String password);
    User findByEmailAndMobile(String email, String mobile);
}
