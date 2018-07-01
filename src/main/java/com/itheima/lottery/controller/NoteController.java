package com.itheima.lottery.controller;

import com.itheima.lottery.bean.Note;
import com.itheima.lottery.bean.User;
import com.itheima.lottery.service.NoteService;
import com.itheima.lottery.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/24  21:44
 */
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/bbs")
    public String bbs(Model model){
        List<Note>  notes=noteService.findAll();
        model.addAttribute("notes",notes);
        return "bbs_index";
    }

    @GetMapping("/publish")
    public String publish(Note note, HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        note.setNid(UUIDUtils.getId());
        note.setUsername(user.getUsername());
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        note.setTime( format.format(date));
        note.setIpaddress(request.getLocalAddr());
        noteService.save(note);
        return "redirect:/note/bbs";
    }

    @GetMapping("/detail")
    public String detail(String nid,Model model){
        Note note = noteService.findOne(nid);
        model.addAttribute("one",note);
        return "bbs_detail";
    }


}
