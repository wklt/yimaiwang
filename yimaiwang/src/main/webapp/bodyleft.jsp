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
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
    <head></head>

<body id="bg">
<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <div class="line">&nbsp;&nbsp;<b>商品分类</b></div>
        <!-- <dl class="system_log">
        <dt><img class="icon1" src="../img/coin01.png" /><img class="icon2"src="../img/coin02.png" />
            首页<img class="icon3" src="../img/coin19.png" /><img class="icon4" src="../img/coin20.png" /></dt>
    </dl> -->
        <dl>
            <dt>
                <b>生活用品</b>
                <img class="icon3" src="img/coin19.png" />
                <img class="icon4" src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a class="cks" href="../user.jsp" target="main">毛巾</a>
            </dd>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a class="cks" href="../user.jsp" target="main">牙刷</a>
            </dd>
        </dl>
        <dl>
            <dt>
                <b>家用电器</b>
                <img class="icon3" src="img/coin19.png" />
                <img class="icon4" src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a class="cks" href="../banner.html"
                   target="main">电视机</a>
            </dd>
            <dd>
               <img class="coin22" src="img/2.png" />
                <a class="cks" href="opinion.html" target="main">冰箱</a>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <b>服装</b>
                <img class="icon3" src="img/coin19.png" />
                <img class="icon4" src="img/coin20.png" />
            </dt>
            <dd>
               <img class="coin22" src="img/2.png" />
                <a href="../vip.html" target="main" class="cks">男装</a>
            </dd>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="../vip.html" target="main"
                   class="cks">女装</a>
            </dd>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="../vip.html" target="main"
                   class="cks">童装</a>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <b>化妆品</b>
                <img class="icon3" src="img/coin19.png" />
                <img class="icon4" src="img/coin20.png" />
            </dt>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="../connoisseur.html" target="main" class="cks">眼影</a>
            </dd>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="../connoisseur.html" target="main" class="cks">粉底</a>
            </dd>
            <dd>
                <img class="coin22" src="img/2.png" />
                <a href="../connoisseur.html" target="main" class="cks">BB霜</a>
            </dd>
        </dl>

    </div>

</div>
</body>
</html>
