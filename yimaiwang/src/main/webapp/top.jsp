<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/uploadPreview.js"></script>
    <style type="text/css">
        /*#top{
            height: 55px;
            border: 1px solid skyblue;
        }*/
        html{
            overflow-x: hidden;
            overflow-y: hidden;
        }
        img{
            width: 15px;
            height: 15px;
        }
        a{
            text-decoration: none;
        }

        #a2{
            background-color: orange;
            height: 30px;
            margin-top: -15px;
        }
        ul li{
            list-style: none;
            display: inline;
            padding-left: 10px;
        }
    </style>
</head>

<body>
<div id="top">
    <center>
        <table width="1350px" cellpadding="1" cellspacing="1" border="1px solid red" style="text-align: center">
            <tr>
                <td width="300px" rowspan="2">易买网</td>
                <td width="550px" colspan="6"></td>
                <td width="500px"><span style="float: left;padding-left: 40px;">
                    <img src="img/1.png"/><a href="#">购物车</a>
                    <a href="#">登录</a>
                    <a href="#">注册</a>
                    <a href="liuyan.do" target="right">留言</a>
                    <a href="HCManager/main.jsp">管理后台</a>
                </span>
                </td>
            </tr>
            <tr>
                <td><a href="central.jsp" target="right">首页</a></td>
                <td>图书</td>
                <td>百货</td>
                <td>品牌</td>
                <td>促销</td>
                <td></td>
            </tr>
        </table>

    </center>
    <p style="background-color: orange; width: 100%"></p>
    <script type="text/javascript">
    </script>
</div>
<div id="a2">
    <ul style="margin-left: 200px">
        <li>音乐<span>|</span></li>
        <li>影视<span>|</span></li>
        <li>少儿<span>|</span></li>
        <li>动漫<span>|</span></li>
        <li>小说<span>|</span></li>
        <li>外语<span>|</span></li>
        <li>数码相机<span>|</span></li>
        <li>笔记本<span>|</span></li>
        <li>Investor Relations</li>
    </ul>
</div>
</body>
</html>
