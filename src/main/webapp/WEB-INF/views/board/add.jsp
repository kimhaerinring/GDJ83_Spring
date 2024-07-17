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

<c:choose>
	<c:when test="${board=='Notice'}">
	        <!-- Page Header 사진 안에 글씨 넣는 곳-->
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin4.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>공지사항 글쓰기</h1>
                            <span class="subheading">Notice</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </c:when>
    <c:otherwise>
	        <!-- Page Header 사진 안에 글씨 넣는 곳-->
        <header class="masthead" style="background-image: url('/resources/assets/img/moomin5.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>질답 글쓰기</h1>
                            <span class="subheading">QnA</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>    
    </c:otherwise>
</c:choose>  

<div class="container">
 <form class="row g-3 mt-3" method="post" >
    <input type="hidden" value="${dto.boardNum}" name="boardNum"/>
          <div class="col-md-12">
        <label for="boardWriter" class="form-label">작성자</label>
        <input type="text" class="form-control" name="boardWriter"  value="${member.id}" disabled="disabled">
      </div>
      <div class="col-md-12">
        <label for="boardTitle" class="form-label">글제목</label>
        <input type="text" class="form-control" name="boardTitle" value="${dto.boardTitle}">
      </div>
      <div class="col-12">
        <label for="boardContents" class="form-label">글내용</label>
        <textarea class="form-control" name="boardContents">${dto.boardContents}</textarea>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn btn-primary me-md-2 mb-3" type="submit">등록</button>
      </div>
    </form>
</div>





        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>