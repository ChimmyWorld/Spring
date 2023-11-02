<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	<h3 class="debug"><marquee>디버그 페이지입니다. 배포시 꼭 제거!</marquee></h3>
	<hr>
	
	<table>
	<tr>
		<th>No</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>닉네임</th>
		<th>이메일</th>
		<th>가입일자</th>
	</tr>
	
	<c:forEach var="row" items="${list }">
	<tr>
		<td>${row.idx }</td>
		<td>${row.userid }</td>
		<td>${fn:substring(row.userpw, 0,6) }</td>
		<td>${row.nick }</td>
		<td>${row.email }</td>
		<td>${row.join_date }</td>
	</tr>
	</c:forEach>
	
</table>
</section>

<%@ include file="../footer.jsp" %>