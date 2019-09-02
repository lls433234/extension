<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>91用车</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
userRegister.jsp
    <form action="userRegister" method="POST">
        身份证：<input type="text" name="userIdCard" id="userIdCard"><br>
        电话：<input type="text" name="userPhone" id="userPhone"><br>
        姓名：<input type="text" name="userName" id="userName"><br>
        密码：<input type="text" name="password" id="password"><br>
        推广码：<input type="text" name="salesmanId" id="salesmanId" value="${id}"><br>
        <button id="btn" type="submit" value="">提交</button>
    </form>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>


</body>


</html>