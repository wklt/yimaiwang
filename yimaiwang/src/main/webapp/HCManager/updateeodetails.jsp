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
        <form action="updateeodetails2.do" method="post">
            <table cellspacing="0" cellpadding="0" style="width: 800px">
                <tr style="height: 30px;">
                    <td class="q2">订单编号：</td>
                    <td><input type="text" name="id" readonly="readonly" value="${eodetail.id}"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td class="q2">订购人姓名：</td>
                    <td><input type="text" name="loginname" value="${eodetail.loginname}"/></td>
                </tr>

                <tr style="height: 30px;">
                    <td style="float: right;margin-top: 30px">订购人地址：</td>
                    <td><input type="text" name="useraddress" value="${eodetail.useraddress}"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td style="float: right;margin-top: 30px">总金额：</td>
                    <td><input type="text" name="cost" value="${eodetail.cost}"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td style="float: right;margin-top: 30px">下单日期：</td>
                    <td><input type="text" readonly="readonly" name="createtime" value="${eodetail.createtime}"/></td>
                </tr>
                <tr style="height: 30px;">
                    <td style="float: right;margin-top: 30px">订单状态：</td>
                    <td>
                        <select name="status">
                            <option value="${eodetail.status}">${eodetail.status}</option>
                            <option value="下单">下单</option>
                            <option value="审核通过">审核通过</option>
                            <option value="配货">配货</option>
                            <option value="送货中">送货中</option>
                            <option value="收获并确认">收获并确认</option>
                        </select>
                    </td>
                </tr>
                <tr style="height: 40px;">
                    <td></td>
                    <td><input type="submit" value="更新" style="background-color: green"
                               onclick="return confirm('确认修改么?')"/>
                        <input type="button" value="返回" onclick="history.back(-1)"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>
