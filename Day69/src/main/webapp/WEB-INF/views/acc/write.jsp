<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
	<form method="POST">
		<p><input name="userid" placeholder="아이디" value="${acc.userid }" required></p>
		<p><input name="userpw" type="password" placeholder="패스워드" required></p>
		<p><input name="nick" placeholder="닉네임" value="${acc.nick }" required></p>
		<p><input name="email" type="email" placeholder="이메일" value="${acc.email }" required></p>
		
		<button>작성</button>
	</form>
</body>
</html>