<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section>
	<h1>로그인</h1>
	
	<form method="POST">
		<p><input name="userid" placeholder="아이디" required></p>
		<p><input name="userpw" type="password" placeholder="패스워드" required></p>
		
		<button>Login</button>	
		
		<a href="${cpath }/account/findId">
			<button type="button">아이디 찾기</button>
		</a>
		
		<a href="${cpath }/account/findPw">
			<button type="button">비밀번호 찾기</button>
		</a>
	</form>
</section>

<%@ include file="../footer.jsp" %>

