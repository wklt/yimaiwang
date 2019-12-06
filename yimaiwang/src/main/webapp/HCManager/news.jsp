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
        #a4{
            font-size: 13px;
            height: 50px;
            float: left;
            width: 740px;
            margin-left: 50px;
        }
        span{
            float: left;
        }
    </style>
</head>
<body >
<div >
    <div>
        <img src="img/2.png" style="width: 15px; height:15px"><b>新闻管理</b>
    </div>

    <div id="a3">
        <table cellspacing="0" cellpadding="0" style="width: 800px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1">编号</th>
                <th class="q1">新闻标题</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${newsList}" var="news">
                <tr style="height: 20px;">
                    <td class="q1" style="text-align: center">${news.id}</td>
                    <td class="q1" style="margin-left: 10px">${news.title}</td>
                    <td class="q2" style="text-align: center;width: 130px">
                        <a href="updatenews.do?id=${news.id}" target="right">修改</a>
                        <a href="delnews.do?id=${news.id}" target="right" onclick="return confirm('是否确认删除?')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="a4">
        <p>
            <span>共&ensp;${totalPage }&nbsp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页&ensp;&ensp;&ensp;&ensp;</span>
            <span>
                <a href="xwlastye.do">上一页</a>&ensp;&ensp;
                <a href="xwnextye.do">下一页</a>&ensp;&ensp;
                <a href="xwgofinal.do">最后一页</a>
            </span>
            <form name="form1" action="xwtiaoye.do" method="post">
            <span style="float: right">跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;&ensp;页&ensp;&ensp;
            <input type="submit" value="GO"/>
            </span>
            </form>

        </p>
    </div>
</div>
</body>
</html>
