<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>
	<h4>Board 테이블 - REST</h4>
	
	<table class="board">
		<thead>
			<tr>
				<th>IDX</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	<p class="btns">
		<button>GET</button>
		<button>POST</button>
		<button>PUT</button>
		<button>PATCH</button>
		<button>DELETE</button>
	</p>
</section>

<script src="${cpath }/resources/js/board.js"></script>
</body>
</html>