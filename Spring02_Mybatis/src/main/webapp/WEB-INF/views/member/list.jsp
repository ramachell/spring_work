<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<a href="${pageContext.request.contextPath}/member/insertform">회원 추가</a>
		<h1> member 목록입니다</h1>
		<table class="table">
        	<thead>
	            <tr>
	               <th>번호</th>
	               <th>이름</th>
	               <th>주소</th>
	               <th>수정</th>
	               <th>삭제</th>
	            </tr>
         	</thead>
         	<tbody>
	        	<c:forEach var="tmp" items="${list }">
              		<tr>
	                  	<td>${tmp.num }</td>
	                  	<td>${tmp.name }</td>
	                  	<td>${tmp.addr }</td>
	                  	<td><a href="${pageContext.request.contextPath}/member/updateform?num=${tmp.num }">수정</a></td>
	                  	<td><a href="${pageContext.request.contextPath}/member/delete?num=${tmp.num }">삭제</a></td>
	               </tr>
    	        </c:forEach>
         	</tbody>
      	</table>
	</div>
</body>
</html>