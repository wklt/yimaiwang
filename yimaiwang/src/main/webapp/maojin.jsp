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
            width: 700px;
            padding: 20px;
            float: left;
            border-top: 2px solid orange;
        }
        .d1{
            float: left;
            overflow: hidden;
            margin-right: 10px;
            padding-left: 20px;
            margin-top: 15px;
            text-align: center;
        }
        img{
            width: 130px;
            height: 130px;
        }
        hr{
            color: orange;
            width: 800px;
        }
    </style>
</head>
<body onload="showFood()">
<script type="text/javascript">
    function Food(path,desc,price){
        this.path=path;//图片
        this.desc=desc;//描述
        this.price=price;//价格
    }

    var food2=new Array();
    food2[0]=new Food("img/百草味1.png","果脯类","46.90");
    food2[1]=new Food("img/百草味2.png","坚果类","42.50");
    food2[2]=new Food("img/百草味3.png","饼干类","51.00");
    food2[3]=new Food("img/百草味4.png","糖果类","36.90");
    food2[4]=new Food("img/百草味5.png","蜜饯类","26.50");
    food2[5]=new Food("img/百草味6.png","干货类","38.50");
    food2[6]=new Food("img/百草味7.png","零食类","40.00");
    food2[7]=new Food("img/百草味8.png","糕点类","35.90");
    function showFood(){
        var h=document.getElementById("a3");
        h.innerHTML="";
        for(var i in food2){
            var n=document.createElement("div");
            var content="<div><img src='"+food2[i]['path']+"'/></div>";
            content+="<div>"+food2[i]['desc']+"</div>";
            content+="<div>￥"+food2[i]['price']+"</div>";
            n.innerHTML=content;
            n.className="d1";
            h.appendChild(n);
        }
    }
</script>


<div >
    <div id="a2">
        <img src="img/2.png" style="width: 15px; height:15px"><b>全部商品</b>
    </div>


    <div id="a3">

    </div>

</div>
</body>
</html>
