package com.itheima.lottery.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "comment")
public class Comment {
    @Id
    //评论的是哪个主题的帖子
    private String nid;
    //评论的内容
    private String content;
    //评论发表的时间
    private String time;
    //评论者的名称
    private String username;
    //评论者的ip地址
    private  String ipAddress;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "nid='" + nid + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", username='" + username + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}