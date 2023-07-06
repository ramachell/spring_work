<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gs25/list.jsp</title>
<style>
#prod_box img {
	width: 165px;
	height: 165px;
}

li {
	list-style-type: none;
	float: left;
}

#prod_box{
	display: block;
	position: relative;
	width: 203px;
	height: 284px;
	border: 1px solid #e9e9e9;
	padding: 10px 10px 35px;
	box-shadow: none;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		
			<c:forEach var="tmp" items="${list }">
				
					<div class="col-3" id="prod_box">
						<img src="${tmp.img}" />
						<p class="mt-3">${tmp.name }</p>
						<p>${tmp.price }원</p>
					</div>
				
			</c:forEach>
		
	</div>
	
	<div>
		<nav>
			<ul class="pagination">
				<%--
					startPageNum 이 1 이 아닌 경우에만 Prev 링크를 제공한다. 
					&condition=${condition}&keyword=${encodedK}
				 --%>
				<c:if test="${startPageNum ne 1 }">
					<li class="page-item"><a class="page-link" href="list?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedK}">Prev</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<li class="page-item ${pageNum eq i ? 'active' : '' }"><a class="page-link" href="list?pageNum=${i }&condition=${condition}&keyword=${encodedK}">${i }</a></li>
				</c:forEach>
				<%--
					마지막 페이지 번호가 전체 페이지의 갯수보다 작으면 Next 링크를 제공한다. 
				 --%>
				<c:if test="${endPageNum lt totalPageCount }">
					<li class="page-item"><a class="page-link" href="list?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedK}">Next</a></li>
				</c:if>
			</ul>
		</nav>
		<!-- 검색 폼 -->
		<form action="list" method="get">
			<label for="condition">검색조건</label>
			<select name="condition" id="condition">
				<option value="name" ${condition eq 'name' ? 'selected' : '' }>제품이름</option>
			</select>
			<input type="text" name="keyword" placeholder="검색어..." value="${keyword }" />
			<button type="submit">검색</button>
		</form>
		<c:if test="${not empty condition }">
			<p>
				<strong>${totalRow }</strong> 개의 자료가 검색 되었습니다. <a href="list">리셋</a>
			</p>
		</c:if>
	</div>

</body>
</html>





