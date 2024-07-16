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
              <th>글번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>조회수</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${dto.boardNum}</td>
              <td>${dto.boardTitle}</td>
              <td>${dto.boardWriter}</td>
              <td>${dto.createDate}</td>
              <td>${dto.boardHit}</td>
            </tr>
            <tr>
              <td colspan='5'>내용: ${dto.boardContents}</td>
            </tr>
		</tbody>
	</table>

	<a class="btn btn-primary justify-content-end me-2"  href="./delete?boardNum=${dto.boardNum}">삭제</a>
	<a  class="btn btn-primary justify-content-end me-2" href="./update?boardNum=${dto.boardNum}">수정</a>


<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>