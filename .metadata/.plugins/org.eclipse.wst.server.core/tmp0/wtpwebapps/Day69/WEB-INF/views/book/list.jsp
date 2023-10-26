<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<h1>책 리스트</h1>

	<table class="board">
		<tr>
			<th>책 번호</th>
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
					클릭
			</a></td>
			<td><a href="${cpath }/book/delete?idx=${row.idx }">
					클릭
			</a></td>
		</tr>
		</c:forEach>	
	</table>
	
	<p><a href="${cpath }/book/add">
		<button>추가</button>
	</a></p>
</body>
</html>