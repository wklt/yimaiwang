package com.cn.dao;

import com.cn.entity.Euser;

import java.util.List;

public interface EuserMapper {

    int insert(Euser euser);

    int insertSelective(Euser record);

    int updateByPrimaryKeySelective(Euser record);

    List<Euser> selectuserByPage(Integer ye);

    Euser selectuser(Euser euser);

    List<Euser> selectByAll();

    int deleteByPrimaryKey(Integer id);

    Euser selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Euser euser);
}