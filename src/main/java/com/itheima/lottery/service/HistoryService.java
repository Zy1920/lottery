package com.itheima.lottery.service;

import com.itheima.lottery.bean.BallHistory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/23  16:28
 */
public interface HistoryService {
    Page<BallHistory> findAll(Pageable pageable);
    BallHistory findOne(String code);
}
