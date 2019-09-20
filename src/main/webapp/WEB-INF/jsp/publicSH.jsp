<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/9/11
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>绑定用户信息</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
    <style>
        .input{
            width: 180px;
            height: 30px;
            border: 0.5px solid #9d9d9d;
            border-radius: 4px;
        }
        .button{
            /*position: relative;*/
            position: absolute;
            float: left;
            right: 2px;
            width: 50px;
            height: 35px;
            font-size: 14px;
            color: white;
            background: #08bbe1;
            border: 0;
            border-radius: 4px;
        }
        .am-g span{
            font-family: "微软雅黑", Microsoft YaHei UI;
            font-weight: bold;
            font-size: 14px;
        }
    </style>
</head>

<body>
<div class="am-cf admin-main" >
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">

            <div class="container" style="padding: 50px 10px 0px 10px">
                <form action="getPublicByParam" method="post">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-2">
                            <div class="am-input-group am-input-group-sm">
                                <span id="s1">推广码</span>&nbsp;&nbsp;<input class="input" type="text" name="salesmanExtensionId"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-2">
                            <div class="am-input-group am-input-group-sm">
                                <span id="s2">电话号</span>&nbsp;&nbsp;<input class="input" type="text" name="phone" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <span id="s3">姓名</span>&nbsp;&nbsp;<input class="input" type="text" name="name" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>
                        </div>

                        <div class="am-u-sm-6 am-u-md-1">
                            <div class="am-input-group am-input-group-sm">
                                <%--									<button class="button">搜索</button>--%>
                                <input class="button" type="submit" value="搜索">
                            </div>
                        </div>
                    </div>
                </form>
                <hr style="height: 2px">
                <div class="am-g" style="margin-top: -30px;">
                    <div class="am-u-sm-12">
                        <form class="am-form" action="" style="font-family: '微软雅黑', Microsoft YaHei UI">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-title">
                                        用户编号
                                    </th>
                                    <th>
                                        姓名
                                    </th>
                                    <th>
                                        电话
                                    </th>
                                    <th>
                                        推广码
                                    </th>
                                    <th>
                                        审核状态
                                    </th>
                                    <th>
                                        创建时间
                                    </th>
                                    <th>
                                        操作(审核)
                                    </th>
                                </tr>

                                </thead>
                                <tbody id="tUser">
                                <c:forEach items="${allPublicUser}" var="publicUser">
                                    <tr>
                                        <td>${publicUser.id}</td>
                                        <td>${publicUser.name}</td>
                                        <td>${publicUser.phone}</td>
                                        <td>${publicUser.salesmanExtensionId}</td>
                                        <td>${publicUser.status}</td>
                                        <td>
                                            <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${publicUser.createTime}" type="both"/>
                                        </td>
                                        <td>
                                            <div class="am-btn-toolbar">
                                                <c:if test="${publicUser.status =='未审核'}">
                                                    <div class="am-btn-group am-btn-group-xs">
                                                        <button type="button" class="am-btn am-btn-default" id="btnYes1" style="background-color: #00aa00;border-radius: 10px;">
                                                            <span class="icon-trash deleteUser"></span>
                                                            <a style="color: white;font-size: 12px" href="examine?phone=${publicUser.phone}&status=2&name=${publicUser.name}">通过</a>
                                                        </button>
                                                        <button type="button" class="am-btn am-btn-default" id="btnNo1" style="background-color: red;border-radius: 10px;">
                                                            <span class="icon-trash deleteUser"></span>
                                                            <a style="color: white;font-size: 12px" href="examine?phone=${publicUser.phone}&status=1&name=${publicUser.name}">不通过</a>
                                                        </button>
                                                    </div>
                                                </c:if>

                                                <c:if test="${publicUser.status =='未通过'}">
                                                    <div class="am-btn-group am-btn-group-xs">
                                                        <button type="button" class="am-btn am-btn-default" id="btnYes2" style="background-color: #9d9d9d;border-radius: 10px;pointer-events: none;">
                                                            <span class="icon-trash deleteUser"></span>
                                                            <a style="color: white;font-size: 12px" href="">通过</a>
                                                        </button>
                                                        <button type="button" class="am-btn am-btn-default" id="btnNo2" style="background-color: #9d9d9d;border-radius: 10px;pointer-events: none;">
                                                            <span class="icon-trash deleteUser"></span>
                                                            <a style="color: white;font-size: 12px" href="">不通过</a>
                                                        </button>
                                                    </div>
                                                </c:if>

                                                <c:if test="${publicUser.status =='通过'}">
                                                    <div class="am-btn-group am-btn-group-xs">
                                                        <button type="button" class="am-btn am-btn-default" id="btnYes3" style="background-color: #9d9d9d;border-radius: 10px;pointer-events: none;">
                                                            <span class="icon-trash deleteUser"></span>
                                                            <a style="color: white;font-size: 12px" href="">通过</a>
                                                        </button>
                                                        <button type="button" class="am-btn am-btn-default" id="btnNo3" style="background-color: #9d9d9d;border-radius: 10px;pointer-events: none;">
                                                            <span class="icon-trash deleteUser"></span>
                                                            <a style="color: white;font-size: 12px" href="">不通过</a>
                                                        </button>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <!-- content end -->
    </div>
</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap/js/WdatePicker.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugs.js"></script>
<script>
    $(function() {
    });
</script>


</body>

</html>