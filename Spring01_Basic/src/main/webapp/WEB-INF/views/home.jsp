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
		<h1>인덱스 페이지 입니다.</h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/member/insertform">요청파라미터 추출 테스트</a></li>
			<li><a href="${pageContext.request.contextPath}/fortune">운세보기1</a></li>
			<li><a href="${pageContext.request.contextPath}/fortune2">운세보기2</a></li>
			<li><a href="${pageContext.request.contextPath}/fortune3">운세보기3</a></li>
			<li><a href="${pageContext.request.contextPath}/member/delete?num=1">작업후 리다일렉트 응답 1</a></li>
			<li><a href="${pageContext.request.contextPath}/member/delete?num=2">작업후 리다일렉트 응답 2</a></li>
			<li><a href="${pageContext.request.contextPath}/test/json1">json1</a></li>
			<li><a href="${pageContext.request.contextPath}/test/json2">json2</a></li>
			<li><a href="${pageContext.request.contextPath}/test/json3">json3</a></li>
			<li><a href="${pageContext.request.contextPath}/test/json4">json4</a></li>
			<li><a href="${pageContext.request.contextPath}/test/json5">json5</a></li>
			<li><a href="test/json6">json6</a></li>
		
		</ul>
		
		<h3>공지사항</h3>
		<ul>
			<c:forEach var="tmp" items="${noticeList }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>


