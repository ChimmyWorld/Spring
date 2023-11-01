<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h1>책 추가</h1>
	<form method="POST">
		<p><input name="title" placeholder="제목" required>
		<p><input name="writer" placeholder="저자" required>
		<p><input name="publisher" placeholder="출판사" required>
		<p><input name="p_date" type="date" placeholder="출판일" required></p>
		<p><input name="price" type="number" placeholder="가격" required></p>
		
		<button>추가</button>
	</form>
</body>
</html>