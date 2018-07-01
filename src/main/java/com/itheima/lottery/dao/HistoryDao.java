package com.itheima.lottery.dao;

import com.itheima.lottery.bean.BallHistory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/23  16:25
 */
public interface HistoryDao extends JpaRepository<BallHistory,String> {
}
