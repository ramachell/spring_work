<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gallery/upload.jsp</title>
</head>
<body>
	<script>
		alert("업로드 완");
		location.href = "${pageContext.request.contextPath}/gallery/list";
	</script>
</body>
</html>