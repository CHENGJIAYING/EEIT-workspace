<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head> 
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: lightgreen">
			<div>
				<a href="https://www.google.com" class="navbar-brand"> 會員管理系統 </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">會員資料</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">會員清單</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">新增會員</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>Email</th>
						<th>電話</th>
						<th>生日</th>
						<th>性別</th>
						<th>住址</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.userid}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.useremail}" /></td>
							<td><c:out value="${user.userphone}" /></td>
							<td><c:out value="${user.userbirth}" /></td>
							<td><c:out value="${user.usergender}" /></td>
							<td><c:out value="${user.useraddress}" /></td>
							<td><a href="edit?userid=<c:out value='${user.userid}' />">修改</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?userid=<c:out value='${user.userid}' />">刪除</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>