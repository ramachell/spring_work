<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/home.jsp</title>
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지 입니다.</h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/member/list">회원 목록 보기</a></li>
			<li><a href="${pageContext.request.contextPath}/guest/list">게시판 보기</a></li>
		</ul>
		<form action="${pageContext.request.contextPath}/member/onemember" method="get">
			<label for="num">회원 번호 : </label>
			<input type="text" name="num" id="num" />
			<button type="submit">보기</button>
		</form>
		<img src="${pageContext.request.contextPath}/resources/images/kim1.png" />
		<h2>공지사항</h2>
		<ul>
			<c:forEach var="tmp" items="${noticeList }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>


