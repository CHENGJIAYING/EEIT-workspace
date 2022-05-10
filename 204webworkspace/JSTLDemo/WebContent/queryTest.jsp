<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<sql:setDataSource var="ds" dataSource="jdbc/BakeYourLife" />
<%--<sql:query sql="select author, title from books" var="rs" dataSource="${ds}" />  --%>
<sql:query sql="SELECT userid,uname FROM users" var="rs" dataSource="${ds}" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Database Connection Pooling</title>
</head>
<body>
 <h2>Results</h2>
  <table border="1" >
    <th>userid</th>
    <th>uname</th> 
    <c:forEach var="row" items="${rs.rows}">
    <tr>
    <td>${row.userid}</td>
    <td>${row.uname}</td>
    </tr>
    </c:forEach>
  </table>
</body>
</html>