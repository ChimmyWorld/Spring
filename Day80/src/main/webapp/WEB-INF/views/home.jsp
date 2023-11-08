<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
	<c:set var="list" value="${map['list'] }"/>
	<c:set var="p" value="${map['p'] }"/>
	
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach var="row" items="${list }">
		<tr>
			<td>${row.idx }</td>
			<td><a href="${cpath }/board/view/${row.idx }">
				${row.title }
			</a></td>
			<td>${row.writer }</td>
			<td>${row.view_count }</td>
			<td>${row.write_date }</td>
		</tr>
		</c:forEach>
	</table>
	
	<ul class="page">
		
		<li><a href="${cpath }/${p.begin - 1 }">&lt;</a></li>
	
		<c:forEach var="i" begin="${p.begin }" end="${p.end }">
		<li><a href="${cpath }/${i }">${i }</a></li>
		</c:forEach>
		
		<li><a href="${cpath }/${p.end + 1 }">&gt;</a></li>
	</ul>
	
	<a href="${cpath }/board/write">
		<button>글작성</button>
	</a>
	
	<a href="${cpath }/txTest">
		<button>tx 테스트</button>
	</a>

</body>
</html>