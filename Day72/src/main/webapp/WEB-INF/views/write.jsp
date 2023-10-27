<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
<form method="POST">
	<table class="board">
		<tr>
			<th>제목 </th>
			<td><input name="title" placeholder="제목" required></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input name="writer" placeholder="작성자 " required></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input name="contents" placeholder="내용" required></td>
		</tr>
		
	</table>
	<button>작성</button>
</form>
</body>
</html>