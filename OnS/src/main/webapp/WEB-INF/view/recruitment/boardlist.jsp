<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="/js/jquery-3.6.4.min.js" ></script>
<link href="/css/import.css" rel="stylesheet" type="text/css" />
<script src="/js/qnapostview.js"></script>
<script src="/js/menu.js"></script>
</head>
<body>

    <div id="header"></div>
    <br/>
    <section class="blog-section">
	  <div class="selectBox mb20">
	  	<div class="btn-box">
		    <select name="fruits" class="select">
	   	      <option disabled selected>-- 선택하세요 --</option>
		      <option value="apple">자바</option>
			  <option value="orange">파이썬</option>
			  <option value="grape">sql</option>
			  <option value="melon">리액트</option>
			</select>
		 	<button class="button ml10 pt5 pb5 pl20 pr20 fon-13">검색</button>
		 	<button id="newPage" class="button ml10 pt5 pb5 pl20 pr20 fon-13  mr10">새글작성</button>
		</div>
	  </div>
      <div class="container">
        <c:forEach items="${memberlist }" var="dto">
	        <div class="blog-list">
	          <div class="blog-item">
		          	<div class="badge fon-11 mb10 plus">자바</div>
		            <div class="blog-content plus">
		              <p class="blog-date mb5 fon11 plus fon-bold">작성일: ${dto.created_time }</p>
		              <h3 class="mt30">${dto.contents }</h3>
		            </div>
		            <div class="blog-foot">
		            	<div>
		            		<span class="fon-bold">${dto.user_id }</span>
		            	</div>
		            	<div class="view">
			            	<svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 512 512" color="#999999" height="18" width="18" xmlns="http://www.w3.org/2000/svg" style="color: rgb(153, 153, 153);"><path d="M256 32C114.6 32 0 125.1 0 240c0 47.6 19.9 91.2 52.9 126.3C38 405.7 7 439.1 6.5 439.5c-6.6 7-8.4 17.2-4.6 26S14.4 480 24 480c61.5 0 110-25.7 139.1-46.3C192 442.8 223.2 448 256 448c141.4 0 256-93.1 256-208S397.4 32 256 32zm0 368c-26.7 0-53.1-4.1-78.4-12.1l-22.7-7.2-19.5 13.8c-14.3 10.1-33.9 21.4-57.5 29 7.3-12.1 14.4-25.7 19.9-40.2l10.6-28.1-20.6-21.8C69.7 314.1 48 282.2 48 240c0-88.2 93.3-160 208-160s208 71.8 208 160-93.3 160-208 160z"></path></svg>
			            	<p class="fon-bold">0</p>
		            	</div>
		            </div>
	          </div>
	         </div>  
         </c:forEach>                                                                                                                
      </div>
   </section> 
</body>
</html>