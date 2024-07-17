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
                            <h1>이체하기</h1>
                            <span class="subheading">Transfer</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
        <div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">이체</h4>
				<form method="post" action="./transfer" id="frm"
					onsubmit="return checkValue()">
					<input type="hidden" value="${dto.ac_num}" name="ac_num">
					<div class="row g-3">
						<div class="col-md-6">
							<label for="other_num" class="form-label">계좌번호</label> <input
								type="text" class="form-control" id="other_num" name="other_num"
								maxlength="50" placeholder="이체 할 계좌를 입력해주세요" required> <span
								class="idchk"></span>
						</div>
						</div>
							
					<div class="row g-3">
						<div class="col-md-6">
							<label for="money" class="form-label">금액</label> <input
								type="text" class="form-control" id="money" name="money"
								maxlength="50" placeholder="이체 할 금액을 입력해주세요" required> <span
								class="idchk"></span>
						</div>
						
					</div>
					
<table  class="table">
		<thead>
			<tr>
				<th>계좌번호</th>
				<th>계좌 잔고</th>
				
			</tr>
		</thead>
		<tbody>	
				<tr>	
					<td>${dto.ac_num}</td>
					<td>${dto.a_balance}</td>
				</tr>	
		</tbody>
	</table>
	
						<div class="col-12">
							<button onclick="test()" type="submit" class="btn btn-primary mb-3"
								id="btn">이체</button>
						</div>
				</form>

			</div>
		</div>
	</div>
        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>