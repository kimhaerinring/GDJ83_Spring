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
				<div class="row">
				<h1>수정 폼</h1>
				</div>
			<div class="row">
			<form action="./update" method="post">
			<input type="hidden" name="id"  value ="${member.id }" readonly>
			
			<div class="mb-3">
	    <label for="password" class="form-label">비밀번호(수정 불가)</label>
			<input type="text" value="${member.password }"  class="form-control" id="password" name="password"readonly>
			</div>
			
	  <div class="mb-3">
	    <label for="name" class="form-label">이름</label>
	    <input type="text" value="${member.name }"  class="form-control" id="name" name="name">
			  </div>
			
		  <div class="mb-3">
	    <label for="email" class="form-label">이메일</label>
	    <input type="text" value="${member.email}" class="form-control" id="email" name="email">
			  </div>
			    <div class="mb-3">
	    <label for="ss_num" class="form-label">주민 번호</label>
	    <input type="text" value="${member.ss_num}"  class="form-control" id="ss_num" name="ss_num">
			  </div>
			  
			    <div class="mb-3">
	    <label for="phone" class="form-label">휴대폰 번호</label>
	    <input type="text" value="${member.phone}"  class="form-control" id="phone" name="phone">
			  </div>
			  
			  <button type="submit" class="btn btn-primary">등록</button>
			</form>
		</div>
	</div>
		
		

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>