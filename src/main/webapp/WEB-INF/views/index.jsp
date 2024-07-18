<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="./template/header_nav.jsp"></c:import>

	        <!-- Page Header 사진 안에 글씨 넣는 곳-->
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin3.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>Haerin's HomePage</h1>
                            <span class="subheading">어서오세요</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
       <c:if test="${empty member}">
        <div class="container justify-content-center text-center">
        <p>🌸회원이시라면 로그인을, 아니시라면 회원가입을 해주세요🌸</p>
    	</div>
		</c:if>
		<c:if test="${not empty member}">
        <div class="container justify-content-center text-center">
        <p>🌸${member.id} 님 환영합니다🌸</p>
    	</div>
		</c:if>
        
<c:import url="./template/footer_script.jsp"></c:import>
</body>
</html>