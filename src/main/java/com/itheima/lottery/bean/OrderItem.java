package com.itheima.lottery.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItem {
    //0.订单项的编号
    @Id
    private String itemid;
    //1.购买的是哪一期
    private String code;
    //2.购买红球的号码
    private String red;
    //3.购买的蓝球号码
    private String blue;
    //4.购买的数量
    private int count;
    //6.这一项是属于哪个订单的
    private String oid;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemid='" + itemid + '\'' +
                ", code='" + code + '\'' +
                ", red='" + red + '\'' +
                ", blue='" + blue + '\'' +
                ", count=" + count +
                ", oid='" + oid + '\'' +
                '}';
    }
}
