<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<section>
	<h1>아이디 찾기</h1>
	<hr>
	
	<form action="${cpath }/account/findId" method="POST">
		<h3>가입 당시 입력한 이메일을 입력하세요</h3>
		<p><input name="email" placeholder="이메일" required></p>
		
		<button>아이디 찾기</button>
	</form>
	
	<hr>
	
	<h1>비밀번호 찾기</h1>
	<hr>
	
	<form action="${cpath }/account/findPw" method="POST">
		<h3>가입 당시 입력한 아이디와 이메일을 입력하세요</h3>
		<p><input name="userid" placeholder="아이디" required></p>
		<p><input name="email" placeholder="이메일" required></p>
		
		<button>비밀번호 찾기</button>
	</form>	
</section>	
<%@ include file="../footer.jsp" %>