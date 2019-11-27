package com.cn.service;

import com.cn.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getList();

    int addliu(Comment comment);

    int deleteByid(Integer ecId);
}
