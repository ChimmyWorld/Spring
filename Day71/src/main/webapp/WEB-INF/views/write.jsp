<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
<form method="POST">
	<input name="title" placeholder="제목" required>
	<input name="writer" placeholder="작성자 " required>
	<input name="contents" placeholder="내용" required>

	<button>작성</button>
</form>
</body>
</html>