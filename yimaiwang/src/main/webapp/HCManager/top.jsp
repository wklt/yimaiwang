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
            height: 65px;
        }
        html{
            overflow-x: hidden;
            overflow-y: hidden;
        }
        a{
            text-decoration: none;
        }
        #a2{
            background-color: orange;
            height: 30px;
            margin-top: -15px;
        }
        .zz:hover{
            background-color:orange;
        }
    </style>
</head>

<body>
<div id="top">
    <center>
        <table cellpadding="1" cellspacing="1" style="text-align: center">
            <tr>
                <td width="300px" rowspan="2"><span style="float: right"><img src="img/easybuy.png"></span></td>
                <td width="550px" colspan="6"></td>
                <td width="400px"><span style="float: right;"><a href="goshouye.do" target="_parent">返回前台页面</a></span></td>
            </tr>
            <tr>
                <td class="zz"><a href="HCManager/main.jsp" target="_parent">首页</a></td>
                <td class="zz"><a href="userAll.do" target="right">用户</a></td>
                <td class="zz"><a href="showgoods.do" target="right">商品</a></td>
                <td class="zz"><a href="showeodetail.do" target="right">订单</a></td>
                <td class="zz"><a href="liuyan2.do" target="right">留言</a></td>
                <td class="zz"><a href="news.do" target="right">新闻</a></td>
                <td></td>
            </tr>
        </table>
    </center>
</div>
<div id="a2">
    <span style="float: right;margin-right: 100px">管理员**您好,今天是2019-11-25,欢迎回到管理后台。</span>
</div>
<c:choose>
    <c:when test="${!empty leftmessage}">
        <span style="margin-left: 120px">您现在的位置:易买网&nbsp;>&nbsp;${leftmessage }</span>
    </c:when>
</c:choose>
</body>
</html>
