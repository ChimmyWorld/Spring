<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

	<main>
		<section class="board">
			<c:forEach var="row" items="${list }">
				<div>
					<a href="${cpath }/board/view/${row.idx }">
						<img src="${cpath }/img/${row.idx}/${row.img}" width="150px" height="100px"><br>
					</a>
					<hr>
					${row.title } (${row.writer })
					<hr>
					${row.view_count } ${row.write_date }
				</div>
			</c:forEach>
		</section>
		
		<a href="${cpath }/board/write">
			<button>작성</button>
		</a>
	</main>
</body>
</html>