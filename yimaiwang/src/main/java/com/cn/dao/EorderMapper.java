package com.cn.dao;

import com.cn.entity.Eorder;

import java.util.List;

public interface EorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eorder record);

    int insertSelective(Eorder eorder);

    Eorder selectByPrimaryKey(Integer id);

    Eorder selectByproductid(Integer productid,Integer euserid);

    int updateorderSelective(Eorder eorder);

    List<Eorder> selectallorderByuserid(Integer id);

    List<Eorder> selectorderByuseridPage(Integer id,Integer ye);


}