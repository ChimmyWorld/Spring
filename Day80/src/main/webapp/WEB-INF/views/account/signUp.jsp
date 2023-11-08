<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h1>회원가입</h1>
	
	<form method="POST">
		<p><input name="userid" placeholder="아이디"></p>
		<p><input name="userpw" type="password" placeholder="패스워드"></p>
		<p><input name="nick" placeholder="닉네임"></p>
		<p><input name="email" type="email" placeholder="이메일"></p>
		<button>회원가입</button>
	</form>	
</body>
</html>