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
	<div class="container mt-5">
		<div class="row justify-content-center text-conter">
			<!-- 검색 입력 폼 -->

			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<form class="d-flex" action="./list" method="get">
						<input name="search" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
						
						<div class="col-3">
							<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
							<select name="kind" class="form-select" id="inlineFormSelectPref">
								
								<option value="k1">상품명</option>
								<option value="k2">상품내용</option>

							</select>
						</div>
					</form>
				</div>
			</nav>

			<!--  -->
			<table class="table table-hover">
				<thead>
					<tr>
						<th>상품 코드</th>
						<th>상품 명</th>
						<th>이자율</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.list }" var="dto">
						<tr>
							<td>${dto.p_code}</td>
							<td><a href="./detail?p_code=${dto.p_code}">${dto.ac_name}</a></td>
							<td>${dto.interest}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="Page navigation example">
				<ul class="pagination">

					<li class="page-item ${pager.pre?'':'disabled'} "><a
						class="page-link" href="./list?page=${pager.startNum -1}&kind=${pager.kind}&search=${pager.search}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>

					<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" step="1"
						var="i">
						<li class="page-item"><a class="page-link"
							href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>

					<li class="page-item ${pager.next?'':'disabled'}"><a
						class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
			<div>
				<a href="add" class="btn btn-success">통장등록</a>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>