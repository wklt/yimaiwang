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

        #a2{
            border-bottom: 1px dotted gray;
            width: 700px;
            height: 40px;
            padding-top: 20px;
            padding-left: 15px;
            font-size: 20px;
        }
        #a3{
            width: 700px;
            padding-left: 15px;
            float: left;
            padding-top: 20px;

        }

    </style>
</head>
<body>
<div>
    <div id="a2">
        <span>${show.title}新闻标题</span>
    </div>
    <div id="a3">
        ${show.content}新闻内容
    </div>
</div>
</body>
</html>
