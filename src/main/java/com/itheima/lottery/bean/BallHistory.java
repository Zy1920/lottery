package com.itheima.lottery.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/23  16:16
 */
@Entity(name="ballhistory")
@Data
public class BallHistory {
    //彩票的期数
    @Id
    private String code;
    //彩票的名称
    private String name;
    //日期
    private String date;
    //周几开的奖
    private String week;
    //红球的数量
    private String red;
    //蓝球
    private String blue;
    //销售额
    private Long sales;
    //奖池金额
    private Long poolmoney;
    //一等奖中奖信息
    private String content;

    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER,mappedBy="code")
    private List<PrizeGrade> prizegrades;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
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

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Long getPoolmoney() {
        return poolmoney;
    }

    public void setPoolmoney(Long poolmoney) {
        this.poolmoney = poolmoney;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PrizeGrade> getPrizegrades() {
        return prizegrades;
    }

    public void setPrizegrades(List<PrizeGrade> prizegrades) {
        this.prizegrades = prizegrades;
    }

    @Override
    public String toString() {
        return "BallHistory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", red='" + red + '\'' +
                ", blue='" + blue + '\'' +
                ", sales=" + sales +
                ", poolmoney=" + poolmoney +
                ", content='" + content + '\'' +
                ", prizegrades=" + prizegrades +
                '}';
    }
}
