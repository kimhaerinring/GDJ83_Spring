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
				<th>상품이름</th>
				<th>계좌번호</th>
				<th>계좌 잔고</th>
				<th>개설 일</th>
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
	
	<div >
	<a href="./transfer?ac_num=${account.ac_num}" >이체</a>
	</div>
	
          


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>