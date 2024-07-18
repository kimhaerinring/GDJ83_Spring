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

        <header class="masthead" style="background-image: url('/resources/assets/img/moomin5.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>내정보 수정</h1>
                            <span class="subheading">MyPage</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
 
 <div class="container">   
        <form action="/member/update" method="post">
<div>
   <div class="col-12">
    <label for="inputName" class="form-label">이름</label>
    <input type="hidden" name="id"  value ="${member.id}" readonly>
    <input type="text" class="form-control" id="inputName" name="name" value="${member.name}">
  </div>
   <div class="col-12">
    <label for="inputPhone" class="form-label">전화번호</label>
    <input type="text" class="form-control" id="inputPhone" name="phone" value="${member.phone}">
  </div>
  <div class="col-12">
    <label for="inputMail" class="form-label">E-mail</label>
    <input type="text" class="form-control" id="inputMail" name="email" value="${member.email}">
  </div>
  
  <div class="col-12">
    <a href="/member/update"><button class="btn btn-primary mt-3" type="submit">수정하기</button></a>
  </div>
 
</div>
</form>

<div>


<a href="./delete?id=${member.id}"><button class="btn btn-primary mt-3 mb-3" type="submit" >탈퇴하기</button></a>


</div>
</div>    
        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>