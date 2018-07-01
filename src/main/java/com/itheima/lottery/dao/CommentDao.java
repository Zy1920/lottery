package com.itheima.lottery.dao;

import com.itheima.lottery.bean.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/26  20:17
 */
public interface CommentDao extends JpaRepository<Comment,String> {
}
