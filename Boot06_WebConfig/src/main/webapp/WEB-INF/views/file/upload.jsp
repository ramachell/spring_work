<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>업로드 완</p>
	<p>${orgFileName } 저장 완료</p>
	<p>${fileSize }</p>
	<a href="download?orgFileName=${orgFileName }&saveFileName=${saveFileName}&fileSize=${fileSize}">다운로드</a>
</body>
</html>