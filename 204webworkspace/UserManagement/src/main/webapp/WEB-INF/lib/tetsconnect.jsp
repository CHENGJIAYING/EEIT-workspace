<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="db" class="com.usermanagement.dao.DatabaseBean" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>測試連線</title>
</head>
<body>
	<c:choose>
          <c:when test="${db.isConnectOK()}">連線成功</c:when>
           <c:otherwise>連線失敗</c:otherwise>
        </c:choose>
</body>
</html>