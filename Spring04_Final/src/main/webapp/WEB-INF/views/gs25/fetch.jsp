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
	<form id ="myF" action="https://cors-anywhere.herokuapp.com/http://gs25.gsretail.com/gscvs/ko/products/event-goods-search?CSRFToken=c5465de1-aac8-4b3f-a9e6-dbbd76eb4857" method="get" >
		<input type="text" name="pageNum" />	
		<input type="text" name="pageSize" />	
		<input type="text" name="searchType" />	
		<input type="text" name="searchWord" />	
		<input type="text" name="parameterList" />
		<button type="submit" id="sendBtn"> 전송</button>	
	</form>
	<ul id="goods">
	
	</ul>
</body>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/gura_util.js"></script>
	<script>
		document.querySelector("#sendBtn").addEventListener("click",(e)=>{
			e.preventDefault();
			const form=document.querySelector("#myF");
			ajaxFormPromise(form)
			.then(res=>res.json())
			.then(data=>{
				const data2 = JSON.parse(data);
				console.log(data2.results[0])
				for(let i = 0 ; i < data2.results.length ; i++ ){
					$("<li>").text("이름 : " + data2.results[i].goodsNm + " 가격 : " + data2.results[i].price).appendTo("#goods");
				}
				})
				
				
				
			})	
		
		
	
	</script>
</html>