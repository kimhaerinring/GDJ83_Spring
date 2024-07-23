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
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin2.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>${dto.ac_name}</h1>
                            <h1>상품 소개</h1>
                            <span class="subheading">Product</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
        <!-- Main Content-->
        <main class="mb-4">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center text-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                    	<p>🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻🌻</p>
                    <div>
                    	<c:forEach items="${dto.fileDTOs}" var="f">
                    		<a href="/resources/upload/products/${f.filename}">${f.oriname}
                    	</a>
                    	</c:forEach>
					</div>
				
					<p>* 상품명 : ${dto.ac_name}</p>
                        <p>* 이자율 : ${dto.interest}</p>
                        <p>* 상품설명 : ${dto.script}</p>
                    </div>
                </div>
		      <div class="col-12 mb-3" align="right">
		      <button class="btn btn-primary" type="button" id="addWish" data-product-id="${dto.p_code}">
						<h9>즐겨찾기</h9> 
		      </button>
			    <a href="/accounts/add?p_code=${dto.p_code}"><button type="submit" class="btn btn-primary">가입하기</button></a>
			    <a href="./update?p_code=${dto.p_code}"><button type="submit" class="btn btn-primary">수정하기</button></a>
			    <a href="./delete?p_code=${dto.p_code}"><button type="submit" class="btn btn-primary">삭제하기</button></a>
			  </div>
            </div>
        </main>
<div id="wishResult">
	
</div>
        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
<script src="/resources/js/product/wish.js"></script>
</body>
</html>