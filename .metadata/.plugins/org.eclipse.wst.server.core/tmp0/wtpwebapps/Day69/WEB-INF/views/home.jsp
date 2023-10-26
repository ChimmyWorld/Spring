<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

	<table class="board">
		<tr>
			<th>IDX</th>
			<th>USERID</th>
			<th>NICK</th>
			<th>EMAIL</th>
			<th>JOIN_DATE</th>
			<th>수정</th>
			<th>삭제</th>	
		</tr>
	<c:forEach var="row" items="${list }">
		<tr>
			<td>${row.idx }</td>
			<td>
				<a href="${cpath }/acc/view?idx=${row.idx}">
				${row.userid }
				</a>
			</td>
			<td>${row.nick }</td>
			<td>${row.email }</td>
			<td>${row.join_date }</td>
			<td>
				<a href="${cpath }/acc/update?idx=${row.idx }">
					클릭
				</a>
			</td>
			<td>
				<a href="${cpath }/acc/delete?idx=${row.idx}">
					클릭
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>