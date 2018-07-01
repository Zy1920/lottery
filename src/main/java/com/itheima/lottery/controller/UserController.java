package com.itheima.lottery.controller;

import com.aliyuncs.exceptions.ClientException;
import com.itheima.lottery.bean.User;
import com.itheima.lottery.service.UserService;
import com.itheima.lottery.utils.SMSUtils;
import com.itheima.lottery.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/24  17:10
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registUI")
    public String registUI(){
        return "register";
    }


    @PostMapping("/add")
    public String register(User user, HttpSession session, String code, Model model){
        String codeValue = (String) session.getAttribute("codeValue");
        //0.检验验证码是否正确
        if (!code.equals(codeValue)){
            model.addAttribute("msg","验证码输入不正确，请重新输入");
            return "register";
        }


        user.setHeadimg("img/1.jpg");
        user.setMoney(100);
        user.setState(1);
        user.setUid(UUIDUtils.getId());

        userService.save(user);
        System.out.println(user.getUid());

        return "log";
    }

    @GetMapping("/logUI")
    public String logUI(){
        return "log";
    }

    @PostMapping("/log")
    public String log(String email, String password, Model model,HttpSession session){
        User user=userService.login(email,password);
        if (user==null){
            model.addAttribute("msg","用户名或密码不正确");
            return "log";
        }
        session.setAttribute("user",user);
        String uri = (String) session.getAttribute("requestURI");
        System.out.println(uri);
        if (uri==null){
            return "redirect:/";
        }
        return "redirect:"+uri;
    }

    @GetMapping("/smsSend")
    @ResponseBody
    public String smsSend(String mobile, HttpSession session) throws ClientException {
        String codeValue = SMSUtils.sendSms(mobile);
        session.setAttribute("codeValue",codeValue);
        return "success";
    }

    @GetMapping("/mine")
    public String mine(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return "log";
        }
        return "mine";
    }

    @GetMapping("/reRegist")
    public String reRegist(){
        return "reRegist";
    }

    @PostMapping("/reset")
    public String resetPsw(String email,String mobile,Model model,String password,String code,HttpSession session){
        User user = userService.reset(email, mobile);
        String codeValue = (String) session.getAttribute("codeValue");
        if (!code.equals(codeValue)){
            model.addAttribute("codemsg","验证码不正确");
            return "reRegist";
        }
        if (user==null){
            model.addAttribute("msg","邮箱或手机号输入不正确");
            return "reRegist";
        }
        user.setPassword(password);
        userService.save(user);
        return "redirect:/user/logUI";
    }

    @GetMapping("/touxiangUI")
    public String touxiangUI(){
        return "touxiang";
    }
}
