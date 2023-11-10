<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table>
	<tr>
		<th>제목 | ${row.title }</th>
		<th>작성자 | ${row.writer }</th>
	</tr>
	<tr>
		<th>조회수 | ${row.view_count }</th>
		<th>작성일 | ${row.write_date }</th>
	</tr>
	<tr>
		<td>
		<pre>${row.contents }</pre>
		</td>
	</tr>
</table>

</body>
</html>