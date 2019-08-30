
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11/011
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户信息</strong></div>
</div>
<table class="table table-hover text-center">
        <tr>
            <th width="15%">编号</th>
            <th width="15%">姓名</th>
            <th width="15%">年龄</th>
            <th width="15%">地址</th>
            <th width="15%">身份证</th>
            <th width="15%">创建时间</th>
            <th width="15%">操作</th>
        </tr>

        <c:forEach items="${all}" var="userInfo">
            <tr>
                <td align="center">${userInfo.id}</td>
                <td>${userInfo.name}</td>
                <td>${userInfo.age}</td>
                <td>${userInfo.address}</td>
                <td>${userInfo.idCard}</td>
                <td>
                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${userInfo.createTime}" type="both"/>
                </td>
                <td><a href="delete?id=${userInfo.id}">
                    <img src="images/delete.png" alt="">删除</a></td>
            </tr>

        </c:forEach>

    </table>
</div>
<nav>
    <ul class="pagination" style="margin-top:5px;margin-left: 520px">
        <li><a href="${pageContext.request.contextPath}/PageClientServlet?page=${requestScope.pageSize - 1}"><span>&laquo;</span></a></li>
        <c:forEach begin="1" end="${requestScope.pageTotal}" varStatus="index">
            <li ${requestScope.pageSize == index.index ? "class='active'":""}><a href="${pageContext.request.contextPath}/PageClientServlet?page=${index.index}">${index.index}</a></li>
        </c:forEach>
        <li><a href="${pageContext.request.contextPath}/PageClientServlet?page=${requestScope.pageSize + 1}"><span>&raquo;</span></a></li>
    </ul>
</nav>

<%--<nav aria-label="Page navigation">--%>
<%--    <ul class="pagination">--%>
<%--        <li>--%>
<%--            <a href="#" aria-label="Previous">--%>
<%--                <span aria-hidden="true">&laquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--        <li><a href="#">1</a></li>--%>
<%--        <li><a href="#">2</a></li>--%>
<%--        <li><a href="#">3</a></li>--%>
<%--        <li><a href="#">4</a></li>--%>
<%--        <li><a href="#">5</a></li>--%>
<%--        <li>--%>
<%--            <a href="#" aria-label="Next">--%>
<%--                <span aria-hidden="true">&raquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
<%--    </ul>--%>
<%--</nav>--%>
<script rel="stylesheet" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>
