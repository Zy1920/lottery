package com.itheima.lottery.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * author: 十年
 * signal: 爱生活爱陈奕迅
 * current time: 2018/6/23  16:16
 */

@Entity(name="prizegrade")
public class PrizeGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;
    //       //几等奖
    private Integer type;
    //中了几注
    private Integer typenum;
    //中奖金额
    private Long typemoney;

    //属于哪一期
    private String code;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypenum() {
        return typenum;
    }

    public void setTypenum(Integer typenum) {
        this.typenum = typenum;
    }

    public Long getTypemoney() {
        return typemoney;
    }

    public void setTypemoney(Long typemoney) {
        this.typemoney = typemoney;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PrizeGrade{" +
                "pid=" + pid +
                ", type=" + type +
                ", typenum=" + typenum +
                ", typemoney=" + typemoney +
                ", code='" + code + '\'' +
                '}';
    }
}
