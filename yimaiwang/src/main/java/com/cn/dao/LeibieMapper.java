package com.cn.dao;

import com.cn.entity.Leibie;

import java.util.List;

public interface LeibieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leibie leibie);

    int insertSelective(Leibie record);

    Leibie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leibie record);

    int updateByPrimaryKey(Leibie leibie);

    List<Leibie> selectAll();

    List<Leibie> selectleibiePage(Integer ye);
}