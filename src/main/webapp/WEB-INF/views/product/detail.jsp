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

<table  class="table table-hover">
		<thead>
			<tr>
				<th>상품 코드</th>
				<th>상품 명</th>
				<th>이자율</th>
				<th>통장 설명</th>
			</tr>
		</thead>
		<tbody>	
				<tr>	
					<td>${dto.p_code}</td>
					<td>${dto.ac_name}</td>
					<td>${dto.interest}</td>
					<td>${dto.script}</td>
				</tr>	
		</tbody>
	</table>



<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>