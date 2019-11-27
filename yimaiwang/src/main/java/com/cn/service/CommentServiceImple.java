package com.cn.service;

import com.cn.dao.CommentMapper;
import com.cn.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImple implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    public List<Comment> getList() {
        return commentMapper.getAll();
    }

    public int addliu(Comment comment) {
        return commentMapper.insert(comment);
    }

    public int deleteByid(Integer ecId) {
        return commentMapper.deleteByPrimaryKey(ecId);
    }
}
