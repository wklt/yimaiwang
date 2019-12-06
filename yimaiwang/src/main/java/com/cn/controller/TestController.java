package com.cn.controller;

import com.cn.entity.*;
import com.cn.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TestController {

    public static int count = 0;
    public static HashMap<String, Eproduct> map = new HashMap<String, Eproduct>();
    @Autowired
    AllService allservice;


    //登陆验证
    @RequestMapping("login")
    public String login(HttpSession session, HttpServletRequest request, String loginname, String password) {
        Euser user = new Euser(loginname, password);
        Euser selectuser = allservice.selectUsers(user);
        if (selectuser == null) {
            return "login";
        } else {
            session.setAttribute("user", selectuser);
            session.setAttribute("username", selectuser.getLoginname());
            //显示左边
            List<Leibie> leibies = allservice.selectLeibie();
            HashMap<List<Epcategory>,String > map=new HashMap<List<Epcategory>,String >();
            //request存数据取不到
            for (Leibie leibie : leibies) {
                List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
                String name=leibie.getName();
                map.put(epcategories,name);
            }
            session.setAttribute("map", map);
            List<Eproduct> selectproduct = allservice.selectproducts();
            int totalPage = selectproduct.size();
            int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
            int ye = 1;
            List<Eproduct> sproducts = allservice.getAllgetAllByPrimaryKeyid(ye - 1);
            session.setAttribute("sproducts", sproducts);
            session.setAttribute("totalPage", totalPage);
            session.setAttribute("zonye", zonye);
            session.setAttribute("ye", ye);
            List<News> newsAll = allservice.getList2();
            session.setAttribute("newsAll",newsAll);
            return "main";
        }
    }

    //注册
    @RequestMapping("register")
    public String register(HttpSession session, HttpServletRequest request, Euser user) {
        allservice.insertUser(user);
        return "login";
    }

    //管理员首页
    @RequestMapping("adminshouye")
    public String adminshouye(HttpSession session, HttpServletRequest request, String leftmessage){
        session.setAttribute("leftmessage",leftmessage);
        return "HCManager/main";
    }

    //返回前台
    @RequestMapping("goshouye")
    public String goshouye(HttpSession session) {
        String leftmessage = null;
        session.setAttribute("leftmessage", leftmessage);
        //显示左边
        List<Leibie> leibies = allservice.selectLeibie();
        HashMap<List<Epcategory>, String> map = new HashMap<List<Epcategory>, String>();
        //request存数据取不到
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            String name = leibie.getName();
            map.put(epcategories, name);
        }
        session.setAttribute("map", map);
        //显示右边
        List<News> newsAll = allservice.getList2();
        session.setAttribute("newsAll", newsAll);
        //显示产品
        List<Eproduct> selectproduct = allservice.selectproducts();
        int totalPage = selectproduct.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Eproduct> sproducts = allservice.getAllgetAllByPrimaryKeyid(ye - 1);
        session.setAttribute("sproducts", sproducts);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        return "main";
    }

    //注销
    @RequestMapping("zhuxiao")
    public String zhuxiao(HttpSession session,HttpServletRequest request){
        session.invalidate();
        HttpSession session1=request.getSession();
        return goshouye(session);
    }


    //----------------------------------------------------------------------留言管理
    @RequestMapping("liuyan")
    public String getAll(HttpServletRequest request,HttpSession session){
        List<Comment> commentList = allservice.getList();
        String leftmessage="在线留言";
        session.setAttribute("leftmessage",leftmessage);
        request.setAttribute("commentList", commentList);
        return "liuyan";
    }

    @RequestMapping("liuyan2")
    public String getAll2(HttpServletRequest request, HttpSession session){
        List<Comment> comment = allservice.getList();
        int totalPage = comment.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Comment> commentAll = allservice.selectcommentPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        request.setAttribute("commentAll", commentAll);
        return "HCManager/liuyan2";
    }

    @RequestMapping("addliu")
    public String addliu(HttpServletRequest request,String nicheng,String neirong,HttpSession session){
        Date createdate=new Date();
        Date replytime=null;
        String reply=null;
        Comment comment=new Comment(6,reply,neirong,createdate,replytime,nicheng);
        System.out.println(comment);
        allservice.addliu(comment);
        return getAll(request,session);
    }

    @RequestMapping("updateliu")
    public String updateliu(HttpServletRequest request,Integer ecId){
        Comment comment = allservice.selectByPrimaryid(ecId);
        request.setAttribute("comment",comment);
        return "HCManager/updateliu";
    }

    @RequestMapping("updateliu2")
    public String updateliu2(HttpServletRequest request, HttpSession session,Integer ecId,String ecReply){
        Date ecReplyTime=new Date();
        Comment comment=new Comment(ecId,ecReply,ecReplyTime);
        allservice.updateByid(comment);
        return getAll2(request,session);
    }

    @RequestMapping("delliu")
    public String delliu(HttpServletRequest request, HttpSession session,Integer ecId){
        allservice.deleteByid(ecId);
        System.out.println(ecId);
        return getAll2(request,session);
    }





    //-------------------------------------------------------------------新闻管理
    @RequestMapping("news")
    public String getNews(HttpServletRequest request,HttpSession session){
        List<News> enewee = allservice.getList2();
        int totalPage = enewee.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<News> newsList = allservice.selectnewsPage(ye - 1);
        request.setAttribute("newsList",newsList);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        return "HCManager/news";
    }

    @RequestMapping("updatenews")
    public String updatenews(HttpServletRequest request,Integer id){
        News news = allservice.selectByPrimaryid2(id);
        request.setAttribute("news",news);
        return "HCManager/updatenews";
    }

    @RequestMapping("updatenews2")
    public String updatenews2(HttpServletRequest request,HttpSession session,Integer id,String content,String title){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String createtime=sdf.format(date);
        News news=new News(id,title,content,createtime);
        allservice.updateByPrimaryid(news);
        return getNews(request,session);
    }

    @RequestMapping("delnews")
    public String delnews(HttpServletRequest request,HttpSession session,Integer id){
        allservice.deleteByPrimaryid(id);
        return getNews(request,session);
    }

    @RequestMapping("addxinwen")
    public String addnews2(HttpServletRequest request,HttpSession session,Integer id,String content,String title){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String createtime=sdf.format(date);
        News news=new News(id,title,content,createtime);
        allservice.insertNews(news);
        return getNews(request,session);
    }

    //新闻前台
    @RequestMapping("news2")
    public String getNews2(HttpServletRequest request, HttpServletResponse response){
        List<News> newsAll = allservice.getList2();
        request.setAttribute("newsAll",newsAll);
        return "right";
    }

    @RequestMapping("shownews")
    public String shownews(HttpServletRequest request,Integer id){
        News show = allservice.selectByPrimaryid2(id);
        request.setAttribute("show",show);
        return "shownews";
    }


    //-----------------------------------------------------------------用户管理
    @RequestMapping("userAll")
    public String userAll(HttpServletRequest request,HttpSession session){
        List<Euser> euser = allservice.getByAll();
        int totalPage = euser.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Euser> userAll = allservice.selectuserByPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        request.setAttribute("userAll", userAll);
        return "HCManager/user";
    }

    @RequestMapping("updateuser")
    public String updateuser(HttpServletRequest request,Integer id){
        Euser euser = allservice.selectUserid(id);
        request.setAttribute("euser",euser);
        return "HCManager/updateuser";
    }

    @RequestMapping("updateuser2")
    public String updatenuser2(HttpServletRequest request,HttpSession session,Integer id, String loginname,
                               String username, String password, Integer sex, String identitycode,
                               String email, String mobile,  String birthday, String address){
        Integer type=0;
        Euser euser=new Euser(id,loginname, username, password, sex,  identitycode, email,  mobile, type, birthday, address);
        allservice.updateUserid(euser);
        return userAll(request,session);
    }

    @RequestMapping("deluser")
    public String deluser(HttpServletRequest request,Integer id,HttpSession session){
        allservice.deleteUserid(id);
        return userAll(request,session);
    }

    @RequestMapping("adduser")
    public String adduser(HttpServletRequest request,HttpSession session,Integer id, String loginname,
                          String username, String password, Integer sex, String identitycode,
                          String email, String mobile, String birthday, String address){
        Integer type=0;
        Euser euser=new Euser(id,loginname, username, password, sex,  identitycode, email,  mobile, type, birthday, address);
        allservice.insertUser(euser);
        return userAll(request,session);
    }



    //---------------------------------------------------------前台商品
    @RequestMapping("showproduct")
    public String showproduct(HttpSession session, HttpServletRequest request,Integer id,Integer ye){
        List<Eproduct> eproduct = allservice.selectproductsId(id);
        int totalPage=eproduct.size();
        int zonye=totalPage%8==0?(totalPage/8):(totalPage/8+1);
        ye=1;
        List<Eproduct> sproducts = allservice.selectProductsidpage(id,(ye-1));
        request.setAttribute("sproducts", sproducts);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        session.setAttribute("epcategoryId",id);
        return "showproduct";
    }

    //查看商品详情
    @RequestMapping("details")
    public String details(HttpSession session, HttpServletRequest request, Integer id) {
        Eproduct eproduct = allservice.selectProductid(id);
        request.setAttribute("eproduct", eproduct);
        return "details";
    }



    //----------------------------------------------------------分类管理
    @RequestMapping("fenlei")
    public String fenleiAll(HttpSession session){
        //显示左边
        List<Leibie> lei = allservice.selectLeibie();
        int totalPage = lei.size();
        int zonye = totalPage % 2 == 0 ? (totalPage / 2) : (totalPage / 2 + 1);
        int ye = 1;
        List<Leibie> leibies = allservice.selectleibiePage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        HashMap<List<Epcategory>, Leibie > mapleibie=new HashMap<List<Epcategory>,Leibie >();
        //request存数据取不到
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories,leibie);
        }
        session.setAttribute("mapleibie", mapleibie);
        session.setAttribute("leibies",leibies);
        return "HCManager/fenlei";
    }

    //删除分类
    @RequestMapping("delfenlei")
    public String delfenlei(HttpServletRequest request,Integer id,HttpSession session){
        allservice.deleteleibieid(id);
        return fenleiAll(session);
    }

    @RequestMapping("delfenlei2")
    public String delfenlei2(HttpServletRequest request,Integer id,HttpSession session){
        allservice.deletePcategoryid(id);
        return fenleiAll(session);
    }

    //添加分类
    @RequestMapping("addfenlei")
    public String addfenlei(HttpSession session, String fumulu, String name) {
        int parentid = Integer.parseInt(fumulu);
        if (parentid == 0) {
            Leibie leibie = new Leibie( name);
            allservice.insertleibie(leibie);
        } else {
            Epcategory epcategory = new Epcategory(name,parentid);
            allservice.insertPcategory(epcategory);
        }
        return fenleiAll(session);
    }

    //查询根目录
    @RequestMapping("updateleibie")
    public String updateleibie(HttpServletRequest request,Integer id){
        Epcategory epcategory = allservice.selectPcategoryid(id);
        request.setAttribute("epcategory",epcategory);
        return "HCManager/updateleibie";
    }


    @RequestMapping("updateleibie2")
    public String updateleibie2(Integer parentid,Integer id,String name,HttpSession session){
        Epcategory epcategory=new Epcategory(id,name,parentid);
        allservice.updatePcategoryid(epcategory);
        return fenleiAll(session);
    }

    @RequestMapping("/updatefenlei")
    public String updatefenlei(HttpServletRequest request, Integer id) {
        Leibie leibie = allservice.selectleibieid(id);
        request.setAttribute("leibie", leibie);
        return "HCManager/updatefenlei";
    }

    //updateleibiefinally修改一级分类
    @RequestMapping("/updatefenlei2")
    public String updatefenlei2(HttpSession session, Integer id ,String name) {
        Leibie leibie=new Leibie(id,name);
        allservice.updateLeibieid(leibie);
        return fenleiAll(session);
    }


    //-------------------------------------------------------商品管理
    //显示商品showgoods
    @RequestMapping("/showgoods")
    public String showgoods(HttpServletRequest request, HttpSession session) {
        List<Eproduct> selectproduct = allservice.getAllproductid();
        int totalPage = selectproduct.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Eproduct> products = allservice.getAllgetAllByPrimaryKeyid(ye-0);
        request.setAttribute("products", products);
        session.setAttribute("totalPage",totalPage);
        session.setAttribute("zonye",zonye);
        session.setAttribute("ye",ye);
        return "HCManager/goods";
    }

    //addgoods管理员新增商品
    @RequestMapping("/addgoods")
    public String deletegoods(HttpSession session, HttpServletRequest request) {
        List<Epcategory> epcategories = allservice.selectAllEpcategory();
        request.setAttribute("epcategories", epcategories);
        return "HCManager/addgoods";
    }

    @RequestMapping("/addgoods2")
    public String addgoods2(HttpServletRequest request, @RequestParam MultipartFile filename, HttpSession session) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int categorylevel1id = Integer.parseInt(request.getParameter("categorylevel1id"));
        Float price = Float.parseFloat(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        //MultipartFile处理上传文件的对象
        System.out.println("执行上传文件操作!");
        //获取文件上传的位置
        //String basePath = session.getServletContext().getRealPath("upload");
        String basePath = "E:\\ideaspace\\yimaiwang\\src\\main\\webapp\\upload";
        //以日期创建二级文件目录
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //判断此文件是否存在,不存在就重新创建
        File file = new File(basePath, datePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取文件名,并且拼接文件名
        String fname = filename.getOriginalFilename();
        //获取一个随机序列,防止不同用户文件名一样(文件名字一样的话会被新的覆盖),UUID.randomUUID()是获取随机序列的方法;
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fname = uuid + "-" + fname;
        //对文件进行保存
        try {
            filename.transferTo(new File(file, fname));
            Eproduct product =
                    new Eproduct(name, description, price, stock, categorylevel1id, datePath + "/" + fname);
            allservice.insertProduct(product);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return showgoods(request,session);
    }

    @RequestMapping("/delgoods")
    public String delgoods(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteproductid(id);
        return showgoods(request,session);
    }

    //修改商品信息
    //管理员修改商品updategoods
    @RequestMapping("/updategoods")
    public String updategoods(HttpSession session, HttpServletRequest request, Integer id) {
        Eproduct eproduct = allservice.selectProductid(id);
        request.setAttribute("eproduct", eproduct);
        List<Epcategory> epcategories = allservice.selectAllEpcategory();
        request.setAttribute("epcategories", epcategories);
        return "HCManager/updategoods";
    }

    //updategoods2修改商品
    @RequestMapping("/updategoods2")
    public String updategoods2(HttpServletRequest request, @RequestParam MultipartFile filename, HttpSession session) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int categorylevel1id = Integer.parseInt(request.getParameter("categorylevel1id"));
        Float price = Float.parseFloat(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        //MultipartFile处理上传文件的对象
        System.out.println("执行上传文件操作!");
        //获取文件上传的位置
        //String basePath = session.getServletContext().getRealPath("upload");
        String basePath = "E:\\ideaspace\\yimaiwang\\src\\main\\webapp\\upload";
        //以日期创建二级文件目录
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //判断此文件是否存在,不存在就重新创建
        File file = new File(basePath, datePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取文件名,并且拼接文件名
        String fname = filename.getOriginalFilename();
        //获取一个随机序列,防止不同用户文件名一样(文件名字一样的话会被新的覆盖),UUID.randomUUID()是获取随机序列的方法;
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fname = uuid + "-" + fname;
        //对文件进行保存
        try {
            filename.transferTo(new File(file, fname));
            Eproduct product =
                    new Eproduct(id, name, description, price, stock, categorylevel1id, datePath + "/" + fname);
            allservice.updateProductSelective(product);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return showgoods(request,session);
    }

    //------------------------------------------------------购物车
    @RequestMapping("gomai")
    public String gomai(HttpServletRequest  request, Integer id){




        return  "gomai";
    }

    //查看购物车showgouwu
    @RequestMapping("/showgouwu")
    public String showgouwu(HttpSession session, HttpServletRequest request) {
        //判断用户是否登录
        Euser user = (Euser) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            List<Eorder> eorder = allservice.selectallorderByuserid(user.getId());
            int totalPage = eorder.size();
            int zonye = totalPage % 3 == 0 ? (totalPage / 3) : (totalPage / 3 + 1);
            int ye = 1;
            List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1));
            session.setAttribute("totalPage", totalPage);
            session.setAttribute("zonye", zonye);
            session.setAttribute("ye", ye);
            request.setAttribute("eorders", eorders);
            return "showgouwu";
        }
    }


    @RequestMapping("addgouwu")
    public String addgouwu(HttpServletRequest  request,HttpSession session, Integer id){
        Euser user = (Euser) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            Eproduct eproduct = allservice.selectProductid(id);
            //根据商品id判断购物车是否有此物品
            Eorder eorder1 = allservice.selectByproductid(id, user.getId());
            if (eorder1 == null) {
                //购物车没有就新建
                Eorder eorder = new Eorder(eproduct.getId(), user.getId(), eproduct.getName(), eproduct.getFilename(),
                        1, user.getLoginname(), eproduct.getPrice());
                allservice.insertorderSelective(eorder);
                return showgouwu(session, request);
            } else {
                //购物车有就加一件
                Eorder eorder2 = new Eorder(eorder1.getId(), eorder1.getQuantity() + 1, eorder1.getCost() + eproduct.getPrice());
                allservice.updateorderSelective(eorder2);
                return showgouwu(session, request);
            }
        }
    }

    //删除购物车的东西deleteorder
    @RequestMapping("/deleteorder")
    public String deleteorder(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteByOrderKey(id);
        return showgouwu(session, request);
    }


    //updateorder修改购物车的内容
    @RequestMapping("/updateorder")
    public String updateorder(HttpSession session, HttpServletRequest request, Integer id) {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        //找到订单
        Eorder eorder = allservice.selectByPrimaryKey(id);
        //找到商品单价
        Eproduct eproduct = allservice.selectProductid(eorder.getProductid());
        Float cost = eproduct.getPrice() * quantity;
        //修改购物车信息
        Eorder eorder11 = new Eorder(id, quantity, cost);
        allservice.updateorderSelective(eorder11);
        return showgouwu(session, request);
    }

    //生成订单createEodetail
    @RequestMapping("/createEodetail")
    public String createEodetail(HttpSession session, HttpServletRequest request, String idss) {
        String[] id = idss.split(",");
        float cost = 0;
        String details = "";
        for (String s : id) {
            //找到购物车中购买物品的对应order的id录入详情
            int id1 = Integer.parseInt(s);
            Eorder eorderbuy = allservice.selectByPrimaryKey(id1);
            cost = cost + eorderbuy.getCost();
            details = details + "编号:" + eorderbuy.getId() + "  产品名称:" + eorderbuy.getProductname() + "  产品数量:" + eorderbuy.getQuantity() + "  产品小计:" + eorderbuy.getCost() + ";";
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Euser user = (Euser) session.getAttribute("user");
        Eodetail eodetail = new Eodetail(user.getId(), user.getLoginname(), details, user.getAddress(), new Date(), cost, uuid, "下单", "已支付");
        allservice.insertEodetailSelective(eodetail);
        //数据一致性;保证库存减少,购物车订单删除
        for (String s : id) {
            //找到购物车中购买物品的对应order的id录入详情
            int id1 = Integer.parseInt(s);
            Eorder eorderbuy = allservice.selectByPrimaryKey(id1);
            //产品表减少库存
            //找到商品
            Eproduct eproduct = allservice.selectProductid(eorderbuy.getProductid());
            //原有的商品库存eproduct.getStock();减去的数量eorderbuy.getQuantity();
            int stock = eproduct.getStock() - eorderbuy.getQuantity();
            Eproduct eproduct22 = new Eproduct(eproduct.getId(), stock);
            //更新产品库存
            allservice.updateProductSelective(eproduct22);
            //从购物车中删除
            allservice.deleteByOrderKey(id1);
        }
        return showgouwu(session, request);
    }

    //查看自己的订单showmybuy
    @RequestMapping("/showmybuy")
    public String showmybuy(HttpSession session, HttpServletRequest request) {
        Euser user = (Euser) session.getAttribute("user");
        List<Eodetail> eodetail = allservice.selectmyEodetail(user.getId());
        int totalPage = eodetail.size();
        int zonye = totalPage % 4 == 0 ? (totalPage / 4) : (totalPage / 4 + 1);
        int ye = 1;
        List<Eodetail> eodetails = allservice.selectmyEodetailByPage(user.getId(), (ye - 1));
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        request.setAttribute("eodetails", eodetails);
        return "showmybuy";
    }



    //--------------------------------------------后台订单
    //订单管理先显示showeodetail
    @RequestMapping("/showeodetail")
    public String showeodetail(HttpSession session, HttpServletRequest request) {
        List<Eodetail> eodetail = allservice.selectAllEodetail();
        int totalPage = eodetail.size();
        int zonye = totalPage % 8 == 0 ? (totalPage / 8) : (totalPage / 8 + 1);
        int ye = 1;
        List<Eodetail> eodetails = allservice.selectEodetailByPage(ye - 1);
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("zonye", zonye);
        session.setAttribute("ye", ye);
        request.setAttribute("eodetails", eodetails);
        return "HCManager/eodetail";
    }

    //管理员删除订单deleteeodetails
    @RequestMapping("/deleteeodetails")
    public String deleteeodetails(HttpSession session, HttpServletRequest request, Integer id) {
        allservice.deleteEodetailByPrimaryKey(id);
        return showeodetail(session, request);
    }

    //updateeodetails管理员修改订单
    @RequestMapping("/updateeodetails")
    public String updateeodetails(HttpSession session, HttpServletRequest request, Integer id) {
        Eodetail eodetail = allservice.selectEodetailByPrimaryKey(id);
        request.setAttribute("eodetail", eodetail);
        return "HCManager/updateeodetails";
    }

    //updateeodetailsfinally管理员修改订单
    @RequestMapping("/updateeodetails2")
    public String updateeodetailsfinally(HttpSession session, HttpServletRequest request, Eodetail eodetail) {
        allservice.updateEodetailSelective(eodetail);
        return showeodetail(session, request);
    }



    //浏览记录功能
    public void jilu(HttpSession session, Integer id) {
        Eproduct eproductaa = allservice.selectProductid(id);
        List<Eproduct> listEproducts = new ArrayList<Eproduct>();
        if (count == 0) {
            map.put("1", eproductaa);
            listEproducts.add(map.get("1"));
            session.setAttribute("listEproducts", listEproducts);
        } else if (count == 1) {
            map.put("2", eproductaa);
            listEproducts.add(map.get("1"));
            listEproducts.add(map.get("2"));
            session.setAttribute("listEproducts", listEproducts);
        } else if (count == 2) {
            map.put("3", eproductaa);
            listEproducts.add(map.get("1"));
            listEproducts.add(map.get("2"));
            listEproducts.add(map.get("3"));
            session.setAttribute("listEproducts", listEproducts);
        } else if (count > 2) {
            //查看记录有没有这个商品,去重
            boolean flag = true;
            if (eproductaa.getName().equals(map.get("1").getName())) {
                flag = false;
            }
            if (eproductaa.getName().equals(map.get("2").getName())) {
                flag = false;
            }
            if (eproductaa.getName().equals(map.get("3").getName())) {
                flag = false;
            }
            if (flag == true) {
                map.remove("1");
                Eproduct eproductaa2 = map.get("2");
                Eproduct eproductaa3 = map.get("3");
                map.remove("2");
                map.remove("3");
                map.put("1", eproductaa2);
                map.put("2", eproductaa3);
                map.put("3", eproductaa);
                listEproducts.add(map.get("1"));
                listEproducts.add(map.get("2"));
                listEproducts.add(map.get("3"));
                session.setAttribute("listEproducts", listEproducts);
            }
        }
        count++;
    }

















    //管理员管理商品分页--------------------------------------------------------
    @RequestMapping("/adnextye")
    public String adnextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.getAllgetAllByPrimaryKeyid((ye - 1) * 8);
        request.setAttribute("products", products);
        return "HCManager/goods";
    }

    @RequestMapping("/adlastye")
    public String adlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.getAllgetAllByPrimaryKeyid((ye - 1) * 8);
        request.setAttribute("products", products);
        return "HCManager/goods";
    }

    @RequestMapping("/adgofinal")
    public String adgofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.getAllgetAllByPrimaryKeyid((ye - 1) * 8);
        request.setAttribute("products", products);
        return "HCManager/goods";
    }

    //跳转到相应页面
    @RequestMapping("/adtiaoye")
    public String adtiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> products = allservice.getAllgetAllByPrimaryKeyid((ye - 1) * 8);
        request.setAttribute("products", products);
        return "HCManager/goods";
    }



    //管理员管理用户分页--------------------------------------------------------
    @RequestMapping("/yhnextye")
    public String yhnextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Euser> userAll = allservice.selectuserByPage((ye - 1)*8);
        request.setAttribute("userAll", userAll);
        return "HCManager/user";
    }

    @RequestMapping("/yhlastye")
    public String yhlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Euser> userAll = allservice.selectuserByPage((ye - 1)*8);
        request.setAttribute("userAll", userAll);
        return "HCManager/user";
    }

    @RequestMapping("/yhgofinal")
    public String yhgofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Euser> userAll = allservice.selectuserByPage((ye - 1)*8);
        request.setAttribute("userAll", userAll);
        return "HCManager/user";
    }

    //跳转到相应页面
    @RequestMapping("/yhtiaoye")
    public String yhtiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Euser> userAll = allservice.selectuserByPage((ye - 1)*8);
        request.setAttribute("userAll", userAll);
        return "HCManager/user";
    }

    //管理员管理新闻分页--------------------------------------------------------
    @RequestMapping("/xwnextye")
    public String xwnextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<News> newsList = allservice.selectnewsPage((ye - 1)*8);
        request.setAttribute("newsList",newsList);
        return "HCManager/news";
    }

    @RequestMapping("/xwlastye")
    public String xwlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<News> newsList = allservice.selectnewsPage((ye - 1)*8);
        request.setAttribute("newsList",newsList);
        return "HCManager/news";
    }

    @RequestMapping("/xwgofinal")
    public String xwgofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<News> newsList = allservice.selectnewsPage((ye - 1)*8);
        request.setAttribute("newsList",newsList);
        return "HCManager/news";
    }

    //跳转到相应页面
    @RequestMapping("/xwtiaoye")
    public String xwtiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<News> newsList = allservice.selectnewsPage((ye - 1)*8);
        request.setAttribute("newsList",newsList);
        return "HCManager/news";
    }


    //管理员管理留言分页--------------------------------------------------------
    @RequestMapping("/lynextye")
    public String lynextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Comment> commentAll = allservice.selectcommentPage((ye - 1)*8);
        request.setAttribute("commentAll",commentAll);
        return "HCManager/liuyan2";
    }

    @RequestMapping("/lylastye")
    public String lylastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Comment> commentAll = allservice.selectcommentPage((ye - 1)*8);
        request.setAttribute("commentAll",commentAll);
        return "HCManager/liuyan2";
    }

    @RequestMapping("/lygofinal")
    public String lygofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Comment> commentAll = allservice.selectcommentPage((ye - 1)*8);
        request.setAttribute("commentAll",commentAll);
        return "HCManager/liuyan2";
    }

    //跳转到相应页面
    @RequestMapping("/lytiaoye")
    public String lytiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Comment> commentAll = allservice.selectcommentPage((ye - 1)*8);
        request.setAttribute("commentAll",commentAll);
        return "HCManager/liuyan2";
    }


    //管理前台商品分页--------------------------------------------------------
    @RequestMapping("/spnextye")
    public String spnextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> sproducts = allservice.getAllgetAllByPrimaryKeyid((ye - 1)*8);
        session.setAttribute("sproducts", sproducts);
        return "showproduct";
    }

    @RequestMapping("/splastye")
    public String splastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> sproducts = allservice.getAllgetAllByPrimaryKeyid((ye - 1)*8);
        session.setAttribute("sproducts", sproducts);
        return "showproduct";
    }

    @RequestMapping("/spgofinal")
    public String spgofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Eproduct> sproducts = allservice.getAllgetAllByPrimaryKeyid((ye - 1)*8);
        session.setAttribute("sproducts", sproducts);
        return "showproduct";
    }

    //跳转到相应页面
    @RequestMapping("/sptiaoye")
    public String sptiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eproduct> sproducts = allservice.getAllgetAllByPrimaryKeyid((ye - 1)*8);
        session.setAttribute("sproducts", sproducts);
        return "showproduct";
    }


    //查看自己购物车分页--------------------------------------------------------
    @RequestMapping("/gouwunextye")
    public String gouwunextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }

    @RequestMapping("/gouwulastye")
    public String gouwulastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }

    @RequestMapping("/gouwugofinal")
    public String gouwugofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }

    //跳转到相应页面
    @RequestMapping("/gouwutiaoye")
    public String gouwutiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        Euser user = (Euser) session.getAttribute("user");
        List<Eorder> eorders = allservice.selectorderByuseridPage(user.getId(), (ye - 1) * 3);
        request.setAttribute("eorders", eorders);
        return "showgouwu";
    }



    //管理员管理订单分页--------------------------------------------------------
    @RequestMapping("/ordernextye")
    public String ordernextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCManager/eodetail";
    }

    @RequestMapping("/orderlastye")
    public String orderlastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCManager/eodetail";
    }

    @RequestMapping("/ordergofinal")
    public String ordergofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCManager/eodetail";
    }

    //跳转到相应页面
    @RequestMapping("/ordertiaoye")
    public String ordertiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Eodetail> eodetails = allservice.selectEodetailByPage((ye - 1) * 8);
        request.setAttribute("eodetails", eodetails);
        return "HCManager/eodetail";
    }


    //管理员管理分类分页--------------------------------------------------------
    @RequestMapping("/flnextye")
    public String leinextye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") + 1;
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectleibiePage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCManager/fenlei";
    }

    @RequestMapping("/fllastye")
    public String leilastye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("ye") - 1;
        if (ye < 1) {
            ye = 1;
        }
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectleibiePage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCManager/fenlei";
    }

    @RequestMapping("/flgofinal")
    public String leigofinal(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = (Integer) session.getAttribute("zonye");
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectleibiePage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCManager/fenlei";
    }

    //跳转到相应页面
    @RequestMapping("/fltiaoye")
    public String leitiaoye(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
        int ye = Integer.parseInt(request.getParameter("ye"));
        int zonye = (Integer) session.getAttribute("zonye");
        if (ye < 1) {
            ye = 1;
        } else if (ye > zonye) {
            ye = zonye;
        }
        session.setAttribute("ye", ye);
        List<Leibie> leibies = allservice.selectleibiePage((ye - 1) * 2);
        HashMap<List<Epcategory>, Leibie> mapleibie = new HashMap<List<Epcategory>, Leibie>();
        for (Leibie leibie : leibies) {
            List<Epcategory> epcategories = allservice.selectEpcategoryByParentId(leibie.getId());
            mapleibie.put(epcategories, leibie);
        }
        request.setAttribute("mapleibie", mapleibie);
        return "HCManager/fenlei";
    }
}
