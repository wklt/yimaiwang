package com.cn.controller;

import com.cn.entity.Comment;
import com.cn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    CommentService commentService;

    @RequestMapping("liuyan")
    public String getAll(HttpServletRequest request){
        List<Comment> commentList = commentService.getList();
        request.setAttribute("commentList", commentList);
        return "liuyan";
    }

    @RequestMapping("liuyan2")
    public String getAll2(HttpServletRequest request){
        List<Comment> commentList = commentService.getList();
        request.setAttribute("commentList", commentList);
        return "HCManager/liuyan2";
    }
    @RequestMapping("addliu")
    public String addliu(HttpServletRequest request,String nicheng,String neirong){
        Date createdate=new Date();
        Date replytime=null;
        String reply=null;
        Comment comment=new Comment(6,reply,neirong,createdate,replytime,nicheng);
        System.out.println(comment);
        commentService.addliu(comment);
        return getAll(request);
    }

    @RequestMapping("updateliu")
    public String updateliu(HttpServletRequest request,String nicheng,String neirong){
        Date createdate=new Date();
        Date replytime=null;
        String reply=null;
        Comment comment=new Comment(6,reply,neirong,createdate,replytime,nicheng);
        System.out.println(comment);
        commentService.addliu(comment);
        return getAll2(request);
    }

    @RequestMapping("delliu")
    public String delliu(HttpServletRequest request,int id){
        commentService.deleteByid(id);
        System.out.println(id);
        return getAll2(request);
    }

}
