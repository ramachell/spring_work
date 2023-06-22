<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>/guest/insertform.jsp</title>
</head>

<body>
	<div class="container" style="margin-top:150px;">
		<h1>방명록 작성하기</h1>
		<form action="${pageContext.request.contextPath}/guest/insert" method="post">
			<div class="mb-1">
				<label class="form-lable" for="writer">이름</label>
				<input class="form-control" type="text" name="writer" id="writer" placeholder="이름..." />
			</div>
			<div class="mb-1">
				<label for="content" class="form-lable">내용</label>
				<textarea name="content" id="content" cols="70" rows="1" class="form-control"></textarea>
			</div>
			<div class="col-1">
				<label for="pwd">비밀번호</label>
				<input type="password" name="pwd" id="pwd" class="form-control" placeholder="비밀번호.."/>
			</div>
			<div class="mt-3">
				<button type="submit" class="btn btn-success">방명록쓰기</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='${pageContext.request.contextPath}/guest/list' ">다시 방명록으로</button>
			</div>
		</form>
	</div>

</body>
</html>