<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT LIST</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
  <div class="container">
    <form class="row g-3 mt-3" method="post">
      <div class="col-md-12">
        <label for="boardTitle" class="form-label">글제목</label>
        <input type="text" class="form-control" name="boardTitle" value="${dto.boardTitle}">
      </div>
      <div class="col-12">
        <label for="boardContents" class="form-label">글내용</label>
        <textarea class="form-control" name="boardContents">${dto.boardContents}</textarea>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn btn-primary me-md-2" type="submit">등록</button>
      </div>
    </form>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>