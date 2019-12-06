package com.cn.service;

import com.cn.entity.*;

import java.util.List;

public interface AllService {

    //----------------登录
    Euser selectUsers(Euser euser);

    List <Leibie> selectLeibie();

    List<Epcategory> selectEpcategoryByParentId(Integer id);

    List<Eproduct> selectproducts();

    int insertUser(Euser euser);

    //----------------留言
    List<Comment> getList();

    int addliu(Comment comment);

    int deleteByid(Integer ecId);

    Comment selectByPrimaryid(Integer ecId);

    int updateByid(Comment comment);

    List <Comment> selectcommentPage(Integer ye);

    //----------------------新闻
    List<News> getList2();

    List<News> selectnewsPage(Integer ye);

    News selectByPrimaryid2(Integer id);

    int updateByPrimaryid(News news);

    int deleteByPrimaryid(Integer id);

    int insertNews(News news);

    //---------------------用户
    List<Euser> getByAll();

    int deleteUserid(Integer id);

    Euser selectUserid(Integer id);

    int updateUserid(Euser euser);

    List<Euser> selectuserByPage(Integer ye);


    //-----------------------分类

    int insertleibie(Leibie leibie);

    int deleteleibieid(Integer id);

    int deletePcategoryid(Integer id);

    Leibie selectleibieid(Integer id);

    int insertPcategory(Epcategory epcategory);

    Epcategory selectPcategoryid(Integer id);

    int updatePcategoryid(Epcategory epcategory);

    int updateLeibieid(Leibie leibie);

    List<Leibie> selectleibiePage(Integer ye);

    //---------------------商品管理

    List<Epcategory> selectAllEpcategory();

    List<Eproduct> getAllproductid();

    List<Eproduct> getAllgetAllByPrimaryKeyid(Integer ye);

    int insertProduct(Eproduct eproduct);

    List<Eproduct> selectProductsidpage(Integer id, Integer ye);

    int deleteproductid(Integer id);

    Eproduct selectProductid(Integer id);

    int updateProductSelective(Eproduct eproduct);

    //-----------------------前台商品
    List<Eproduct> selectproductsId(Integer id);

    //---------------------------------购物车
    Eorder selectByproductid(Integer productid,Integer euserid);

     int insertorderSelective(Eorder eorder);

    int updateorderSelective(Eorder eorder);

    List<Eorder> selectallorderByuserid(Integer id);

    List<Eorder> selectorderByuseridPage(Integer id,Integer ye);

    int deleteByOrderKey(Integer id);

    Eorder selectByPrimaryKey(Integer id);

    //----------------------------------订单
    int insertEodetailSelective(Eodetail eodetail);

    List<Eodetail> selectmyEodetail(Integer id);

    List<Eodetail> selectmyEodetailByPage(Integer id,Integer ye);


    //-----------后台
    List<Eodetail> selectAllEodetail();

    List<Eodetail> selectEodetailByPage(Integer ye);

    int deleteEodetailByPrimaryKey(Integer id);

    Eodetail selectEodetailByPrimaryKey(Integer id);

    int updateEodetailSelective(Eodetail eodetail);
}
