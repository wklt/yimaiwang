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
    <script type="text/javascript" src="js/uploadPreview.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <style type="text/css">
        #a3{
            width: 700px;
            padding: 20px;
            float: left;
            border-top: 2px solid orange;
        }
        .d1{
            width: 130px;
            height: 180px;
            float: left;
            overflow: hidden;
            margin-left: 30px;
            margin-top: 15px;
            text-align: center;
            font-size: 15px;
        }
        img{
            width: 130px;
            height: 130px;
        }
        #a4{
            font-size: 13px;
            height: 50px;
            float: left;
            width: 700px;
        }
        span{
            float: left;
        }
        #ig1 {
            position: absolute;
            width: 250px;
            height: 220px;
            display: none;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div >
    <div id="a2">
        <img src="img/2.png" style="width: 15px; height:15px"><b>商品列表</b>
    </div>

    <div id="a3">
        <img id="ig1"/>
        <c:forEach items="${sproducts }" var="sproduct">
            <div class="d1">
                <a href="details.do?id=${sproduct.id }"><img name="ig" src="upload/${sproduct.filename }"
                                                             class="img">
                        ${sproduct.name }<br>
                        ${sproduct.price }</a>
            </div>
        </c:forEach>
    </div>
    <div id="a4">
        <p>
            <span>共&ensp;${totalPage }&nbsp;条记录&ensp;&ensp;&ensp;&ensp;&ensp;${ye }/${zonye }页&ensp;&ensp;&ensp;&ensp;</span>

        <form name="form1" action="sptiaoye.do" method="post">
            <span>跳转至&ensp;&ensp;<input type="text" name="ye"/>&ensp;&ensp;页&ensp;&ensp;
            <input type="submit" value="GO"/>
            </span>
        </form>
        <span style="float: right">
            <a href="splastye.do">上一页</a>&ensp;&ensp;
            <a href="spnextye.do">下一页</a>&ensp;&ensp;
            <a href="spgofinal.do">最后一页</a></span>
        </p>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        var x = 160, y = 40;
        $("img[name]").mouseover(function (e) {
            $("#ig1").attr("src", this.src).css({"top": (e.pageY + y) + "px", "left": (e.pageX = x) + "px"}).show();
        });
        $("img[name]").mouseout(function () {
            $("#ig1").hide();
        });
    });
</script>
</body>
</html>
