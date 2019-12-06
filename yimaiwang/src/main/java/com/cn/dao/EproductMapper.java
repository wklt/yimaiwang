package com.cn.dao;

import com.cn.entity.Eproduct;

import java.util.List;

public interface EproductMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Eproduct eproduct);

    Eproduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eproduct eproduct);

    int updateByPrimaryKey(Eproduct record);

    List<Eproduct> getAllproduct();

    List<Eproduct> getAllByPrimaryKey(Integer ye);

    int insert(Eproduct record);

    //根据二级目录
    List<Eproduct> selectproductsId(Integer id);

    List<Eproduct> selectProductsidpage(Integer id, Integer ye);
}