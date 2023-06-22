<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/delete.jsp</title>
</head>
<body>
	<script>
		alert("${param.num} 번 회원의 정보가 삭제되었습니다")
		location.href="${pageContext.request.contextPath }/member/list";
	</script>
</body>
</html>