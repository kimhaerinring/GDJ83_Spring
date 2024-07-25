<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">댓글번호</th>
                      <th scope="col">작성자</th>
                      <th scope="col">상품코드</th>
                      <th scope="col">작성일</th>
                      <th scope="col">댓글내용</th>
                     
                    </tr>
                  </thead>
                  <tbody class="table-group-divider">
                    <c:forEach items="${list}" var="ar">
                        <tr>
                          <td>${ar.comments_num}</td>
                          <td>${ar.id}</td>
                          <td>${ar.p_code}</td>
                          <td>${ar.comments_Date}</td>
                          <td>${ar.comments_Content}</td>
                          <td><c:if test="${ar.id eq member.id}"><button class="del" data-comment-del="${ar.comments_num}" type="button">x</button></c:if></td>
                        </tr>
                   </c:forEach>
                  </tbody>
                </table>
            </div>
        </div>
             
        <!-- 페이지 버튼 -->
	  <nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center mt-3">
	
	    <li class="page-item ${pager.pre?'':'disabled'}">
	      <a class="page-link pn" data-page-num="${pager.startNum-1}" href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
	    <li class="page-item"><a class="page-link pn" data-page-num="${i}" href="#">${i}</a></li>
		</c:forEach>
		
	    <li class="page-item ${pager.next?'':'disabled'}">
	      <a class="page-link pn" data-page-num="${pager.lastNum+1}" href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
      <button class="pn">TEST</button>