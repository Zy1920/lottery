package com.itheima.lottery.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.lottery.bean.Cart;
import com.itheima.lottery.bean.CartItem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/26  22:11
 */

@Controller
@RequestMapping("/cart")
public class CartController {

    @PostMapping("/add")
    @ResponseBody
    public Map<String,Integer>  add(String balls, HttpSession session){

        // [{"red":"01,04,18,19,32,33","blue":"07"}]
        //将前端传来的json格式数组,转换成java中的集合
        List<CartItem> cartItems = JSON.parseArray(balls, CartItem.class);

        //判断购物车对象是否存在
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            session.setAttribute("cart",cart);
        }

        //循环将数据添加到购物车中
        for (CartItem cartItem : cartItems) {
            cartItem.setCount(1);
            cart.add(cartItem);

        }

        //将数据以json格式的对象返回给前端页面
        Map<String,Integer> map=new HashMap<>();
        map.put("cartSize",cart.getItems().size());
        System.out.println(map.get("cartSize"));
        return map;



    }

    @GetMapping("/selectUI")
    public String selectUI(){
        return "select";
    }

    @GetMapping("/goToCart")
    public String cartUI(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            session.setAttribute("cart",cart);
        }
        return "cart";
    }

    @GetMapping("/clear")
    public String clear(HttpSession session){
       Cart cart = (Cart) session.getAttribute("cart");
       cart.clear();
       return "redirect:/cart/goToCart";
    }

    @GetMapping("/deleteOne")
    public String deleteOne(HttpSession session,String key){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.remove(key);
        return "redirect:/cart/goToCart";
    }


}
