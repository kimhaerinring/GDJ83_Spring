<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
<div class="container">
	<div class="col-6 mx-auto">
		<form class="form-control" action="login" method="post">
			<label for="id" class="form-label">아이디</label>
			<input type="text"  value="${cookie.remember.value}" name="id" id="id" class="form-control">
			<label for="password" class="form-label">비밀번호</label>
			<input type="password" name="password" id="password" class="form-control">
			<div class="d-grid">
					<div class="mb-3 form-check">
							<input type="checkbox" name="remember" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">아이디기억하기</label>
						</div>
				<button class="btn btn-primary btn-block my-3">로그인</button>
			</div>
				<button type="reset" class="btn btn-warning">다시입력</button>
		</form>
	</div>
</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>