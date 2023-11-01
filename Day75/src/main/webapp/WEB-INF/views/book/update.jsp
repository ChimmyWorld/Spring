<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h1>수정</h1>

<form method="POST">
	<p><input name="title" value="${row.title }" required></p>
	<p><input name="writer" value="${row.writer }" required></p>
	<p><input name="publisher" value="${row.publisher }" required></p>
	<p><input name="p_date" value="${row.p_date }" required></p>
	<p><input name="price" value="${row.price }" required></p>
	
	<input name="idx" type="hidden" value="${row.idx }">
	<button>수정</button>
</form>
</body>
</html>