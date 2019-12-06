package com.cn.dao;

import com.cn.entity.News;

import java.util.List;

public interface NewsMapper {



    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);


    List<News> getAll();

    int updateByPrimaryKey(News news);

    int deleteByPrimaryKey(Integer id);

    int insert(News news);

    List<News> selectnewsPage(Integer ye);
}