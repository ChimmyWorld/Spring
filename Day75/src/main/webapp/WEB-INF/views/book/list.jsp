<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h1>책 리스트</h1>
		<table>
			<tr>
				<td>일련번호</td>
				<td>제목</td>
				<td>저자</td>
				<td>출판사</td>
				<td>출판일</td>
				<td>가격</td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
			<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td>${row.title }</td>
				<td>${row.writer }</td>
				<td>${row.publisher }</td>
				<td>${row.p_date }</td>
				<td>${row.price }</td>
				<td><a href="${cpath }/book/update?idx=${row.idx }">수정</a></td>
				<td><a href="${cpath }/book/delete?idx=${row.idx }">삭제</a></td>
			</tr>
			</c:forEach>	
		</table>
		
		<form method="POST">
			<select name="type">
				<option value="title">제목</option>
				<option value="writer">저자</option>
				<option value="publisher">출판사</option>
			</select>
			
			<input name="search" value=${param.search } >
			
			<button>검색</button>
		</form>
</body>
</html>