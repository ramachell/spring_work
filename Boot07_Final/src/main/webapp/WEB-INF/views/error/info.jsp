<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/error/info</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Oops!</h1>
		<p class="alert alert-danger">
			<%--
				예외 컨트롤러 에서
				mView 에 예외 객체 키값 exception 으로 담았기때문에 예외 메시지 출력가능 
				${exception.message} ( ${exception.getMessage()}와 같음)
				 로 출력가능
			
			 --%>
			 <strong>${exception.message }</strong>
			 <a href="${pageContext.request.contextPath}/">인덱스로</a>
		</p>
	</div>
</body>
</html>