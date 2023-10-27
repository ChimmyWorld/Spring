<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

	<table class="board">
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>추가</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="row" items="${list }">
		<tr>
			<td>${row.idx }</td>
			<td><a href="${cpath }/view?idx=${row.idx }">
			${row.title }
			</a></td>
			<td>${row.writer }</td>
			<td>${row.view_count }</td>
			<td>${row.write_date }</td>
			<td><a href="${cpath }/update?idx=${row.idx}">
				수정
			</a></td>
			<td><a href="${cpath }/delete?idx=${row.idx }">
				삭제
			</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<ul class="page">
		<c:forEach var="i" begin="1" end="10">
		<li><a href="${cpath }?page=${i }">${i }</a></li>
		</c:forEach>
	</ul>
	
</body>
</html>