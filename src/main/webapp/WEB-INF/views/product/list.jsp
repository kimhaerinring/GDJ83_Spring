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
                            <h1>Product List</h1>
                            <span class="subheading">Product</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
       		<!-- 메인 내용 -->
       		
       	 <main class="mb-4">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center text-center">
                    <p>🌱상세내용을 보시려면, 상품명을 클릭해주세요🌱</p>
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <table class="table">
						  <thead>
						    <tr>
						      <th scope="col">상품번호</th>
						      <th scope="col">상품명</th>
						      <th scope="col">이자율</th>
						      <th scope="col">상품내용</th>
						    </tr>
						  </thead>
						  <tbody class="table-group-divider">
						    <c:forEach items="${list}" var="ar">
							    <tr>
							      <td>${ar.p_code}</td>
							      <td><a href="./detail?p_code=${ar.p_code}">${ar.ac_name}</a></td>
							      <td>${ar.interest}</td>
							      <td>${ar.script}</td>
							    </tr>
						   </c:forEach>
						  </tbody>
						</table>
                    </div>
                </div>
	<div class="col-12 mb-3" align="right">
	    <a href="./add"><button type="submit" class="btn btn-primary">상품추가</button></a>
	  </div>
        <!-- 검색 버튼 -->
	<form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center justify-content-end"">
	  <div class="col-12">
	    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
	    <select name = "kind" class="form-select" id="inlineFormSelectPref">
	      <option value="k1">상품명</option>
	      <option value="k2">상품내용</option>
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