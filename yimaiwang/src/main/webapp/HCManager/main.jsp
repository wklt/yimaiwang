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
</head>
<frameset rows="20%,70%,10%" frameborder="no">
    <frame src="HCManager/top.jsp" noresize="noresize" />
    <frameset cols="25%,75%" frameborder="no" >
        <frame src="HCManager/left.jsp" noresize="noresize" />
        <frame src ="HCManager/right.jsp" name="right" noresize="noresize" />
    </frameset>
    <frame src="HCManager/down.jsp" noresize="noresize" />
</frameset>
<body>

</body>
</html>
