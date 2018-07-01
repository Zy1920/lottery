package com.itheima.lottery.dao;

import com.itheima.lottery.bean.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/27  17:21
 */
public interface OrderDao extends JpaRepository<Order,String> {
    List<Order> findByUid(String uid);
}
