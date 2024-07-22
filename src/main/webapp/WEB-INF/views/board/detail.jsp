<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/header_nav.jsp"></c:import>
	<!-- Page Header 사진 안에 글씨 넣는 곳-->
	<header class="masthead"
		style="background-image: url('/resources/assets/img/moomin5.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="site-heading">
						<h1>${dto.boardTitle}</h1>
						<span class="subheading">Notice</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content-->
	<main class="mb-4">
		<div class="container px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">글제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td scope="col">${dto.boardTitle}</td>
								<td scope="col">${dto.boardWriter}</td>
								<td scope="col">${dto.createDate}</td>
								<td scope="col">${dto.boardHit}</td>
							</tr>
						</tbody>
						<tr>
							<td scope="col" colspan="4">내용 : ${dto.boardContents}</td>
						</tr>

						<tr>
							<td><c:if test="${board eq 'Notice' }">
									<c:forEach items="${dto.fileDTOs}" var="f">
										<a href="/resources/upload/notice/${f.filename}">${f.oriname}
										</a>
									</c:forEach>
								</c:if> <c:if test="${board eq 'QnA' }">
									<c:forEach items="${dto.fileDTOs}" var="f">
										<a href="/resources/upload/qna/${f.filename}">${f.oriname}
										</a>
									</c:forEach>
								</c:if></td>
										</tr>
	</table>
				</div>
			</div>

			<div class="col-12 mb-3" align="right">
				<a href="./reply?boardNum=${dto.boardNum}"><button type="submit"
						class="btn btn-primary">답글달기</button></a> <a
					href="./update?boardNum=${dto.boardNum}"><button type="submit"
						class="btn btn-primary">수정하기</button></a> <a
					href="./delete?boardNum=${dto.boardNum}"><button type="submit"
						class="btn btn-primary">삭제하기</button></a>
			</div>
		</div>
	</main>


	<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>