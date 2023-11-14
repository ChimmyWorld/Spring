<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>



<section>
	<h4><marquee>fetch를 활용한 RestFul API 요청</marquee></h4>
	
	<table class="books">
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>출판일</th>
				<th>가격</th>
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

<script src="${cpath }/resources/js/ajax.js"></script>
</body>
</html>