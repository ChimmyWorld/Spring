<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
<form method="POST" enctype="multipart/form-data">
	<section>
			<table>
				<tr>
					<th>제목</th>
					<td><input name="title" placeholder="제목" value="${row.title }" required></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input name="writer" placeholder="작성자" value="${row.writer }" required></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="contents">${row.contents }</textarea></td>							
				</tr>
				<tr>
					<th>썸네일</th>
					<td><input name="upload" type="file" required></td>
				</tr>		
			</table>
			<button>작성</button>
	</section>
</form>
	
</body>
</html>