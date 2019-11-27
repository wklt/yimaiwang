package com.cn.dao;

import com.cn.entity.Comment;

import java.util.List;

public interface CommentMapper {


    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer ecId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    //查询所有留言
    List <Comment> getAll();

    //添加留言
    int insert(Comment comment);

    //删除留言
    int deleteByPrimaryKey(Integer ecId);
}