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
        #div1 {
            width: 200px;
            height: 920px;
            margin-left:130px ;
        }

        #div2 {
            width: 200px;
            height: 470px;
            float: right;
            border: 1px solid gray;
        }
        #div3 {
            width: 200px;
            height: 220px;
            float: right;
            border: 1px solid skyblue;
            margin-top: 50px;
        }
        dt{
            background-color:gainsboro;
            font-weight: bold;
        }
        dl{
            margin: 5px;
        }
        .line {
            background-color: orangered;
            color: #333;
            font-size: 14px;
            position: relative;
            line-height: 44px;
            cursor: pointer;
            border-right: 1px solid #dedede;
            width: 200px;
        }
        img {
            width: 15px;
            height: 15px;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>

<body>
<div id="div1">
    <div id="div2" >
        <div class="line">&nbsp;&nbsp;<b>商品分类</b></div>
        <c:forEach items="${map }" var="map">
            <dl>
                <dt>${map.value }</dt>
                <c:forEach items="${map.key }" var="mulu">
                    <dd><img src="img/left-dd.png"><a href="showproduct.do?id=${mulu.id }" target="right">${mulu.name }</a></dd>
                </c:forEach>
            </dl>
        </c:forEach>
    </div>
    <div id="div3">
        放浏览记录!
    </div>

</div>


<script type="text/javascript">
    $(function(){
        $("dd").hide();
        $("dl dt").click(function(){
            if($(this).parents("dl").children("dd").is(":hidden")){
                $(this).parents("dl").children("dd").show();
            }else{
                $(this).parents("dl").children("dd").hide();
            }
        });
    })
</script>
</body>
</html>
