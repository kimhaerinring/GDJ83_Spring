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
                            <h1>공지사항</h1>
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
                            <h1>질답 게시판</h1>
                            <span class="subheading">QnA</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>    
    </c:otherwise>
</c:choose>       
       		<!-- 메인 내용 -->
					<div class="container text-center">       		
                    <p>🌱글 내용을 보시려면, 글 제목을 클릭해주세요🌱</p>
                    </div>

       	 <main class="mb-4">
            <div class="px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
						<table class="table">
						
							<thead>
							
								<tr>
									<td>글번호</td>
									<td>글제목</td>
									<td>작성자</td>
									<td>작성일자</td>
									<td>조회수</td>
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${list}" var="ar">
								<tr>
								
									<td>
									<c:if test="${ar.del eq 0}">
									${ar.boardNum}
									</c:if>
									</td>
									<td>
									<c:choose>
										<c:when test="${ar.del eq 0}">
										
									<a href="./detail?boardNum=${ar.boardNum}">
									<c:catch>
									<c:forEach begin="1" end="${ar.depth}">--</c:forEach>
									</c:catch>
									${ar.boardTitle}
									</a>
										</c:when>
										<c:otherwise>
										삭제된 글입니다
										</c:otherwise>
									</c:choose>
									</td>
									<td>${ar.boardWriter}</td>
									<td>${ar.createDate}</td>
									<td>${ar.boardHit}</td>
								
								</tr>	
									</c:forEach>
							</tbody>
						
						
						</table>
                    </div>
  	<div class="col-12 mb-3" align="right">
	    <a href="./add"><button type="submit" class="btn btn-primary">새글쓰기</button></a>
	  </div>
                </div>
                

        <!-- 검색 버튼 -->
	<form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center justify-content-end"">
	  <div class="col-12">
	    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
	    <select name = "kind" class="form-select" id="inlineFormSelectPref">
	      <option value="k1">제목</option>
	      <option value="k2">작성자</option>
	      <option value="k3">내용</option>
	    </select>
	  </div>
	  <div class="col-12">
	    <label class="visually-hidden" for="inlineFormInputGroupUsername"></label>
	    <div class="input-group">
	      <input name = "search" type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
	    </div>
 	  </div>
	  <div class="col-12">
	    <button type="submit" class="btn btn-primary">검색하기</button>
	  </div>
	</form>
        
        <!-- 페이지 버튼 -->
	  <nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center mt-3">
	
	    <li class="page-item ${pager.pre?'':'disabled'}">
	      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
	    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
		</c:forEach>
		
	    <li class="page-item ${pager.next?'':'disabled'}">
	      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
            </div>
        </main>  


        
<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
</body>
</html>