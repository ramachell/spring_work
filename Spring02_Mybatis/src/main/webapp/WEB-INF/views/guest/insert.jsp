<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/insert.jsp</title>
</head>
<body>
	<script>
		alert("${param.writer} 님이 쓴 방명록을 추가했습니다.")
		location.href="${pageContext.request.contextPath }/guest/list";
	</script>
</body>
</html>