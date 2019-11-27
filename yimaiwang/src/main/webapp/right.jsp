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

        #div1{
            width: 300px;
            height:440px;
            border: 1px solid skyblue;
        }
        ul li{
            list-style: none;
            line-height: 30px;
        }
        .a1{
            border: 1px solid gray;
            height: 40px;
            width: 300px;
            background-color: #dedede;
        }
        img{
            width: 15px;
            height: 15px;
        }
        .a2{
            margin-left: -20px;
        }
    </style>
</head>

<body>

    <div id="div1">
        <div class="a1">
            <b>新闻动态</b>
        </div>
        <div class="a2">
            <ul>
                <li><img src="img/3.png">功翻山倒海法国恢复得更</li>
                <li><img src="img/3.png">规范地方会更好顺丰到付第三</li>
                <li><img src="img/3.png">俺三个地方管道施工方</li>
                <li><img src="img/3.png">施工方法大使馆单方事故讽德贾</li>
                <li><img src="img/3.png">功太化股</li>
                <li><img src="img/3.png">公司豆腐干豆腐事故事</li>
                <li><img src="img/3.png">施工法规收到广东分公司的股到</li>
                <li><img src="img/3.png">三个地方</li>
            </ul>
        </div>
    </div>



<script type="text/javascript">
</script>
</body>
</html>
