<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

	<h4>${ver }</h4>
	
	<table class="board">
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>출판일</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="row" items="${list }">
		<tr>
			<td>${row.idx }</td>
			<td>${row.title }</td>
			<td>${row.writer }</td>
			<td>${row.publisher }</td>
			<td>${row.p_date }</td>
			<td>${row.price }</td>
			<td><a href="${cpath }/book/update?idx=${row.idx }">
				수정
			</a></td>
			<td><a href="${cpath }/book/delete?idx=${row.idx }">
				삭제
			</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>