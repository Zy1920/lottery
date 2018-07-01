package com.itheima.lottery.controller;

import com.itheima.lottery.bean.Comment;
import com.itheima.lottery.bean.User;
import com.itheima.lottery.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/26  19:48
 */

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/add")
    public String add(String nid, String content, HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        Comment comment=new Comment();
        comment.setContent(content);
        comment.setIpAddress(request.getLocalAddr());
        comment.setNid(nid);
        comment.setTime(new Date().toLocaleString());
        comment.setUsername(user.getUsername());
        commentService.save(comment);
        return "redirect:/note/detail?nid="+nid;
    }

    @GetMapping("/add")
    public String add1(String nid, String content, HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");
        Comment comment=new Comment();
        comment.setContent(content);
        comment.setIpAddress(request.getLocalAddr());
        comment.setNid(nid);
        comment.setTime(new Date().toLocaleString());
        comment.setUsername(user.getUsername());
        commentService.save(comment);
        return "redirect:/note/detail?nid="+nid;
    }

}
