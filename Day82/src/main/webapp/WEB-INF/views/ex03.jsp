<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
	<h4>파일 목록</h4>

	<table>
		<tr>
			<th>IDX</th>
			<th>이름</th>
			<th>경로</th>
			<th>업로더</th>
			<th>메모</th>
			<th>업로드 일자</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
			<c:forEach var="row" items="${list }">
		<tr>
			<td>${row.idx }</td>
			<td>
				<a href="${cpath }/files/${row.name}" download>
				${row.name }
				</a>
			</td>
			<td>${row.path }</td>
			<td>${row.uploader }</td>
			<td>${row.memo }</td>
			<td>${row.upload_date }</td>
			<td>
				<a href="${cpath }/update/${row.idx}">
					클릭
				</a>
			</td>
			<td><a href="${cpath }/delete/${row.idx}?name=${row.name }">
				클릭
			</a></td>
		</tr>
		</c:forEach>		
	</table>
	
	<hr>
	<h4>업로드</h4>
	
	<form method="POST" enctype="multipart/form-data">
		<p><input name="uploader" placeholder="업로더"></p>
		<p><input name="memo" placeholder="메모"></p>
		<p><input name="upload" type="file" required></p>
		<button>전송</button>
	</form>
	
</body>
</html>