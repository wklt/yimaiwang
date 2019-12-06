package com.cn.dao;

import com.cn.entity.Comment;

import java.util.List;

public interface CommentMapper {

    int insertSelective(Comment record);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    //查询所有留言
    List <Comment> getAll();

    //添加留言
    int insert(Comment comment);

    //删除留言
    int deleteByPrimaryid(Integer ecId);

    //查询该留言信息
    Comment selectByPrimaryKey(Integer ecId);

    //修改留言
    int updateByPrimaryid(Comment comment);

    List <Comment> selectcommentPage(Integer ye);
}