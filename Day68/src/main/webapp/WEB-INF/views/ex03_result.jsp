<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03_result.jsp</title>
</head>
<body>
	<h1>Service 결과</h1>
	<hr>
	
	<ul>
		<li>이름 : ${param.name }</li>
		<li>점수 : ${param.score }</li>
		<li>등급 : ${grade }</li>
	</ul>
</body>
</html>