<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gs25/savedb.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
li {
	list-style-type: none;
	text-align: -webkit-match-parent;
	float: left;
}

#goodsImg {
	height: 165px;
	width: 165px;
	vertical-align: middle;
}

.prod {
	display: block;
	position: relative;
	width: 203px;
	height: 284px;
	border: 1px solid #e9e9e9;
	padding: 10px 10px 35px;
	box-shadow: none;
}
</style>
</head>
<body>
	<form id="searchForm" action="https://cors-anywhere.herokuapp.com/http://gs25.gsretail.com/gscvs/ko/products/event-goods-search?CSRFToken=c5465de1-aac8-4b3f-a9e6-dbbd76eb4857" method="get">
		<input type="text" name="searchType" placeholder="searchType" />
		<input type="text" name="pageNum" placeholder="pageNum" />
		<input type="text" name="pageSize" placeholder="pageSize" value=8 />
		<input type="text" name="searchWord" placeholder="searchWord" />
		<input type="text" name="parameterList" placeholder="parameterList" value="ONE_TO_ONE" />
		<button type="submit" id="sendBtn">전송</button>
	</form>
	<ul id="goods">
		<!-- 		<li><img src="https://image.woodongs.com/imgsvr/item/GD_8801062417438.jpg" alt="" /></li>	 -->
	</ul>
</body>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/gura_util.js"></script>
<script>
		document.querySelector("#sendBtn").addEventListener("click",(e)=>{
			e.preventDefault();
			
				const form=document.querySelector("#searchForm");
				ajaxFormPromise(form)
				.then(res=>res.json())
				.then(data=>{
					const data2 = JSON.parse(data);
					$("#goods").text("");
					for(let i = 0 ; i < data2.results.length ; i++ ){
						const rs = data2.results[i];
						// 폼만들기
						fetch("${pageContext.request.contextPath}/gs25/save", {
						    method: 'POST',
						    cache: 'no-cache',
						    body: new URLSearchParams({
						        name: rs.goodsNm,
						        img: rs.attFileNm,
						        type: rs.eventTypeSp.code,
						        price:rs.price
						    })
						})
						.then((response) => response.json())
						.then((data) => {
						    console.log(data);
						});
					
					
// 					let tHtml = "";
// 					tHtml += "<li>";
// 					tHtml += "<div class='prod col-3'>";
// 					tHtml += "<img id='goodsImg' src='"
// 					tHtml += rs.attFileNm
// 					tHtml += "'/>"
// 					tHtml += "<p> 이름 : " 
// 					tHtml += rs.goodsNm
// 					tHtml += " 가격 : "
// 					tHtml += rs.price
// 					tHtml += "</p></div></li>"
// 					$("#goods").append(tHtml);
					
					$("<li>").text(`이름 : \${data2.results[i].goodsNm} 가격 : \${data2.results[i].price}`).appendTo("#goods");
					}
				
					
					})
				})
		
		
	
	</script>
</html>