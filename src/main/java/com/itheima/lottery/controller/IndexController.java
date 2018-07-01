package com.itheima.lottery.controller;

import com.itheima.lottery.bean.BallHistory;
import com.itheima.lottery.bean.Note;
import com.itheima.lottery.service.HistoryService;
import com.itheima.lottery.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/23  16:25
 */
@Controller
public class IndexController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "0") int pageNumber, Model model){
        //sort方式:按code的降序
        Sort sort = new Sort(Sort.Direction.DESC,"code");
        //分页查询 PageRequest(页数,每页的条数,sort方式)
        org.springframework.data.domain.Pageable pageable=new PageRequest(pageNumber,10,sort);
        Page<BallHistory> all = historyService.findAll(pageable);
        List<BallHistory> historyList = all.getContent();
        //将查询到的内容存储到model中，模板页面可引用model中的内容
        model.addAttribute("historyList",historyList);
        //查询最新的帖子
        Note note = noteService.findNew();
        System.out.println(note);
        model.addAttribute("note",note);
        model.addAttribute("page",all);
        //跳转到首页
        return "index";
    }

    @GetMapping("/detail")
    public String detail(Model model,String code){
        //1.根据单击事件携带的code参数，后台查询参数
        BallHistory history = historyService.findOne(code);
        //2.生成响应:将数据携带到相应的页面中
        model.addAttribute("history",history);
        return "detail";
    }
}
