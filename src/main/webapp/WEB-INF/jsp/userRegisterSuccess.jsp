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
    <title>91用车APP注册</title>
</head>

<body class="logobg_style">
<div id="large-header" class="large-header login-page">
    <canvas id="demo-canvas" width="1590" height="711"></canvas>
    <div class="login-form">
        <div class="login-content">
            <img class="title_name" src="${pageContext.request.contextPath}/images/91.png" style="width: 100%;margin:0 auto; ">
            <c:if test="${msg.code=='10040'}">
<%--                <h3 style="color:white;">对不起：${msg.msg}</h3>--%>
<%--                <h4 style="color:white;">注册失败，请重新扫码注册</h4>--%>
                <div class="form-group clearfix">
                    <div class="input-group">
                        <p style="font-size: 25px;font-family: 黑体;color: white;font-weight: bold;margin-left: 30%;width: 300px">对不起：${msg.msg}</p>
                        <p style="font-size: 25px;font-family: 黑体;color: white;font-weight: bold;margin-left: 30%;width: 300px">请重新扫码注册</p>
                    </div>
                </div>
            </c:if>
            <c:if test="${msg.code=='10000'}">
<%--                <h3 style="color:white;">恭喜您：${msg.msg}</h3>--%>
<%--                <button id="bow" onclick="gettype()" style="margin-top: 10px">点击下载APP</button>--%>
                <div class="form-group clearfix">
                    <div class="input-group">
                        <p style="font-size: 25px;font-family: 黑体;color: white;font-weight: bold;margin-left: 30%;width: 300px">恭喜您：${msg.msg}</p>
                        <button id="bow" onclick="gettype()" style="margin-left: 50%">点击下载APP</button>
                    </div>
                </div>
            </c:if>
            <c:if test="${msg.code=='10050'}">
<%--                <h3 style="color:white;">对不起：${msg.msg}</h3>--%>
<%--                <h4 style="color:white;">注册失败，请重新扫码注册</h4>--%>
                <div class="form-group clearfix">
                    <div class="input-group">
                        <p style="font-size: 25px;font-family: 黑体;color: white;font-weight: bold;margin-left: 30%;width: 300px">对不起：${msg.msg}</p>
                        <p style="font-size: 25px;font-family: 黑体;color: white;font-weight: bold;margin-left: 30%;width: 300px">请重新扫码注册</p>
                    </div>
                </div>
            </c:if>
            <c:if test="${msg.code=='10001'}">
<%--                <h3 style="color:white;">对不起：${msg.msg}</h3>--%>
<%--                <h4 style="color:white;">注册失败，请重新扫码注册</h4>--%>
                <div class="form-group clearfix">
                    <div class="input-group">
                        <p style="font-size: 25px;font-family: 黑体;color: white;font-weight: bold;margin-left: 30%;width: 300px">对不起：${msg.msg}</p>
                        <p style="font-size: 25px;font-family: 黑体;color: white;font-weight: bold;margin-left: 30%;width: 300px">请重新扫码注册</p>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
</body>
<script type="text/javascript">
    var type = "未知";
    var browser = {
        versions: function () {
            var u = navigator.userAgent, app = navigator.appVersion;
            return {         //移动终端浏览器版本信息
                trident: u.indexOf('Trident') > -1, //IE内核
                presto: u.indexOf('Presto') > -1, //opera内核
                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
                mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或uc浏览器
                iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
                iPad: u.indexOf('iPad') > -1, //是否iPad
                webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
            };
        }(),
        language: (navigator.browserLanguage || navigator.language).toLowerCase()

    }

    //得到类型

    function gettype() {
        var iphone = browser.versions.iPhone;
        var android = browser.versions.android;
        if (iphone) {
            type = "iphone";
            location.href = "https://www.runoob.com/jsref/prop-nav-useragent.html";
        }
        if (android) {
            type = "android";
            location.href = "http://gw.masget.com:7086/t/rMv67v";
        }
    }
</script>

</html>
