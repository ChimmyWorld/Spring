<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section class="board">
	<table>
		<tr>
			<td>${row.idx }. ${row.title }</td>
		</tr>
		<tr>
			<td>${row.writer }. | ${row.view_count } | ${row.write_date }</td>
		</tr>
		<tr>
			<td><pre>${row.contents }</pre></td>
		</tr>
	</table>
</section>

<%@ include file="../footer.jsp" %>