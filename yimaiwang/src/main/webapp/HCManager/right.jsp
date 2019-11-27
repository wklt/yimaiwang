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
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        #a3{
            width: 800px;
            padding: 20px;
            float: left;
            text-align: center;
            border-top: 2px solid orange;
            position: relative;
        }
        .d1{
            border: 1px solid black;
            text-align: center;
            width: 300px;
            height: 70px;
            position: absolute;
            left: 250px;
            top: 150px;
        }
        table{
            width: 700px;

        }
    </style>
</head>
<body >
<div >
    <div id="a2">
        <h4>管理首页</h4>

    </div>

    <div id="a3">
        <div class="d1">欢迎回来</div>
    </div>

</div>
</body>
</html>
