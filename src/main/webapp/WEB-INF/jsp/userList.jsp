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

			.pagination{
				list-style:none
			}

			.list{
				float:left;
				margin: 10px;
			}
		</style>
	</head>

	<body>
		<div class="am-cf admin-main" >
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="container" style="padding: 50px 10px 0px 10px">
						<form action="getUserByParam" method="post">
							<div class="am-g">
								<div class="am-u-sm-12 am-u-md-3">
									<div class="am-input-group am-input-group-sm">
										<span id="s1">推广码</span>&nbsp;&nbsp;<input class="input" type="text" name="salesmanId"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</div>
								<div class="am-u-sm-12 am-u-md-3">
									<div class="am-input-group am-input-group-sm">
										<span id="s2">电话号</span>&nbsp;&nbsp;<input class="input" type="text" name="userPhone" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</div>
								<div class="am-u-sm-12 am-u-md-3">
									<div class="am-input-group am-input-group-sm">
										<span id="s3">用户姓名</span>&nbsp;&nbsp;<input class="input" type="text" name="userName" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
													用户电话号码
												</th>
												<th>
													用户姓名
												</th>
												<th>
													业务员推广码
												</th>
												<th>
													业务员姓名
												</th>
												<th>
													创建时间
												</th>
												<th>
													操作
												</th>
											</tr>

										</thead>
										<tbody id="tUser">
										<c:forEach items="${allUserList}" var="user">
											<tr>
												<td>${user.userId}</td>
												<td>${user.userPhone}</td>
												<td>${user.userName}</td>
												<td>${user.salesmanId}</td>
												<td>${user.salesmanName}</td>
												<td>
													<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${user.createTime}" type="both"/>
												</td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs">
															<button type="button" class="am-btn am-btn-default" id="btnDle">
																<span class="icon-trash deleteUser"></span>
																<a href="deleteUser?userPhone=${user.userPhone}">删除</a>
															</button>
														</div>
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
				<nav>
					<ul class="pagination" style="margin-top:50px;margin-left: 600px">
						<li class="list"><a href="${pageContext.request.contextPath}/getUserByPublicUser?page=${sessionScope.pageSize - 1}" class="pri"><span>上一页</span></a></li>
						<c:forEach begin="1" end="${pageTotal}" varStatus="index">
							<li class="list" ${sessionScope.pageSize == index ? "class='active'":""}><a href="${pageContext.request.contextPath}/getUserByPublicUser?page=${index.index}">${index.index}</a></li>
						</c:forEach>
						<li class="list"><a href="${pageContext.request.contextPath}/getUserByPublicUser?page=${sessionScope.pageSize + 1}"><span>下一页</span></a></li>
					</ul>
				</nav>
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