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

        <header class="masthead" style="background-image: url('/resources/assets/img/moomin6.png')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>회원가입</h1>
                            <span class="subheading">Join</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        
<div class="container mb-3">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
			<form method="post" action="./join" method="post" id="frm"
				enctype="multipart/form-data">
				<div class="row g-3 mb-3">
					<div class="col-md-6">
						<label for="id" class="form-label">아이디</label> <input type="text"
							class="form-control" id="id" name="id" maxlength="50"
							placeholder="아이디를 입력해주세요" required> <span class="idchk"></span>
					</div>
					<div class="col-md-6">
						<label for="name" class="form-label" >이름</label> <input type="text"
							class="form-control" name="name"  id="name" placeholder="이름을 입력해주세요"
							value="" required>

					</div>
				</div>
				<div class="row mb-3">
					<div class="col-md-6">
						<label for="password" class="form-label">비밀번호</label> <input
							type="password" class="form-control ch" name="password"
							id="password" placeholder="비밀번호를 입력해주세요" value="" required>
			<div id="pwerror"></div>
					</div>
					<div class="col-md-6">
						<label for="inputPassword" class="form-label">비밀번호</label> <input
							type="password" class="form-control ch" id="inputPasswordCheck"
							name="member_pw">
						<div id="pweeqrror"></div>
					</div>

				</div>
				<div class="mb-3">
					<label for="email" class="form-label">이메일</label> <input
						type="text" class="form-control" name="email"id="email"
						placeholder="metadog@example.com" required="required"> 
				</div>

				<div class="mb-3">
					<label for="phone" class="form-label">휴대폰 번호</label> <input
						type="text" class="form-control" name="phone"  id="phone"> 
				</div>


				<div class="mb-3">
					<label for="ss_num" class="form-label">주민 번호</label> <input
						type="text" class="form-control" name="ss_num"> 
				</div>
				<div class="col-12">
					<button type="button" id="add" class="btn btn-primary">사진추가</button>
				</div>
				<div id="result"></div>
				<div class="col-12">
					<button type="submit" class="btn btn-success" id="btn">회원가입</button>
				</div>
			</form>

		</div>
	</div>
</div>

<c:import url="/WEB-INF/views/template/footer_script.jsp"></c:import>
<script type="text/javascript" src="../resources/js/member/memberJoinCheck.js"></script>
<script type="text/javascript" src="../resources/js/commons/files.js"></script>
</body>
</html>
