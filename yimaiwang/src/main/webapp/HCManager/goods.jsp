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
            width: 100px;
        }
        img{
            width: 80px;
            height: 80px;
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
        <img src="img/2.png" style="width: 15px; height:15px"><b>商品管理</b>
    </div>

    <div id="a3">
        <table cellspacing="0" cellpadding="0" style="width: 800px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1">编号</th>
                <th class="q1" width="550px">商品名称</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr style="height: 20px;">
                    <td class="q1" style="text-align: center">${product.id }</td>
                    <td class="q1"><img src="upload/${product.filename }" class="img">${product.name }</td>
                    <td class="q2" style="text-align: center">
                        <a href="updategoods.do?id=${product.id }">修改</a>&nbsp;&nbsp;
                        <a href="delgoods.do?id=${product.id }" onclick="return confirm('确认删除?')">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="a4">
        <p>
            <span>共&ensp;${totalPage }&nbsp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页&ensp;&ensp;&ensp;&ensp;</span>

            <form name="form1" action="adtiaoye.do" method="post">
            <span>跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;&ensp;页&ensp;&ensp;
            <input type="submit" value="GO"/>
            </span>
            </form>
            <span style="float: right">
            <a href="adlastye.do">上一页</a>&ensp;&ensp;
            <a href="adnextye.do">下一页</a>&ensp;&ensp;
            <a href="adgofinal.do">最后一页</a></span>
        </p>
    </div>
</div>
</body>
</html>
