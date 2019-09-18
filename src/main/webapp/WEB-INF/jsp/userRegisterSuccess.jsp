<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/normalize.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootsnav.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
    <!--[if IE]>
    <script src="js/html5.js"></script><![endif]-->
    <title>用户注册</title>
</head>

<body class="logobg_style">
<div id="large-header" class="large-header login-page">
    <canvas id="demo-canvas" width="1590" height="611"></canvas>
    <div class="login-form">
        <div class="login-content">
            <%--            <h1 class="title_name">用户注册</h1>--%>
            <%--            <img class="title_name" src="${pageContext.request.contextPath}/images/91.png" style="margin:0 auto;height: 150px ">--%>
            <div class="login-content">
                <c:if test="${msg.code=='10040'}">
                    <h3 style="color:white;">对不起：${msg.msg}</h3>
                    <p></p>
                    <h4 style="color:white;">注册失败，请重新扫码注册</h4>
                </c:if>
                <c:if test="${msg.code=='10000'}">
                    <h3 style="color:white;">恭喜您：${msg.msg}</h3>
                    <h3>2秒后跳转下载！</h3>
                    <%
                        //3秒后跳转到
                        response.setHeader("refresh", "2;URL=http://www.baidu.com");
                    %>
                </c:if>
                <c:if test="${msg.code=='10050'}">
                    <h3 style="color:white;">对不起：${msg.msg}</h3>
                    <p></p>
                    <h4 style="color:white;">注册失败，请重新扫码注册</h4>
                </c:if>
                <c:if test="${msg.code=='10001'}">
                    <h3 style="color:white;">对不起：${msg.msg}</h3>
                    <p></p>
                    <h4 style="color:white;">注册失败，请重新扫码注册</h4>
                </c:if>
            </div>
        </div>

    </div>
</div>

<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
</body>
</html>
