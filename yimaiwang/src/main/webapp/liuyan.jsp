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
        #ta1{
            width: 740px;
            border-top: 2px solid orange;
            position: relative;
            border-bottom: 1px solid gray;
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
        #ta2{
            margin-left: 50px;
        }
        .a1{
            font-size: 13px;
        }
        .a2{
            font-size: 14px;
        }
    </style>
</head>
<body >
<div >
    <div id="a2">
        <img src="img/2.png" style="width: 15px; height:15px"><b>全部留言</b>

    </div>
        <table id="ta1">
            <c:forEach items="${commentList}" var="comment">
            <tr style="background-color: #dedede">
                <td>
                   <b>${comment.ecContent}</b>
                </td>
            </tr>
            <tr class="a1">
                <td>
                    网友：${comment.ecNickName} &nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${comment.ecCreateTime}" pattern="yyyy-MM-dd"/><br/>
                </td>
            </tr>
            <tr class="a2">
                <td>
                    管理员回复：${comment.ecReply}
                </td>
            </tr>
            </c:forEach>
        </table>
    <form action="addliu.do" method="post">
        <table id="ta2">
            <tr>
                <td style="float: right">昵称：</td>
                <td><input type="text" name="nicheng" style="width: 250px"/> </td>
            </tr>
            <tr>
                <td>留言内容：</td>
                <td><textarea rows="5" cols="32" id="opinion" name="neirong"></textarea></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="提交留言" style=" background-color: darkblue;color: white;"/> </td>
            </tr>
        </table>

    </form>


</div>
</body>

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
   /* $(
        function (){
            $("tr:odd").css("background","limegreen");
        }
    );*/
</script>
</html>
