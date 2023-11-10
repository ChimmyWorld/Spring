<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<form method="POST">
		<p><input name="title" placeholder="제목" value="${row.title }" required></p>
		<p><input name="contents" placeholder="내용" value="${row.contents }" required></p>
		<p><input name="writer" placeholder="작성자" value="${row.writer }" required></p>
		<p><input name="img" type="file" value="${row.img }" required></p>
		
		<button>작성</button>
	</form>

</body>
</html>