<%@ page language="java" contentType="text/html; charset=UTF-8"
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
  <jsp:include page="../header.jsp" />
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
        <c:forEach items="${boardlist }" var="dto" varStatus="status">
	        <div class="blog-list" class="link-box" onclick="document.location.href='recruitmentpostview?id=${boardlist2[status.index].id }'">
	          <div class="blog-item">
		          	<div class="badge fon-11 mb10 plus">${dto.skill.name }</div>
		            <div class="blog-content plus">
		              <p class="blog-date mb5 mt20 fon11 plus fon-bold">마감일 | ${boardlist2[status.index].created_time }</p>
		              <h3 class="mt30">${boardlist2[status.index].title }</h3>
		            </div>
		            <div class="blog-foot">
		            	<div>
		            		<span class="fon-bold">${boardlist3[status.index].user.nickname }</span>
		            	</div>
		            	<div class="view">
			            	<svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 1024 1024" color="#999999" height="24" width="24" xmlns="http://www.w3.org/2000/svg" style="color: rgb(153, 153, 153);"><path d="M942.2 486.2C847.4 286.5 704.1 186 512 186c-192.2 0-335.4 100.5-430.2 300.3a60.3 60.3 0 0 0 0 51.5C176.6 737.5 319.9 838 512 838c192.2 0 335.4-100.5 430.2-300.3 7.7-16.2 7.7-35 0-51.5zM512 766c-161.3 0-279.4-81.8-362.7-254C232.6 339.8 350.7 258 512 258c161.3 0 279.4 81.8 362.7 254C791.5 684.2 673.4 766 512 766zm-4-430c-97.2 0-176 78.8-176 176s78.8 176 176 176 176-78.8 176-176-78.8-176-176-176zm0 288c-61.9 0-112-50.1-112-112s50.1-112 112-112 112 50.1 112 112-50.1 112-112 112z"></path></svg>
			            	<p class="fon-bold">${boardlist2[status.index].view_count }</p>
		            	</div>
		            </div>
	          </div>
	         </div>  
         </c:forEach>                                                                                                                
      </div>
   </section> 
</body>
</html>