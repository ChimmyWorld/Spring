<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	<form method="POST">
		<p><input name="title" placeholder="제목" required></p>
		<p><input name="writer" placeholder="작성자" required></p>
		<p><textarea name="contents" required></textarea></p>
		
		<button>작성</button>
	</form>
</body>
</html>