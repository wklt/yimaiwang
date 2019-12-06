package com.cn.dao;

import com.cn.entity.Epcategory;
import com.cn.entity.Leibie;

import java.util.List;

public interface EpcategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Epcategory epcategory);

    int insertSelective(Epcategory record);

    Epcategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Epcategory record);

    int updateByPrimaryKey(Epcategory record);

    List<Epcategory> selectAllEpcategory();

    List<Epcategory> selectAll(Integer id);

    int updatePcategory(Epcategory epcategory);

}