<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/delete.jsp</title>
</head>
<body>
	<script>
		alert("${param.num} 번 글이 삭제되었습니다")
		location.href="${pageContext.request.contextPath }/guest/list";
	</script>
</body>
</html>