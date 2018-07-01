package com.itheima.lottery.service.impl;

import com.itheima.lottery.bean.Comment;
import com.itheima.lottery.dao.CommentDao;
import com.itheima.lottery.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/26  20:16
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }
}
