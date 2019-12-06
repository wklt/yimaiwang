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
            height: 440px;
            border: 1px solid skyblue;
        }

        #div3 {
            width:740px;
        }

        #a3 {
            width: 740px;
            float: left;
            text-align: center;
            border-top: 2px solid orange;
            position: relative;
        }

        .q1 {
            border-bottom: 1px solid gold;
            border-right: 1px solid gold;
            height: 30px;
        }

        .q2 {
            border-bottom: 1px solid gold;
        }
        #a4{
            font-size: 13px;
            height: 50px;
            float: left;
            width: 650px;
            margin-left: 50px;
        }
        span{
            float: left;
        }
    </style>
</head>

<body>
<div id="div2">
    <div id="div3">
        <img src="img/2.png" style="width: 15px; height:15px"><b>全部订单</b>
    </div>
    <div id="a3">
        <table cellspacing="0" cellpadding="0" style="width: 740px">
            <tr style="background-color: #FFEB99;height: 20px;">
                <th class="q1">编号</th>
                <th class="q1">商品详情</th>
                <th class="q1">发货地址</th>
                <th class="q1" width="80px">状态</th>
            </tr>
            <c:forEach items="${eodetails }" var="eodetail">
                <tr style="height: 20px;">
                    <td class="q1" style="text-align: center">${eodetail.id }</td>
                    <td class="q1">${eodetail.details }<br></td>
                    <td class="q1">${eodetail.useraddress }</td>
                    <td class="q2" style="text-align: center">${eodetail.status }</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div id="a4">
        <p>
            <span>共&ensp;${totalPage }&ensp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页&ensp;&ensp;&ensp;&ensp;</span>
            <span>&ensp;
                <a href="myorderlastye.do">上一页</a>
                <a href="myordernextye.do">下一页</a>&ensp;
                <a href="myordergofinal.do">最后一页</a>
            </span>
            <form name="form1" action="myordertiaoye.do" method="post">
                <span style="float: right">跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;页&ensp;&ensp;&ensp;&ensp;
                <input type="submit" value="GO"/>
                </span>
            </form>
        </p>
    </div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
