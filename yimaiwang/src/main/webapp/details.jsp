<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
        #div2 {
            width: 740px;
            height: 480px;
        }

        #div3 {
            width: 740px;
            height: 40px;
            margin-top: 10px;
            font-size: 20px;
        }

        #div4 {
            width: 740px;
            height: 320px;
        }
        .img {
            width: 320px;
            height: 320px;
        }

        a {
            font-size: 14px;
            text-decoration: none;
        }
        .a5{
            width: 400px;
            height: 50px;
            background-color: #FDF4CE;
            margin-left: 340px;
            text-align: center;
            margin-top: 50px;
        }
        #a3{
            width: 700px;
            padding: 20px;
            float: left;
            border-top: 2px solid orange;
            margin-top: 10px;
        }
        .a7{
            line-height: 30px;
            width: 400px;
            height: 60px;
            margin-left: 340px;
        }
        span{
            font-size: 25px;
            color: red;
        }
    </style>
</head>

<body>
<div id="div2">
    <div id="div3">
        <b>${eproduct.name }</b>
        <hr style="border: 1px dashed grey">
    </div>
    <div id="div4">
        <div style="float: left"><img src="upload/${eproduct.filename }" class="img"></div>
        <div class="a7">
            商城价:<span><b>${eproduct.price }</b></span><br>
            库&nbsp;&nbsp;&nbsp;存:&nbsp;&nbsp;${eproduct.stock }
        </div>
        <div class="a5">
            <a href="gomai.do?id=${eproduct.id }"><img src="img/buyproduct.png" style="margin-top: 8px"></a>
            <a href="addgouwu.do?id=${eproduct.id }">放入购物车</a>
        </div>
    </div>
    <div id="a2">
        <img src="img/2.png" style="width: 15px; height:15px"><b>商品详情</b>
        <a onclick="history.back(-1)" style="float: right">返回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
    </div>
    <div id="a3">
        ${eproduct.description }
    </div>

    <script type="text/javascript">
    </script>
</div>
</body>
</html>
