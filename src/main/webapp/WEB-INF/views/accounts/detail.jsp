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
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin6.png')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>계좌 확인</h1>
                            <span class="subheading">Account</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
        <div class="container justify-content-center text-center">
        <table  class="table">
		<thead>
			<tr>
				<th>상품이름</th>
				<th>계좌번호</th>
				<th>계좌잔고</th>
				<th>개설일</th>
			</tr>
		</thead>
		<tbody>	
				<tr>	
					<td>${account.productDTO.ac_name}</td>
					<td>${account.ac_num}</td>
					<td>${account.a_balance}</td>
					<td>${account.a_date}</td>
				</tr>	
		</tbody>
	</table>
	
	<div class="col-12 mt-3" align="right">
    <a href="./transfer?ac_num=${account.ac_num}" ><button class="btn btn-primary">이체하기</button></a>
  </div>
  	<div class="col-12 mt-3" align="right">
    <a href="./list?ac_num=${account.ac_num}&order=0"><button class="btn btn-primary mb-3">내역조회</button></a>
  </div>
 </div>
	<div >
	
	
    </div>
        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>