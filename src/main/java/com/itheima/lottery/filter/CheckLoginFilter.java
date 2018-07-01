package com.itheima.lottery.filter;

import com.itheima.lottery.bean.User;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/26  20:37
 */

@WebFilter(urlPatterns = {"/note/publish","/comment/add","/order/submit","/user/mine"})
public class CheckLoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            String requestURI = request.getRequestURI();
            request.getSession().setAttribute("requestURI",requestURI);
            response.sendRedirect("/user/logUI");
            return;
        }
        chain.doFilter(request,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
