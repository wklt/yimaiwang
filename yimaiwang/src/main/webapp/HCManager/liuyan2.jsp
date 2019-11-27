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
        .q1{
            border-bottom: 1px solid gold;
            border-right: 1px solid gold;
            height: 30px;
        }
        .q2{
            border-bottom: 1px solid gold;
        }
        span{
            float: right;
            margin-top: 20px;
        }
    </style>
</head>
<body >
<div >
    <div>
        <img src="img/2.png" style="width: 15px; height:15px"><b>留言管理</b>
    </div>

    <div id="a3">
        <table cellspacing="0" cellpadding="0" style="width: 800px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1">编号</th>
                <th class="q1">姓名</th>
                <th class="q1">留言内容</th>
                <th class="q1">回复内容</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${commentList}" var="comment">
                <tr style="height: 20px;">
                    <td class="q1" style="text-align: center">${comment.ecId}</td>
                    <td class="q1" style="text-align: center">${comment.ecNickName}</td>
                    <td class="q1">${comment.ecContent}</td>
                    <td class="q1">${comment.ecReply}</td>
                    <td class="q2" style="text-align: center">
                        <a href="../updateliu.do">回复</a>
                        <a href="../delliu.do?id=${comment.ecId}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <span>分页</span>
    </div>

</div>
</body>
</html>
