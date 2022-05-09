<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="db" class="com.usermanagement.bean.User" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>測試連線</title>
</head>
<body>
	<c:choose>
		<c:when test="${db.connectedOK}"> 連線成功!</c:when>
		<c:otherwise>失敗</c:otherwise>
	</c:choose>
</body>
</html>