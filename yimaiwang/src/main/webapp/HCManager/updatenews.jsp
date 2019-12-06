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
            float: right;
        }
        .a5{
            height: 40px;
        }
    </style>
</head>
<body >
<div >
    <div>
        <img src="img/2.png" style="width: 15px; height:15px"><b>修改新闻</b>
    </div>

    <div id="a3">
        <form action="updatenews2.do" method="post">
            <table cellspacing="0" cellpadding="0" style="width: 800px">
                <tr style="height: 30px;">
                    <td class="q2">新闻编号：</td>
                    <td><input type="text" name="id" value="${news.id}" style="height: 25px;width: 300px"/> </td>
                </tr>
                <tr style="height: 30px;">
                    <td class="q2">新闻标题：</td>
                    <td><input type="text" name="title" value="${news.title}" style="height: 25px;width: 300px"/> </td>
                </tr>

                <tr style="height: 30px;">
                    <td style="float: right;margin-top: 30px">新闻内容：</td>
                    <td><textarea rows="5" cols="39" name="content" style="margin-top: 10px"></textarea></td>
                </tr>
                <tr style="height: 40px;">
                    <td></td>
                    <td><input type="submit"  value="修改" style="background-color: darkblue;color: white"/> </td>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>
