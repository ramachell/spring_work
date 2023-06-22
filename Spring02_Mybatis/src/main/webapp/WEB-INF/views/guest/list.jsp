<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/guest/list.jsp</title>
<style>
	.container{
	fontsize : 30px;
	}

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<h1> 방명록입니다</h1>
		<div style="text-align : right;">
		<a href="${pageContext.request.contextPath}/guest/insertform">방명록 쓰기
		<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
  				<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
  				<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
			</svg> 
			<span class="visually-hidden">방명록 쓰기</span></a>
		</div>
		<table class="table">
        	<thead>
	            <tr>
	            	<th>글번호</th>
		            <th>작성자</th>
		            <th>내용</th>		            
		            <th>글 작성시간</th>
		            <th>수정</th>
	            	<th colspan="2">삭제</th>
	            	<th></th>
	            </tr>
         	</thead>
         	<tbody>
	        	<c:forEach var="tmp" items="${list }">
              		<tr>
	                  	<td>${tmp.num }</td>
	                  	<td>${tmp.writer }</td>
	                  	<td>${tmp.content }</td>
	                  	<td>${tmp.regdate }</td>
	                  	<td>
	                  		<a href="${pageContext.request.contextPath}/guest/updateform?num=${tmp.num }">
	                  			<svg xmlns="http://www.w3.org/2000/svg" width="29" height="29" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  									<path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
								</svg>
								<span class="visually-hidden">수정하기</span>
							</a>
						</td>
	                  	<td>
							<form action="delete" method="post">
								<input type="hidden" name="num" value="${tmp.num}" />
								<input type="password" name="pwd" id="pwd" class="form-control"/ placeholder="삭제시 비밀번호 입력"></input>
						</td>
						<td>
								<button type="submit" class="btn btn-warningh">삭제</button>
							</form>
						</td>
	               </tr>
    	        </c:forEach>
         	</tbody>
      	</table>
	</div>
</body>
</html>