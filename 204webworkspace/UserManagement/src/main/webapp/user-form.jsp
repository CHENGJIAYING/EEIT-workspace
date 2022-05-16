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
			style="background-color: lightblue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> 會員管理系統 </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">會員資料</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			修改會員資料
            		</c:if>
						<c:if test="${user == null}">
            			新增會員
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="userid" value="<c:out value='${user.userid}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>姓名</label> <input type="text"
						value="<c:out value='${user.username}' />" class="form-control"
						name="username" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${user.useremail}' />" class="form-control"
						name="useremail">
				</fieldset>

				<fieldset class="form-group">
					<label>電話</label> <input type="text"
						value="<c:out value='${user.userphone}' />" class="form-control"
						name="userphone">
				</fieldset>
				<fieldset class="form-group">
					<label>生日</label> <input type="text"
						value="<c:out value='${user.userbirth}' />" class="form-control"
						name="userbirth" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>性別</label> <input type="text"
						value="<c:out value='${user.usergender}' />" class="form-control"
						name="usergender" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>住址</label> <input type="text"
						value="<c:out value='${user.useraddress}' />" class="form-control"
						name="useraddress" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">儲存</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>