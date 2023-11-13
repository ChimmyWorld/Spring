<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${cpath }</title>
<style>
.board {
	display: flex;
	width: 950px;
	flex-wrap: wrap;
	justify-content: center;
	background: linear-gradient(45deg, #b7e3e4, #f9f7e8);
}

.board>div {
	margin: 10px 15px;
	border: 1px solid #aaaaaa;
	padding: 10px;
}
</style>
</head>
<body>
	<h1>이미지 게시판</h1>
	
