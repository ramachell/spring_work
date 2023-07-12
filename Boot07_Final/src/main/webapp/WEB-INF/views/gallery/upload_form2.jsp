<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/upload_form.jsp</title>
<style>
.dragImage {
	width: 400px;
	height: 400px;
	border: 2px dashed red;
	border-radius : 20px;
	display : flex;
	justify-content: center;
	align-items:center;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>사진 업로드</h1>
		<form action="${pageContext.request.contextPath}/gallery/upload" method="post" enctype="multipart/form-data">
			<div>
				<label for="caption">caption</label>
				<input type="text" name="caption" id="caption" />
			</div>
			<div class="dragImage">
				<label for="image">image</label>
				<input type="file" name="image" id="image" accept=".PNG, .jpeg, .jpg, .png, .JPG, .JPEG" />
			</div>
			<button type="submit">사진 업로드</button>
		</form>
		<br /> <img src="" alt="미리보기" id="preview" />
	</div>

	<script>
		const dZone= document.querySelector(".dragImage")
		dZone.addEventListener("dragover",(e)=>{
			e.preventDefault();
			document.querySelector(".dragImage").style.backgroundColor="green";			
		});
		
		dZone.addEventListener("drop",(e)=>{
			document.querySelector(".dragImage").style="transparent";
			e.preventDefault();
			const reader = new FileReader();
			
			reader.onload=(e2)=>{
				const data = e2.target.result;
				document.querySelector("#preview").setAttribute("src",data);
			}
			const uploadFile = e.dataTransfer.files[0]
			reader.readAsDataURL(uploadFile);
			
			document.querySelector("#image").files = e.dataTransfer.files;
			
		});
		
		document.querySelector("#image").addEventListener("change",(e)=>{
			// input에 넣은 파일 
			const files = e.target.files;
			// 파일이 있다면
			if(files.length > 0){
				// 파일로 데이터 읽을 객체
				const reader = new FileReader();
				// 업로드 완 됐을떄
				reader.onload=(e2)=>{
					const data = e2.target.result;
					
					document.querySelector("#preview").setAttribute("src",data);
		            
				};	
				// 파일을 DataURL 형식의 문자열로 읽기
				reader.readAsDataURL(files[0]);
			}
		})
	</script>
</body>
</html>