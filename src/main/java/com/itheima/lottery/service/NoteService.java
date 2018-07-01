package com.itheima.lottery.service;

import com.itheima.lottery.bean.Note;

import java.util.List;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/25  10:26
 */
public interface NoteService {

    List<Note> findAll();

    void save(Note note);

    Note findOne(String nid);

    Note findNew();
}
