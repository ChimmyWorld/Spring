<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
<section class="board">
	<table>
		<tr>
			<td>${row.idx }. ${row. title }</td>
		</tr>
		<tr>
			<td>${row.writer} | ${row.view_count} | ${row.write_date }</td>
		</tr>
		<tr>
			<td><pre>${row.contents }</pre>
		</tr>
	</table>
	
	<form method="POST">
		<p><input name="writer" placeholder="닉네임 (필수)" required></p>
		<p><textarea name="contents" placeholder="바른말을 사용합시다" required></textarea></p>
		
		<button>전송</button>
	</form>
	
	<h5>댓글 | 총 ${reply }개</h5> 
	<hr>
	
	<table>
		<c:forEach var="re" items="${replys }">
			<tr>
				<td>
<pre>			
${re.writer } | ${re.write_date }			
${re.contents }
</pre>
				</td>
			<tr>
		</c:forEach>
	</table>	
</section>

</body>
</html>