<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/insertform.jsp</title>
<style>
#profileForm2 {
	display: none;
}

#profileLink img {
	width: 200px;
	height: 200px;
	border: 1px solid red;
	border-radius: 50%;
}
</style>
</head>
<body>
	<div class="container">
		<h3>파일 업로드 폼1</h3>
		<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
			제목
			<input type="text" name="title" />
			<br /> 첨부파일
			<input type="file" name="myFile" />
			<br />
			<button type="submit">업로드</button>
		</form>

		<h3>파일 업로드 폼2</h3>
		<form action="${pageContext.request.contextPath}/file/upload2" method="post" enctype="multipart/form-data">
			제목
			<input type="text" name="title" />
			<br /> 첨부파일
			<input type="file" name="myFile" />
			<br />
			<button type="submit">업로드</button>
		</form>

		<!-- 
			이미지를 선택해서 업로드 누르면 페이지 전환 없이 이미지 업로드 하고
			업로드된 파일의 정보를 응답(json) 받아서
			id 가 imageWrapper에 img 요소로 추가
			이미지 바로 보이게
			
			- webapp/resources/upload 폴더에 이미지 저장
			- gura_util.js 를 webapp/resource/js 폴더에 놓고 로딩해서
		-->

		<h3>이미지 업로드 폼</h3>
		<form action="${pageContext.request.contextPath}/image/upload" method="post" enctype="multipart/form-data" 
		id="profileForm">
			이미지
			<input type="file" name="image" accept=".jpg, .jpeg, .JPG, .JPEG, .gif, .png, .PNG" />
			<br />
			<button type="submit">업로드</button>
		</form>
		<br />
		<div id="imageWrapper"></div>
		
		<div>
			<a href="javascript:" id="profileLink">프로필</a>
		</div>

		<form action="${pageContext.request.contextPath }/image/upload" 
     	    method="post" enctype="multipart/form-data" id="profileForm2">
			이미지 
			<input id="file" type="file" name="image" accept=".jpg, .jpeg, .JPG, .JPEG, .gif, .png, .PNG">
 	    </form>


	</div>


	<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
	<script>
	
		// 프로필 클릭시 #file click() 
		document.querySelector("#profileLink").addEventListener("click", ()=>{
			document.querySelector("#file").click();
		});
		document.querySelector("#file").addEventListener("change", (e)=>{
			// 사진파일을 선택하고 확인 눌렀을때 change 가 되므로 그때 e가 실행됨
			// 실행됐을때 폼의 정보를 가져옴
			const form = document.querySelector("#profileForm2");
			
			//gura_util.js 안에 있는 함수를 활용하면 아래와 같다
			ajaxFormPromise(form)
			.then(res=>res.json())
			.then((data)=>{
				//data {"imagePath" : "resoruce/upload/파일이름"} 오브젝트다 
				console.log(data);
				const imgString=`<img src="${pageContext.request.contextPath}\${data.imagePath}">`;
				document.querySelector("#profileLink").innerHTML = imgString;
			});
			

		
			
		});
		
		
	
		
		//폼에 "submit" 이벤트가 일어 났을때 실행할 함수 등록
		document.querySelector("#profileForm").addEventListener("submit", (e)=>{
			//폼 전송 막기 
			e.preventDefault();
			//폼에 입력하거나 선택한 정보를 javascript 로 직접 전송하기
			//폼에 입력한 데이터를 FormData 에 담고 
			let data=new FormData(e.target); //e.target 은 form 의 참조값이다.
		

			//gura_util.js 안에 있는 함수를 활용하면 아래와 같다
			ajaxFormPromise(e.target)
			.then(res=>res.json())
			.then((data)=>{
				//data {"imagePath" : "resoruce/upload/파일이름"} 오브젝트다 
				console.log(data);
				const imgString=`<img src="${pageContext.request.contextPath}\${data.imagePath}">`;
				document.querySelector("#imageWrapper").innerHTML = imgString;
			});
		
		});
	</script>
</body>
</html>



