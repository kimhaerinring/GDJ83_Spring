<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
<c:import url="/WEB-INF/views/template/summer.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/template/header_nav.jsp"></c:import>

	        <!-- Page Header 사진 안에 글씨 넣는 곳-->
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin2.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>Product Add</h1>
                            <span class="subheading">Product</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

<div class="container">
	<form action="/product/add" method="post" enctype="multipart/form-data">
	<div>
	<div class="mb-3">
	  <label for="formGroupExampleInput" class="form-label">상품명</label>
	  <input type="text" class="form-control" id="formGroupExampleInput" name = "ac_name">
	</div>
	<div class="mb-3"  >
	  <label for="formGroupExampleInput" class="form-label">상품설명</label>
	  <textarea  class="form-control" id="bookDetail" name = "script"></textarea>
	</div>
	<div class="mb-3">
	  <label for="formGroupExampleInput" class="form-label">이자율</label>
	  <input type="text" class="form-control" id="formGroupExampleInput" name ="interest">
	</div>
		<div class="col-12">
					<button type="button" id="add" class="btn btn-primary">사진추가</button>
				</div>
				<div id="result"></div>
	</div>
	<script src="../resources/js/commons/files.js"></script>
	<script  type="text/javascript" >setMax(5);
	$("#bookDetail").summernote();
	</script>
	
	<button type = "submit" class="btn btn-primary mb-3">추가하기</button>
	</form>
</div>      



        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>