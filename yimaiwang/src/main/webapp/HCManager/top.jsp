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
        #top{
            height: 70px;
            border: 1px solid skyblue;
        }
        html{
            overflow-x: hidden;
            overflow-y: hidden;
        }
        a{
            text-decoration: none;
        }
        #a2{
            background-color: orangered;
            height: 30px;
            margin-top: -15px;
        }
    </style>
</head>

<body>
<div id="top">
    <center>
        <table cellpadding="1" cellspacing="1" border="1px solid red" style="text-align: center">
            <tr>
                <td width="300px" rowspan="2">易买网</td>
                <td width="550px" colspan="6"></td>
                <td width="400px"><span style="float: right;"><a href="main.jsp" target="_parent">返回前台页面</a></span></td>
            </tr>
            <tr>
                <td>首页</td>
                <td>用户</td>
                <td>商品</td>
                <td>订单</td>
                <td>留言</td>
                <td>新闻</td>
                <td></td>
            </tr>
        </table>
    </center>


    <script type="text/javascript">
    </script>
</div>
<div id="a2">
    <span style="float: right;margin-right: 100px">管理员**您好,今天是2019-11-25,欢迎回到管理后台。</span>
</div>
<span style="margin-left: 100px">您所在的位置是：<a href="#">易买网</a>>管理后台</span>
</body>
</html>
