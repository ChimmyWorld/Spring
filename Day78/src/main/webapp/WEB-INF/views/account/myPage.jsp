<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form action="update" method="POST">
	<section class="board half">
		<h1>마이페이지</h1>
		<hr>
	
			<table>
				<tr>
					<th>회원번호</th>
					<td>${user.idx }</td>
				<tr>
				<tr>
					<th>아이디</th>
					<td>${user.userid }</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input name="userpw" type="password" required></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td>${user.nick }</td>
				</tr>
				<tr>
					<th>이메일 </th>
					<td><input name="email" type="email" value="${user.email }" required></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${user.join_date }</td>
				</tr>
			</table>
			
			<input name="idx" type="hidden" value="${user.idx }"> 
		
		<button>수정</button>
		
		<br>
		
		<a href="${cpath }/account/delete?idx=${user.idx }">
			<button type="button">탈퇴</button>
			<!-- form 때문에 a 태그가 동작하지 않음을 방지하기 위해 type을 button으로 변경 -->
			<!-- 참고 : 버블링/캡처링 -->
		</a>
	</section>
</form>

<%@ include file="../footer.jsp" %>