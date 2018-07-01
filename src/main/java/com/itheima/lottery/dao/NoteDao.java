package com.itheima.lottery.dao;

import com.itheima.lottery.bean.Note;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/25  10:28
 */
public interface NoteDao extends JpaRepository<Note,String> {
    Note findTopByOrderByTimeDesc();
}
