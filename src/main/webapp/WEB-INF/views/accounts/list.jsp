<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내역들 조회</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

<form method="post" action="./list" id="frm"
					onsubmit="return checkValue()">
					<input type="hidden" value="${dto.ac_num}" name="ac_num">
					
					<div>
					<a href="list?ac_num=${param.ac_num}&order=1">과거순으로</a>
					<a href="list?ac_num=${param.ac_num}&order=0">최신순으로</a>
					<a href="list?ac_num=${param.ac_num}&oo=1">입금만</a>
					<a href="list?ac_num=${param.ac_num}&oo=2">출금만</a>
					<a href="list?ac_num=${param.ac_num}">입금/출금</a>
					</div>
					
<table  class="table table-hover">
		<thead>
 <tr>
				<th>계좌번호</th>
				<th>출입금</th>
				<th>금액</th>
				<th>날짜</th>
				<th>총 잔액</th>
			</tr>
  </thead>
  <tbody>
  <c:forEach items="${requestScope.dtos}" var="dto" varStatus="i">
  <tr>
  <td><c:out value="${dto.ac_num}"/></td>
  <td class="${dto.money<0?'text-danger':'text-primary'}">
  	<c:choose>
  		<c:when test="${dto.money<0}">출금</c:when>
  		<c:otherwise>입금</c:otherwise>
  	</c:choose>
  	</td>
  <td><c:out value="${dto.money}"/></td>
  <td><c:out value="${dto.period}"/></td>
  <td><c:out value="${dto.balance}"/></td>
  </tr>
  </c:forEach>
  </tbody>
  </table>
	
</form>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>