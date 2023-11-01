<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test 실습</h1>
	
	<ul>
		<li><a href="${cpath }">home</a></li>
		<li><a href="${cpath }/book/list">book</a></li> 
		<li><a href="${cpath }/book/add">add</a></li>
	</ul>

<hr>
</body>
</html>