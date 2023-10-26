<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또 추첨 결과</title>
</head>
<body>
	<h1>추첨 결과</h1>
	<hr>
	
	<ul>	
		<c:forEach var="lotto" items="${lottos }">
		<li>${lotto }</li>
		</c:forEach>
	</ul>
	
</body>
</html>