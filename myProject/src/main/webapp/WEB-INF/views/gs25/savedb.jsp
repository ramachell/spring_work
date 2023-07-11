<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gs25/savedb.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
p {
	display: block;
}

#prod_box img {
	width: 165px;
	height: 165px;
}

.img {
	background:
		url("${pageContext.request.contextPath}/resources/noimage.PNG") 50%
		50% no-repeat;
	height: 165px;
	width: 165px;
	margin: auto;
}

#prod_box {
	padding: 10px 10px 35px;
	display: block;
	position: relative;
	width: 203px;
	height: 324px;
	border: 1px solid #e9e9e9;
	padding: 10px 10px 35px;
	box-shadow: none;
}

#prod_boxes {
	width: 850px;
}
</style>
</head>
<body>
	<div class="container">
		<form id="searchForm" action="https://cors-anywhere.herokuapp.com/http://gs25.gsretail.com/gscvs/ko/products/event-goods-search?CSRFToken=c5465de1-aac8-4b3f-a9e6-dbbd76eb4857" method="get">
			<input type="text" hidden name="searchType" placeholder="searchType" />
			<input type="text" name="pageNum" placeholder="pageNum" />
			<input type="text" name="pageSize" placeholder="pageSize" value=999 />
			<input type="text" name="searchWord" placeholder="searchWord" />
			<input type="text" name="parameterList" placeholder="parameterList" value="ONE_TO_ONE" />
			<br>
			<button type="submit" id="viewBtn">목록 받아오기</button>
			<button type="submit" id="saveBtn">DB에 저장하기</button>
		</form>
		<br />
		<div id="goods">
			<div class='row' id='prod_boxes'>
			</div>
		</div>
	</div>
</body>


<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.0/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/gura_util.js"></script>
<script>

	document.querySelector("#viewBtn").addEventListener("click",(e)=>{
		e.preventDefault();
		$("#prod_boxes").text("");
		
		const form=document.querySelector("#searchForm");
		ajaxFormPromise(form)
		.then(res=>res.json())
		.then(data=>{
			const data2 = JSON.parse(data);
			for(let i = 0 ; i < data2.results.length ; i++ ){
				const rs = data2.results[i];
				console.log(rs);
				
				let tHtml = "";
				tHtml += "<div id='prod_box'>"
				tHtml += "<p class='img'>"
				tHtml += "<img src='" 
				tHtml += rs.attFileNm
				tHtml += "' alt="
				tHtml += rs.goodsNm
				tHtml += "/>"
				tHtml += "<p class='mt-3'>" 
				tHtml += rs.goodsNm
				tHtml += "</p> <p>"
				tHtml += rs.price
				tHtml += "원 </p><p>"
				tHtml += rs.eventTypeSp.code
				tHtml += "</p>"
				tHtml += "</div>"
				$("#prod_boxes").append(tHtml);
				
			}
		})
	})
		
	document.querySelector("#saveBtn").addEventListener("click",(e)=>{
		e.preventDefault();
		let isSave = confirm("저장 하시겠습니까?")
		if(isSave){
		const form=document.querySelector("#searchForm");
		ajaxFormPromise(form)
		.then(res=>res.json())
		.then(data=>{
			const data2 = JSON.parse(data);
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
			};
			alert("저장 했습니다")
		});
		};
	});
		
		
	
	</script>
</html>