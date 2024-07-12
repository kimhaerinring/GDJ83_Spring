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
			<input type="hidden" name="p_code"  value ="${dto.p_code }">
			
			
			
	  <div class="mb-3">
	    <label for="ac_name" class="form-label">상품명</label>
	    <input type="text" value="${dto.ac_name }"  class="form-control" id="ac_name" name="ac_name">
			  </div>
			
		  <div class="mb-3">
	    <label for="interest" class="form-label">이자율</label>
	    <input type="text" value="${dto.interest}" class="form-control" id="interest" name="interest">
			  </div>
			  
			    <div class="mb-3">
	    <label for="script" class="form-label">통장 설명</label>
	    <input type="text" value="${dto.script}"  class="form-control" id="script" name="script">
			  </div>
			  <button type="submit" class="btn btn-success">등록</button>
			</form>
		</div>
	</div>
		
		

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>