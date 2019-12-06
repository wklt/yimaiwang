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
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/uploadPreview.js"></script>
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
        <img src="img/2.png" style="width: 15px; height:15px"><b>添加商品</b>
    </div>

    <div id="a3">
        <form action="addgoods2.do" method="post" enctype="multipart/form-data">
            <table cellspacing="0" cellpadding="0" style="width: 800px">
                <tr style="height: 30px;">
                    <td class="q2">商品名称：</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td class="q2">描述：</td>
                    <td><input type="text" name="description"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td class="q2">所属分类：</td>
                    <td>
                        <select name="categorylevel1id">
                            <c:forEach items="${epcategories }" var="epcategorie">
                                <option value="${epcategorie.id  }">${epcategorie.name }</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr style="height: 30px;">
                    <td class="q2">商品价格：</td>
                    <td><input type="text" name="price"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td class="q2">库存：</td>
                    <td><input type="text" name="stock"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td class="q2">商品图片：</td>
                    <td><input id="filename" type="file" name="filename"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><img id="imgupload" width="100px" height="100px"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="添加" style="background-color: green"
                               onclick="return confirm('确认新增这个商品么?')"/>
                        <input type="button" value="返回" onclick="history.back(-1)"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</div>
<script type="text/javascript">
    $(function () {
        function file_click() {
            new uploadPreview({UpBtn: "filename", ImgShow: "imgupload"});
        }
        window.onload = file_click;
    });
</script>
</body>
</html>
