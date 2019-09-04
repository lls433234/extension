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
    <title>8D酒店后台管理中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="${pageContext.request.contextPath}/images/91logo.jpg" class="radius-circle rotate-hover" height="50" alt="" />8D酒店后台管理中心</h1>
    </div>
    <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 首页</a>  &nbsp;&nbsp;<a class="button button-little bg-red" href=""><span class="icon-power-off"></span> 退出登录</a> </div>
    <span style="text-align:center;height: 30px;float: right;margin-top: 20px;font-size: 18px;color: #3c763d;margin-right: 30px">
        <img src="${pageContext.request.contextPath}/images/" style="width: 20px">&nbsp;张三
    </span>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-pencil-square-o"></span>基本操作</h2>
    <ul id="ul2" style="display: block">
        <li><a href="" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
        <li><a href="" target="right"><span class="icon-caret-right"></span>客户管理</a></li>
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
