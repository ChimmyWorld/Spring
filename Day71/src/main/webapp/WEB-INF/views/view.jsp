<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

	<table>
		<tr>번호 : ${row.idx }</tr>
		<tr>제목: ${row.title }</tr>
		<tr>내용 : ${row.contents }</tr>
		<tr>작성자: ${row.writer }</tr>
		<tr>조회수 : ${row.view_count }</tr>
		<tr>작성일 : ${row.write_date }</tr>
	</table>
</body>
</html>