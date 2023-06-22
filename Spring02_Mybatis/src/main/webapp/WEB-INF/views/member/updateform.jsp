<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/updateform.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="form-control">
		<form action="${pageContext.request.contextPath}/member/update" method="post">
			<div>
				<label for="num">회원 번호  :  </label>
				<input type="text" name="num" id="num" value=${dto.num } readonly />
			</div>
			<div>
				<label for="name">회원 이름  : </label>
				<input type="text" name="name" id="name" value=${dto.name } />
			</div>
			<div>
				<label for="addr">회원 주소 : </label>
				<input type="text" name="addr" id="addr" value=${dto.addr } />
			</div>
			<button type="submit">수정</button>
		</form>
	</div>
</body>
</html>