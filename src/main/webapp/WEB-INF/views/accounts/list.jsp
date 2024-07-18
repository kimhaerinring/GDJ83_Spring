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
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin1.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>내역조회</h1>
                            <span class="subheading">Account</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

<div class="container justify-content-center text-center">
<form method="post" action="./list" id="frm"
					onsubmit="return checkValue()">
					<input type="hidden" value="${dto.ac_num}" name="ac_num">
					
					<div class="mb-3 container" align="right">
					<a href="list?ac_num=${param.ac_num}&order=1" class="btn btn-primary">과거순</a>
					<a href="list?ac_num=${param.ac_num}&order=0" class="btn btn-primary">최신순</a>
					</div>
					<div class="mb-3 container" align="right">
					<a href="list?ac_num=${param.ac_num}&oo=1" class="btn btn-success">입금</a>
					<a href="list?ac_num=${param.ac_num}&oo=2" class="btn btn-success">출금</a>
					<a href="list?ac_num=${param.ac_num}" class="btn btn-success">입금/출금</a>
					</div>
					
<table  class="table">
		<thead>
 <tr>
				<th>계좌번호</th>
				<th>출입금</th>
				<th>금액</th>
				<th>날짜</th>
				<th>총잔액</th>
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
 </div>
        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>