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

        <header class="masthead" style="background-image: url('/resources/assets/img/moomin4.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>마이페이지</h1>
                            <span class="subheading">MyPage</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
 <div class="container">


  <div class="col-12">
    <label for="inputID" class="form-label">ID</label>
    <input type="text" class="form-control" id="inputEmail" name="id" value="${member.id}" readonly>
  </div>
   <div class="col-12">
    <label for="inputName" class="form-label">이름</label>
    <input type="text" class="form-control" id="inputName" name="name" value="${member.name}" readonly>
  </div>
   <div class="col-12">
    <label for="inputPhone" class="form-label">전화번호</label>
    <input type="text" class="form-control" id="inputPhone" name="phone" value="${member.phone}" readonly>
  </div>
  <div class="col-12">
    <label for="inputMail" class="form-label">E-mail</label>
    <input type="text" class="form-control" id="inputMail" name="email" value="${member.email}" readonly>
  </div>
  
  <div class="col-12 mt-3">
    <a href="/member/update"><button class="btn btn-primary">회원정보 수정하기</button></a>
  </div>
  </div>
  

  <div class="container mt-3 text-center">
  	<h3>🌟내가 가입한 상품🌟</h3>
  </div>
  

  <div class ="container mt-5 justify-content-center text-center">
<table class="table table-hover mt-3">

	<thead>
	
		<tr>
			<td>계좌번호</td>
			<td>잔액</td>
		</tr>
	</thead>
	<tbody>
  		<c:forEach items="${member.dtos}" var="ac">
		<tr>
		
			<td><a href="../accounts/detail?ac_num=${ac.ac_num}"">${ac.ac_num}</a></td>
			<td> ${ac.a_balance}</td>

		
		</tr>	
			</c:forEach>
	</tbody>


</table>  

</div>
        
        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>