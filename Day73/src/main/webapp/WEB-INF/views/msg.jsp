<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

	<script>
		let row = ${row };
		alert('${message}');
		
		if (row != 0) {
			location.href= '${cpath}';
		}
		else {
			history.back();
		}
	</script>
</body>
</html>