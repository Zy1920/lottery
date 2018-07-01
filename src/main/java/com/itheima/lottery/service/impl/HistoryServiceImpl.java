package com.itheima.lottery.service.impl;

import com.itheima.lottery.bean.BallHistory;
import com.itheima.lottery.dao.HistoryDao;
import com.itheima.lottery.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/23  16:29
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;

    public Page<BallHistory> findAll(Pageable pageable){

        Page<BallHistory> all = historyDao.findAll(pageable);
        return all;

    }

    @Override
    public BallHistory findOne(String code) {
        return historyDao.findOne(code);
    }
}
