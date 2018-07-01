package com.itheima.lottery.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "note")
@Data
public class Note {
    //帖子的编号
    @Id
    private String nid;
    //帖子的标题
    private String title;
    //帖子的内容
    private String content;
    //发帖的时间
    private String time;
    //谁发的帖子
    private String username;
    //发帖人的IP地址
    private String ipaddress;

    @OneToMany(mappedBy = "nid")
    private List<Comment> comments;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Note{" +
                "nid='" + nid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", username='" + username + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", comments=" + comments +
                '}';
    }
}