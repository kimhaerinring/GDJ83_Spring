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

<div class="input-group">
  <span class="input-group-text">이름</span>
  <input type="text" name="name" aria-label=" name" class="form-control" value="${member.name}">
</div>
<div class="input-group">
  <span class="input-group-text">아이디</span>
  <input type="text" aria-label="id" class="form-control" value="${member.id}">
</div>
<div class="input-group">
  <span class="input-group-text">비밀번호</span>
  <input type="text" aria-label="password" class="form-control" value="${member.password}">
</div>
<div class="input-group">
  <span class="input-group-text">이메일</span>
  <input type="text" aria-label="email" class="form-control" value="${member.email}">
</div>
<div class="input-group">
  <span class="input-group-text">전화번호</span>
  <input type="text" aria-label="phone" class="form-control" value="${member.phone}">
</div>
<div class="input-group">
  <span class="input-group-text">주민번호</span>
  <input type="text" aria-label="ss_num" class="form-control" value="${member.ss_num}">
</div>

<c:forEach items="${member.dtos}" var="ac">
<div class="input-group">
  <span class="input-group-text">계좌번호</span>
  <input type="text" aria-label="ac_num" class="form-control" value="${ac.ac_num}">
</div>
<div class="input-group">
  <span class="input-group-text">잔액</span>
  <input type="text" aria-label="a_balance" class="form-control" value="${ac.a_balance}">
</div>
</c:forEach>

	<a href="./delete?id=${member.id}" class="btn btn-danger">삭제</a>
	
	<a href="./update?id=${member.id}" class="btn btn-primary">수정</a>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>