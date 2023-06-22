<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<p>회원가입 완료됐습니다.</p>
	<ul>
		<li>insert 번호 : ${formNum }</li>
		<li>${param.name}</li>
		<li>${param.num}</li>
		<li>${param.addr}</li>
	</ul>
</body>
</html>