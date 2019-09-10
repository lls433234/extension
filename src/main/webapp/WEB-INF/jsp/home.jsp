<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11/011
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>经销商客户管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="${pageContext.request.contextPath}/images/91logo.jpg" class="radius-circle rotate-hover" height="50" alt="" />重庆九幺用车经销商客户管理系统</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-red" href="index"><span class="icon-power-off"></span> 退出登录</a> </div>
    <span style="text-align:center;height: 30px;float: right;margin-top: 20px;font-size: 18px;color: #3c763d;margin-right: 30px">
        <img src="${pageContext.request.contextPath}/images/touxiang2.jpg" style="width: 45px">&nbsp;&nbsp;<span style="color: white;font-size: 20px">您好：${name}</span>
    </span>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>基本信息</h2>
    <ul id="ul1" style="display:block">
        <li><a href="addSalesman" target="right"><span class="icon-caret-right"></span>添加业务员</a></li>
        <li><a href="getAllSalesman" target="right"><span class="icon-caret-right"></span>业务员管理</a></li>
        <li><a href="getPublicUser" target="right"><span class="icon-caret-right"></span>业务员审核</a></li>
        <li><a href="getUserBySalesman" target="right"><span class="icon-caret-right"></span>业务员客户</a></li>
    </ul>

</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>

<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="" name="right" width="100%" height="100%"></iframe>
</div>

</body>
</html>
