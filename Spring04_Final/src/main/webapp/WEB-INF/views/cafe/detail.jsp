<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/detail.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="../">Home</a></li>
				<li class="breadcrumb-item"><a href="list">list</a></li>
				<li class="breadcrumb-item active">Home</li>
			</ol>
		</nav>

		<%-- 만일 이전글(더 옛날글)의 글번호가 0 가 아니라면(이전글이 존재 한다면) --%>
		<c:if test="${dto.prevNum ne 0}">
			<a href="detail?num=${dto.prevNum }&condition=${condition}&keyword=${encodedK}">이전글</a>
		</c:if>

		<%-- 만일 다음글(더 최신글)의 글번호가 0 가 아니라면(다음글이 존재 한다면) --%>
		<c:if test="${dto.nextNum ne 0 }">
			<a href="detail?num=${dto.nextNum }&condition=${condition}&keyword=${encodedK}">다음글</a>
		</c:if>

		<%-- 만일 검색 키워드가 있다면 --%>
		<c:if test="${not empty keyword }">
			<p>
				<strong>${condition }</strong> 조건 <strong>${keyword }</strong> 검색어로 검색된 내용 자세히 보기
			</p>
		</c:if>
		<h3>글 상세 보기</h3>
		<table class="table table-bordered">

			<tr>
				<th>글번호</th>
				<td>${dto.num }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.writer }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.viewCount }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.regdate }</td>
			</tr>
			<tr>
				<td colspan="2">
					<div>${dto.content }</div>
				</td>
			</tr>
		</table>
		<c:if test="${sessionScope.id eq dto.writer }">
			<a href="updateform?num=${dto.num }">수정</a>
			<a href="javascript:" onclick="deleteConfirm()">삭제</a>
			<script>
				function deleteConfirm() {
					const isDelete = confirm("이 글을 삭제 하겠습니까?");
					if (isDelete) {
						location.href = "delete?num=${dto.num}";
					}
				}
			</script>
		</c:if>
		<h4>댓글을 입력해 주세요</h4>
		<!-- 원글에 댓글을 작성할 폼 -->
		<form class="comment-form insert-form" action="comment_insert" method="post">
			<!-- 원글의 글번호가 댓글의 ref_group 번호가 된다. -->
			<input type="hidden" name="ref_group" value="${dto.num }" />
			<!-- 원글의 작성자가 댓글의 대상자가 된다. -->
			<input type="hidden" name="target_id" value="${dto.writer }" />

			<textarea name="content">${empty id ? '댓글 작성을 위해 로그인이 필요 합니다.' : '' }</textarea>
			<button type="submit">등록</button>
		</form>

		<!-- 댓글 목록 -->
		<div class="comments">
			<ul>
				<c:forEach var="tmp" items="${commentList }">
					<c:choose>
						<c:when test="${tmp.deleted eq 'yes' }">
							<li>삭제된 댓글 입니다.</li>
						</c:when>
						<c:otherwise>
							<c:if test="${tmp.num eq tmp.comment_group }">
								<li id="reli${tmp.num }">
							</c:if>
							<c:if test="${tmp.num ne tmp.comment_group }">
								<li id="reli${tmp.num }" style="padding-left: 50px;"><svg class="reply-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-right" viewBox="0 0 16 16">
			  							<path fill-rule="evenodd" d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z" />
									</svg>
							</c:if>
							<dl>
								<dt>
									<c:if test="${ empty tmp.profile }">
										<svg class="profile-image" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
												  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
												  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
												</svg>
									</c:if>
									<c:if test="${not empty tmp.profile }">
										<img class="profile-image" src="${pageContext.request.contextPath}${tmp.profile }" />
									</c:if>
									<span>${tmp.writer }</span>
									<c:if test="${tmp.num ne tmp.comment_group }">
												@<i>${tmp.target_id }</i>
									</c:if>
									<span>${tmp.regdate }</span> <a data-num="${tmp.num }" href="javascript:" class="reply-link">답글</a>
									<c:if test="${ (id ne null) and (tmp.writer eq id) }">
										<a data-num="${tmp.num }" class="update-link" href="javascript:">수정</a>
										<a data-num="${tmp.num }" class="delete-link" href="javascript:">삭제</a>
									</c:if>
								</dt>
								<dd>
									<pre id="pre${tmp.num }">${tmp.content }</pre>
								</dd>
							</dl>
							<form id="reForm${tmp.num }" class="animate__animated comment-form re-insert-form" action="comment_insert" method="post">
								<input type="hidden" name="ref_group" value="${dto.num }" />
								<input type="hidden" name="target_id" value="${tmp.writer }" />
								<input type="hidden" name="comment_group" value="${tmp.comment_group }" />
								<textarea name="content"></textarea>
								<button type="submit">등록</button>
							</form>
							<c:if test="${tmp.writer eq id }">
								<form id="updateForm${tmp.num }" class="comment-form update-form" action="comment_update" method="post">
									<input type="hidden" name="num" value="${tmp.num }" />
									<textarea name="content">${tmp.content }</textarea>
									<button type="submit">수정</button>
								</form>
							</c:if>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
		<div class="loader">
			<svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 16">
				  <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z" />
				  <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z" />
			</svg>
		</div>

	</div>
</body>
</html>













