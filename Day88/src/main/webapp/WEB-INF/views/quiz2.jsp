<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>
	<h4>ID/Nick 중복 확인</h4>
	
	<form>
		<p><input name="userid" placeholder="아이디" required></p>
		<p><input name="userpw" type="password" placeholder="패스워드" required></p>
		<p><input name="nick" placeholder="닉네임" required></p>
		<p><input name="email" type="email" placeholder="이메일" required></p>
		
		<button>가입</button>
	</form>
	
	<script> 
		let url = 'account';
		let userid = document.getElementsByName("userid")[0];
		let nick = document.getElementsByName("nick")[0];
		
		userid.onblur = () => {
			// alert('작성된 id = ' + userid.value);
			
			let data = {
					'userid': userid.value 
			};
			
			fetch(url, {
				method: 'POST',
				headers: { 'Content-Type' : 'application/json' },
				body: JSON.stringify(data)
			})
			.then(response => response.json())
			.then(data => {
				if (data == 1){
					alert('이미 존재하는 계정입니다')
					userid.value= '';
					userid.focus();
				}
			});
		}
		
		nick.onblur = () => {
			let data = { 
					'nick' : nick.value	
			};
			
			fetch(url + '/nick', {
				method: 'POST',
				headers: { 'Content-Type' : 'application/json' },
				body: JSON.stringify(data)
			})
			.then(response => response.json())
			.then(data => {
				if (data == 1){
					alert('이미 존재하는 닉네임입니다')
					nick.value = '';
					nick.focus();
				}
			});
		}
	</script>
</section>

</body>
</html>