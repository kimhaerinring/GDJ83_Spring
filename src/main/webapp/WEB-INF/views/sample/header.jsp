<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<ul class="nav nav-tabs justify-content-center ">
	<li class="nav-item"><a class="nav-link active"
		aria-current="page" href="/">BankHome🏠</a></li>
		
	<li class="nav-item" ><a class="nav-link" href="/notice/list">공지사항📌</a>
	</li>
	<li class="nav-item"><a class="nav-link" href="/product/list">상품정보🗒️</a></li>
	<li class="nav-item"><a class="nav-link" href="#">조회</a></li>
	<c:choose>
		<c:when test="${not empty sessionScope.member}">
			<li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/member/mypage">마이페이지🙋‍♂️</a>
			</li>
		</c:when>
		<c:otherwise>
			<li class="nav-item"><a class="nav-link" href="/member/join">회원가입</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/member/login">로그인</a>
			</li>
		</c:otherwise>
	</c:choose>


	<%-- <c:if test="${empty sessionScope.member}">
  <li class="nav-item">
    <a class="nav-link" href="/member/join">회원가입</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/member/login">로그인</a>
  </li>
  </c:if>
  <c:if test="${not empty sessionScope.member }">
   <li class="nav-item">
    <a class="nav-link" href="/member/logout">로그아웃</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="/member/mypage">마이페이지♣</a>
  </li>
  </c:if>
   --%>
</ul>