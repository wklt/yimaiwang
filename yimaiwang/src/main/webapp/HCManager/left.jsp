<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页左侧导航</title>
    <link rel="stylesheet" type="text/css" href="../css/public.css" />
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/public.js"></script>
    <head></head>

<body id="bg">
<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <dl>
            <dt>
                <b>用户管理</b>
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a class="cks" href="#" target="right">用户管理</a>
                <a href="#" >新增</a>
            </dd>

        </dl>
        <dl>
            <dt>
                <b>商品信息</b>
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a class="cks" href="#" target="right">分类管理</a>
                <a href="#" >新增</a>
            </dd>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a class="cks" href="#" target="right">商品管理</a>
                <a href="#" >新增</a>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <b>订单管理</b>
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="#" target="right" class="cks">订单管理</a>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <b>留言管理</b>
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="../liuyan2.do" target="right" class="cks">留言管理</a>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <b>新闻管理</b>
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="#" target="right" class="cks">新闻管理</a>
                <a href="#">新增</a>
            </dd>
        </dl>
    </div>

</div>


</body>
</html>
