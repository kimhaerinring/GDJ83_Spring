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
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin3.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>${dto.ac_name}</h1>
                            <h1>상품 수정</h1>
                            <span class="subheading">Product</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

<div class="container">
	<form action="/product/update" method="post">
	<input type="hidden" name = "p_code" value="${dto.p_code}">
	<div>
	<div class="mb-3">
	  <label for="formGroupExampleInput" class="form-label">상품명</label>
	  <input type="text" class="form-control" id="formGroupExampleInput" name = "ac_name" value="${dto.ac_name}" >
	</div>
	<div class="mb-3">
	  <label for="formGroupExampleInput" class="form-label">상품설명</label>
	  <input type="text" class="form-control" id="formGroupExampleInput" name = "script" value="${dto.script}">
	</div>
	<div class="mb-3">
	  <label for="formGroupExampleInput" class="form-label">이자율</label>
	  <input type="text" class="form-control" id="formGroupExampleInput" name ="interest" value="${dto.interest}">
	</div>
	</div>
	<button type = "submit" class="btn btn-primary mb-3">수정하기</button>
	</form>
</div>        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>