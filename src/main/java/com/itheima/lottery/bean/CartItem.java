package com.itheima.lottery.bean;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/26  20:58
 */

public class CartItem {
    // 红球
    private String red;
    // 蓝球
    private String blue;
    // 购买的数量,默认是1
    private int count=1;

    private double price=2;
    private double subTotal;

    public double getSubTotal() {
        return count*price;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "red='" + red + '\'' +
                ", blue='" + blue + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", subTotal=" + subTotal +
                '}';
    }
}
