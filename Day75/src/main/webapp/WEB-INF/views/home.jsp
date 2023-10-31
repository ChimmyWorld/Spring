<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h1>Test 실습</h1>
	<hr>
	
	<ol>
		<li>/로 요청시 처리할 Controller를 작성</li>
		<li>View는 home.jsp를 사용</li>
		<li>home.jsp에서는 로또번호 한 세트를 출력</li>
		<li>로또 번호를 처리하는 부분은 LottoService 클래스를 작성해서 처리
	</ol>
	<hr>
	
	<h1>로또 번호</h1>
	${lotto }
	<hr>
	
	<h1>버전</h1>
	${ver }
</body>
</html>