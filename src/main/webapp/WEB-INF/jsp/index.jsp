<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>登录</title>
</head>

<body class="logobg_style">
<div id="large-header" class="large-header login-page">
    <canvas id="demo-canvas" width="1590" height="711"></canvas>
    <div class="login-form">
        <div class="login-content">
            <h1 class="title_name">账户登录</h1>
            <form action="login" method="post" role="form" id="form_login" class="login_padding">
                <div class="form-group clearfix">

                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="icon_user"></i>
                        </div>

                        <input type="text" class="form-control" name="salesmanName" id="username" placeholder="请输入手机号"
                               autocomplete="off">
                    </div>

                </div>

                <div class="form-group clearfix">

                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="icon_password"></i>
                        </div>

                        <input type="password" class="form-control" name="salesmanPassword" id="password" placeholder="请输入密码"
                               autocomplete="off">
                    </div>

                </div>
<%--                <div class=" textright"><a href="#" class="forget">忘记密码？</a></div>--%>
                <div class="tishi"></div>
                <div class="form-group">
                    <button class="btn btn-danger btn-block btn-login"><i class="fa fa-sign-in">登录</i></button>
                </div>
<%--                <div class=" textright"><a href="salesmanRegister" class="forget">立即注册</a></div>--%>
                <!-- Implemented in v1.1.4 -->
                <div class="form-group">

                </div>
            </form>
        </div>

    </div>
</div>

<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
</body>
</html>
