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

	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form method="post" action="./join" id="frm"
					onsubmit="return checkValue()">
					<div class="row g-3">
						<div class="col-md-6">
							<label for="id" class="form-label">아이디</label> <input type="text"
								class="form-control" id="id" name="id" maxlength="50"
								placeholder="아이디를 입력해주세요" required> <span class="idchk"></span>
						</div>
						<div class="col-md-6">
							<label for="name" class="form-label">이름</label> <input
								type="text" class="form-control" name="name"
								placeholder="이름을 입력해주세요" value="" required> <span
								class="memberNamechk"></span>

						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<label for="password" class="form-label">비밀번호</label> <input
								type="password" class="form-control" name="password" id="password2"
								placeholder="비밀번호를 입력해주세요" value="" required> <span
								class="pwchk1"></span>
						</div>

						<div class="col-md-6">
							<label for="password" class="form-label">비밀번호 확인</label> <input
								type="password" class="form-control" name="password2"
								id="password1" placeholder="비밀번호를 다시 한번 입력해주세요" value=""
								required><span class="pwchk"></span>
						</div>
				
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">이메일</label> <input
							type="text" class="form-control" name="email"
							placeholder="metadog@example.com" required="required"> <span
							class="emailchk"></span>
					</div>

					<div class="mb-3">
						<label for="phone" class="form-label">휴대폰 번호</label> <input
							type="text" class="form-control" name="phone"> <span
							class="phchk"></span>
					</div>


					<div class="mb-3">
						<label for="ss_num" class="form-label">주민 번호</label> <input
							type="text" class="form-control" name="ss_num"> <span
							class="phchk"></span>
					</div>


					<div class="col-12">
						<button onclick="test()"type="submit" class="btn btn-primary" id="btn">Sign</button>
					</div>
				</form>

			</div>
		</div>
	</div>

<script type="text/javascript">
    function test() {
      var p1 = document.getElementById('password1').value;
      var p2 = document.getElementById('password2').value;
      if( p1 != p2 ) {
        alert("비밀번호가 일치 하지 않습니다");
        return false;
      } else{
        alert("비밀번호가 일치합니다");
        return true;
      }

    }
  </script>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>

</html>