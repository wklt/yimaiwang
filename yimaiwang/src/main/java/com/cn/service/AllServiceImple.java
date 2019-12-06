package com.cn.service;

import com.cn.dao.*;
import com.cn.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllServiceImple implements AllService {
    @Autowired
    EuserMapper euserMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    LeibieMapper leibieMapper;
    @Autowired
    EpcategoryMapper epcategoryMapper;
    @Autowired
    EproductMapper eproductMapper;
    @Autowired
    EorderMapper eorderMapper;
    @Autowired
    EodetailMapper eodetailMapper;


    //-----------------------------------------------------------登录
    public Euser selectUsers(Euser euser) {
        return euserMapper.selectuser(euser);
    }

    public List<Leibie> selectLeibie() {
        return leibieMapper.selectAll();
    }

    public List<Epcategory> selectEpcategoryByParentId(Integer id) {
        return epcategoryMapper.selectAll(id);
    }

    public List<Eproduct> selectproducts() {
        return eproductMapper.getAllproduct();
    }

    public int insertUser(Euser euser) {
        return euserMapper.insert(euser);
    }



    //-----------------------------------------------------------留言
    public List<Comment> getList() {
        return commentMapper.getAll();
    }

    public List<Comment> selectcommentPage(Integer ye) {
        return commentMapper.selectcommentPage(ye);
    }

    public int addliu(Comment comment) {
        return commentMapper.insert(comment);
    }

    public int deleteByid(Integer ecId) {
        return commentMapper.deleteByPrimaryid(ecId);
    }

    public Comment selectByPrimaryid(Integer ecId) {
        return commentMapper.selectByPrimaryKey(ecId);
    }

    public int updateByid(Comment comment) {
        return commentMapper.updateByPrimaryid(comment);
    }

    //------------------------------------------------------------新闻

    public List<News> getList2() {
        return newsMapper.getAll();
    }

    public List<News> selectnewsPage(Integer ye) {
        return newsMapper.selectnewsPage(ye);
    }

    public News selectByPrimaryid2(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryid(News news) {
        return newsMapper.updateByPrimaryKey(news);
    }

    public int deleteByPrimaryid(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    public int insertNews(News news) {
        return newsMapper.insert(news);
    }

    //----------------------------------------------------用户

    public List<Euser> getByAll() {
        return euserMapper.selectByAll();
    }

    public int deleteUserid(Integer id) {
        return euserMapper.deleteByPrimaryKey(id);
    }

    public Euser selectUserid(Integer id) {
        return euserMapper.selectByPrimaryKey(id);
    }

    public int updateUserid(Euser euser) {
        return euserMapper.updateByPrimaryKey(euser);
    }

    public List<Euser> selectuserByPage(Integer ye) {
        return euserMapper.selectuserByPage(ye);
    }

    //------------------------------------------------------------分类
    public int insertleibie(Leibie leibie) {
        return leibieMapper.insert(leibie);
    }

    public int deleteleibieid(Integer id) {
        return leibieMapper.deleteByPrimaryKey(id);
    }

    public int deletePcategoryid(Integer id) {
        return epcategoryMapper.deleteByPrimaryKey(id);
    }

    public Leibie selectleibieid(Integer id) {
        return leibieMapper.selectByPrimaryKey(id);
    }

    public int insertPcategory(Epcategory epcategory) {
        return epcategoryMapper.insert(epcategory);
    }

    public Epcategory selectPcategoryid(Integer id) {
        return epcategoryMapper.selectByPrimaryKey(id);
    }

    public int updatePcategoryid(Epcategory epcategory) {
        return epcategoryMapper.updatePcategory(epcategory);
    }


    public int updateLeibieid(Leibie leibie) {
        return leibieMapper.updateByPrimaryKey(leibie);
    }

    public List<Leibie> selectleibiePage(Integer ye) {
        return leibieMapper.selectleibiePage(ye);
    }

    //------------------------------商品


    public List<Epcategory> selectAllEpcategory() {
        return epcategoryMapper.selectAllEpcategory();
    }

    public List<Eproduct> getAllproductid() {
        return eproductMapper.getAllproduct();
    }

    public List<Eproduct> getAllgetAllByPrimaryKeyid(Integer ye) {
        return eproductMapper.getAllByPrimaryKey(ye);
    }

    public int insertProduct(Eproduct eproduct) {
        return eproductMapper.insertSelective(eproduct);
    }

    public List<Eproduct> selectProductsidpage(Integer id, Integer ye) {
        return eproductMapper.selectProductsidpage(id,ye);
    }

    public int deleteproductid(Integer id) {
        return eproductMapper.deleteByPrimaryKey(id);
    }

    public Eproduct selectProductid(Integer id) {
        return eproductMapper.selectByPrimaryKey(id);
    }

    public int updateProductSelective(Eproduct eproduct) {
        return eproductMapper.updateByPrimaryKeySelective(eproduct);
    }

    //------------------------------------前台商品

    public List<Eproduct> selectproductsId(Integer id) {
        return eproductMapper.selectproductsId(id);
    }

    //-----------------------------------------购物车

    public Eorder selectByproductid(Integer productid, Integer euserid) {
        return eorderMapper.selectByproductid(productid, euserid);
    }

    public int insertorderSelective(Eorder eorder) {
        return eorderMapper.insertSelective(eorder);
    }

    public int updateorderSelective(Eorder eorder) {
        return eorderMapper.updateorderSelective(eorder);
    }

    public List<Eorder> selectallorderByuserid(Integer id) {
        return eorderMapper.selectallorderByuserid(id);
    }

    public List<Eorder> selectorderByuseridPage(Integer id, Integer ye) {
        return eorderMapper.selectorderByuseridPage(id,ye);
    }

    public int deleteByOrderKey(Integer id) {
        return eorderMapper.deleteByPrimaryKey(id);
    }

    public Eorder selectByPrimaryKey(Integer id) {
        return eorderMapper.selectByPrimaryKey(id);
    }

    //-----------------------------------------------订单

    public int insertEodetailSelective(Eodetail eodetail) {
        return eodetailMapper.insertSelective(eodetail);
    }

    public List<Eodetail> selectmyEodetail(Integer id) {
        return eodetailMapper.selectmyEodetail(id);
    }

    public List<Eodetail> selectmyEodetailByPage(Integer id, Integer ye) {
        return eodetailMapper.selectmyEodetailByPage(id,ye);
    }

    //------------------后台
    public List<Eodetail> selectAllEodetail() {
        return eodetailMapper.selectAllEodetail();
    }

    public List<Eodetail> selectEodetailByPage(Integer ye) {
        return eodetailMapper.selectEodetailByPage(ye);
    }

    public int deleteEodetailByPrimaryKey(Integer id) {
        return eodetailMapper.deleteByPrimaryKey(id);
    }

    public Eodetail selectEodetailByPrimaryKey(Integer id) {
        return eodetailMapper.selectByPrimaryKey(id);
    }

    public int updateEodetailSelective(Eodetail eodetail) {
        return eodetailMapper.updateByPrimaryKeySelective(eodetail);
    }
}
