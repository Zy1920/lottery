package com.itheima.lottery.service;

import com.itheima.lottery.bean.Order;

import java.util.List;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/27  17:19
 */
public interface OrderService {
    void save(Order order);

    List<Order> findByUid(String uid);
}
