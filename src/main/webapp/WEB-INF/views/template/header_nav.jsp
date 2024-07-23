<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!-- Navigation í¤ë ê³µë ë¶ë¶ -->
        <nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/product/list">Product</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/notice/list">Notice</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/qna/list">QnA</a></li>
	                        <c:if test="${empty member}">
							<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/member/join">Join</a></li>
			                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/member/login">LogIn</a></li>
			                </c:if>
			                <c:if test="${not empty member}">
							<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/member/mypage">MyPage</a></li>
									<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/product/wishList">WishList</a></li>
			                <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="/member/logout">LogOut</a></li>
			                </c:if>
                    </ul>
                </div>
            </div>
        </nav>