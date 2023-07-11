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
		<c:choose>
			<c:when test="${empty sessionScope.id }">
				<a href="${pageContext.request.contextPath}/users/loginform">로그인</a>
				<a href="${pageContext.request.contextPath}/users/signup_form">회원가입</a>
			</c:when>
			<c:otherwise>
				<p>
					${id } 로그인중...
					<a href="${pageContext.request.contextPath}/users/logout">로그아웃</a>										
				</p>
			</c:otherwise>
		</c:choose>
		
		<h2><a href="gs25/list"> 1+1 보러가기</a></h2>
		<c:if test="${id eq 'admin' }">
			<h2><a href="gs25/savedb"> 관리자 page</a></h2>
		</c:if>
			
	</div>
</body>
</html>


