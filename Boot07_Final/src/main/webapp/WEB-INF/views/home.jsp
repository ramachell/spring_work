<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
	<div class="container">
	<p><a href="${pageContext.request.contextPath}/users/info">${id }</a></p>
		<h1>인덱스 페이지 입니다.</h1>
		<img src="${pageContext.request.contextPath}/images/bottle.png" alt="" />
		<ul>
			<li><a href="${pageContext.request.contextPath}/jsp/hello.jsp">he</a></li>
		</ul>
		<h3>공지사항</h3>
		
		
		<ul>
			<c:forEach var="tmp" items="${list}">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>