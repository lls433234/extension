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
    <title>客户注册</title>
</head>

<body class="logobg_style">
<div id="large-header" class="large-header login-page">
    <canvas id="demo-canvas" width="1590" height="711"></canvas>
    <div class="login-form">
        <div class="login-content">
<%--            <h1 class="title_name">91用车用户注册</h1>--%>
            <img class="title_name" src="${pageContext.request.contextPath}/images/91.png" style="margin:0 auto;height: 150px ">
            <form action="publicUserRegister" method="post" role="form" id="form_login" class="login_padding">

                <div class="form-group clearfix">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="icon_user"></i>
                        </div>
                        <input type="text" class="form-control" name="name" id="name" placeholder="请输入姓名"
                               autocomplete="off">
                    </div>
                </div>

                <div class="form-group clearfix">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="icon_user"></i>
                        </div>
                        <input type="text" class="form-control" name="phone" id="phone" placeholder="请输入手机号"
                               autocomplete="off">
                    </div>

                    <p class="text" style ="display:none;color: red;">请输入正确格式的电话号码</p>
                </div>

                <div class="form-group clearfix">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="icon_user"></i>
                        </div>
                        <input type="text" class="form-control" name="password" id="password" placeholder="请输入密码"
                               autocomplete="off">
                    </div>
                </div>

                <button id="aaa" class="btn btn-danger btn-block btn-login" onClick="cliLogin()"><i class="fa fa-sign-in">注册</i></button>
                <h5 style="color: red">${msg.msg}</h5>
            </form>
        </div>

    </div>
</div>

<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>

<script>

    $(function () {
        //登录操作
        let phone =/[1][3-9][0-9]{9,9}/;
        $("#aaa").click(function () {
           let inputDom = document.getElementById("phone");
           let aa = inputDom.value
           if(!phone.exec(aa)){
               $('.text').css('display', 'block');
               return  false;
           }
       })
    });

</script>
</body>
</html>
