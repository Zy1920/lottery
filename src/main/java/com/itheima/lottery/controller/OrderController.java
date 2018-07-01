package com.itheima.lottery.controller;

import com.itheima.lottery.bean.Cart;
import com.itheima.lottery.bean.CartItem;
import com.itheima.lottery.bean.Order;
import com.itheima.lottery.bean.OrderItem;
import com.itheima.lottery.bean.User;
import com.itheima.lottery.service.OrderService;
import com.itheima.lottery.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/27  16:48
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/submit")
    public String submit(HttpSession session, Model model){
        //1.从session中获取cart对象
        Cart cart = (Cart) session.getAttribute("cart");
        //2.根据cart对象封装Order对象
        Order order=new Order();
        order.setOid(UUIDUtils.getId());
        order.setCreateTime(new Date());
        order.setState(0);
        order.setTotal(cart.total());
        //从session中获取user对象
        User user = (User) session.getAttribute("user");
        order.setUid(user.getUid());
        //3.根据cartitem对象封装orderitem对象
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Collection<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem=new OrderItem();
            orderItem.setBlue(cartItem.getBlue());
            orderItem.setCount(cartItem.getCount());
            orderItem.setCode("2018020");
            orderItem.setRed(cartItem.getRed());
            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setOid(order.getOid());
            orderItems.add(orderItem);
        }

        //4.将所有的orderitem封装到order对象中去
        order.setOrderItems(orderItems);

        //5.调用业务保存订单对象
        orderService.save(order);
        //6.生成响应
        model.addAttribute("order",order);
        return "order_detail";
    }

    @GetMapping("/find")
    public String find(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderService.findByUid(user.getUid());
        System.out.println(orders);
        model.addAttribute("orders",orders);
        return "order_list";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

}
