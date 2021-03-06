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
        #top {
            width: 1350px;
            height: 32px;

        }

        html {
            overflow-x: hidden;
            overflow-y: hidden;
        }

        a {
            text-decoration: none;
        }

        #a2 {
            background-color: orange;
            height: 30px;
        }

        ul li {
            list-style: none;
            display: inline;
            padding-left: 10px;
        }
        .zz:hover{
            background-color:orange;
        }
    </style>
</head>

<body>
<div id="top">

    <div id="top1">
        <table width="1350px" cellpadding="0" cellspacing="0" style="text-align: center">
            <tr>
                <td width="300px" rowspan="2"><span style="float: right"><img src="img/easybuy.png"></span></td>
                <td width="550px" colspan="8"></td>
                <td width="500px">
                    <span id="span1">
                        <c:choose>
                            <c:when test="${!empty user }">
                                <%=session.getAttribute("username") %>,您好!&nbsp;&nbsp;
                            </c:when>
                        </c:choose>
                        <img src="img/gouwu.png">
                        <a href="showgouwu.do" target="right">购物车</a>&nbsp;&nbsp;
                        <c:choose>
                            <c:when test="${empty user }">
                                <a href="register.jsp" target="_blank">注册</a>&nbsp;&nbsp;
                                <a href="login.jsp" target="_parent">登陆</a>&nbsp;&nbsp;
                            </c:when>
                            <c:otherwise>
                                <a href="zhuxiao.do" target="_parent">注销&nbsp;&nbsp;</a>
                            </c:otherwise>
                        </c:choose>
                        <a href="liuyan.do" target="right">留言&nbsp;&nbsp;</a>
                        <c:choose>
                            <c:when test="${user.type==1 }">
                                <a href="adminshouye.do?leftmessage=管理后台" target="_parent">后台管理</a>
                            </c:when>
                        </c:choose>
                    </span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td class="zz"><a href="goshouye.do" target="_parent">首页</a></td>
                <td class="zz">图书</td>
                <td class="zz">百货</td>
                <td class="zz">品牌</td>
                <td class="zz">促销</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
</div>
<div id="a2">
    <ul style="margin-left: 200px">
        <li>音乐<span>&nbsp;|</span></li>
        <li>影视<span>&nbsp;|</span></li>
        <li>少儿<span>&nbsp;|</span></li>
        <li>动漫<span>&nbsp;|</span></li>
        <li>小说<span>&nbsp;|</span></li>
        <li>外语<span>&nbsp;|</span></li>
        <li>数码相机&nbsp;<span>|</span></li>
        <li>笔记本&nbsp;<span>|</span></li>
        <li>Investor Relations</li>
    </ul>
</div>
<c:choose>
    <c:when test="${!empty leftmessage}">
        <span style="margin-left: 120px">您现在的位置:易买网&nbsp;>&nbsp;${leftmessage }</span>
    </c:when>
</c:choose>
</body>
</html>
