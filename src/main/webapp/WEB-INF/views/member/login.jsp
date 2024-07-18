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

        <header class="masthead" style="background-image: url('/resources/assets/img/moomin3.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>로그인</h1>
                            <span class="subheading">LogIn</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

<div class="container mb-3">
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
				<button class="btn btn-success btn-block my-3">로그인</button>
			</div>
		</form>
	</div>
</div>

        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>