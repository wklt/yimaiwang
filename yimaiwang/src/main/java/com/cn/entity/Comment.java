package com.cn.entity;

import java.util.Date;

public class Comment {
    private Integer ecId;

    private String ecReply;

    private String ecContent;

    private Date ecCreateTime;

    private Date ecReplyTime;

    private String ecNickName;

    public Comment(Integer ecId, String ecReply, String ecContent, Date ecCreateTime, Date ecReplyTime, String ecNickName) {
        this.ecId = ecId;
        this.ecReply = ecReply;
        this.ecContent = ecContent;
        this.ecCreateTime = ecCreateTime;
        this.ecReplyTime = ecReplyTime;
        this.ecNickName = ecNickName;
    }

    public Comment() {
        super();
    }

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public String getEcReply() {
        return ecReply;
    }

    public void setEcReply(String ecReply) {
        this.ecReply = ecReply == null ? null : ecReply.trim();
    }

    public String getEcContent() {
        return ecContent;
    }

    public void setEcContent(String ecContent) {
        this.ecContent = ecContent == null ? null : ecContent.trim();
    }

    public Date getEcCreateTime() {
        return ecCreateTime;
    }

    public void setEcCreateTime(Date ecCreateTime) {
        this.ecCreateTime = ecCreateTime;
    }

    public Date getEcReplyTime() {
        return ecReplyTime;
    }

    public void setEcReplyTime(Date ecReplyTime) {
        this.ecReplyTime = ecReplyTime;
    }

    public String getEcNickName() {
        return ecNickName;
    }

    public void setEcNickName(String ecNickName) {
        this.ecNickName = ecNickName == null ? null : ecNickName.trim();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ecId=" + ecId +
                ", ecReply='" + ecReply + '\'' +
                ", ecContent='" + ecContent + '\'' +
                ", ecCreateTime=" + ecCreateTime +
                ", ecReplyTime=" + ecReplyTime +
                ", ecNickName='" + ecNickName + '\'' +
                '}';
    }

    public Comment(Integer ecId, String ecReply, Date ecReplyTime) {
        this.ecId = ecId;
        this.ecReply = ecReply;
        this.ecReplyTime = ecReplyTime;
    }
}