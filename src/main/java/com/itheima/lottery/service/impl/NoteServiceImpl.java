package com.itheima.lottery.service.impl;

import com.itheima.lottery.bean.Note;
import com.itheima.lottery.dao.NoteDao;
import com.itheima.lottery.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/25  10:27
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;
    @Override
    public List<Note> findAll() {
       return noteDao.findAll();
    }

    @Override
    public void save(Note note) {
        noteDao.save(note);
    }

    @Override
    public Note findOne(String nid) {
        return noteDao.findOne(nid);
    }

    @Override
    public Note findNew() {
        return noteDao.findTopByOrderByTimeDesc();
    }


}
