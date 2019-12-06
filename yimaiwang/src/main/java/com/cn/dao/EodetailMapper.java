package com.cn.dao;

import com.cn.entity.Eodetail;

import java.util.List;

public interface EodetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eodetail record);

    int insertSelective(Eodetail eodetail);

    Eodetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eodetail eodetail);

    int updateByPrimaryKey(Eodetail record);

    List<Eodetail> selectAllEodetail();

    List<Eodetail> selectEodetailByPage(Integer ye);

    List<Eodetail> selectmyEodetail(Integer id);

    List<Eodetail> selectmyEodetailByPage(Integer id,Integer ye);

}