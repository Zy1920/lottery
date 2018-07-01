package com.itheima.lottery.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/26  20:57
 */

public class Cart {

    //用于保存购物车中的数据
    private Map<String,CartItem> items=new HashMap<String,CartItem>();

    public Map<String, CartItem> getItems() {
        return items;
    }

    //添加一注彩票到购物车中
    public void add(CartItem cartItem){
        String key=cartItem.getRed()+"-"+cartItem.getBlue();
        //先判断购彩中是否已经存在这注彩票,若已经存在,则数量+1
        if (items.containsKey(key)){
            int newCount = items.get(key).getCount() + 1;
            items.get(key).setCount(newCount);

        }else {
            items.put(key,cartItem);
        }
    }

    //从购物车中删除一注彩票
    public void remove(String key){
        items.remove(key);
    }

    //清空购彩车
    public void clear(){
        items.clear();
    }


    //计算购物车中的总金额
    public double total(){
        double total=0;
        Set<String> keySet = items.keySet();
        for (String key:keySet) {
            total+=items.get(key).getSubTotal();
        }
        return total;
    }

    public Collection<CartItem> getCartItems(){
        Collection<CartItem> values = items.values();
        return values;
    }
}
