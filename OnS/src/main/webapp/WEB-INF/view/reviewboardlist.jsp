<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/js/jquery-3.6.4.min.js" ></script>
<link href="/css/import.css" rel="stylesheet" type="text/css" />

<script>
$(document).ready(function () {
	
    // 작성 버튼 위에 마우스 올렸을 때 검은색으로 변하게 하기
    $('#writebtn').hover(
        function () {
            $(this).css('backgroundColor', 'black');
        });

//게시글 버튼 클릭시 1개 게시글 메인조회페이지로 이동
  $('.blog-item').click(
        function () {
           window.location.href = "./ReviewPostView.html?board=4";
        } );
        
   //게시글 작성 버튼 클릭시 작성페이지로 이동
  $('#writebtn').on('click', function () {
	  	const url = "http://localhost:8080/reviewboardwrite";
        window.location.href= url;
        } );
        
 
    });

</script>

    <title>OnS | 온라인 스터디</title>

</head>
<body>
    <!-- 로고 및 메뉴 추가 -->
    <div id="header"></div>
    <br/>
  	
    <section class="blog-section">
      <div class="selectBox mb20">
        <div class="btn-box">
          <select id="categorybox" class="select">
            <option disabled selected>-- 선택하세요 --</option>
            <option value="java">자바</option>
            <option value="sql">SQL</option>
            <option value="css">CSS</option>
            <option value="html">HTML</option>
            <option value="javascript">자바스크립트</option>
            <option value="react">리액트</option>			  
          </select>
          <button id="searchbtn" class="button ml10 pt5 pb5 pl20 pr20 fon-13 mr10">검색</button>
          <button id="writebtn" class="button ml10 pt5 pb5 pl20 pr20 fon-13 mr10">글 작성하기</button>
		</div>
	  </div>
      <div class="container">

			<c:forEach items="${totalList}" var="boardDTO">
        <div class="blog-list">
          <div class="blog-item">
          	<div id="category" class="badge badge-sy fon-11 mb15">
          	java <!-- 게시글 종류 수정 필요 -->
          	</div>
            <div class="blog-thumbnail mb10">
              <img src="./img/javascript-review.png" alt="게시물 이미지" class="mb5">
            </div>
            <div class="blog-content">
              <h4 id="title" class="mb5">${boardDTO.title }</h4>
              <p class="blog-date mb5 fon11">강의만족도: ${boardDTO.rating }</p>
              <p id="text" class="blog-excerpt mb5">${boardDTO.contents }</p> 
            </div>
           </div>
            </div>
			</c:forEach>
	            </div>
	
          <!-- 추가적인 게시물 아이템을 여기에 추가할 수 있습니다 
          	게시글 클릭시 이동:<a href="./ReviewPostView.html?board=4" class="read-more">...</a> 
            <div id="badge-viewcount" class="badge-viewcount fon-11 mb15">조회수🔥</div>
            <div id="badge-recommend" class="badge-recommend fon-11 mb15">추천수👍</div>
            <div id="badge-new" class="badge-new fon-11 mb15">NEW💬</div>
          
          
          
        <div class="blog-list">
          <div class="blog-item">
          	<div id="category" class="badge badge-sy fon-11 mb15">java</div>

            <div class="blog-thumbnail mb10">
              <img src="./img/javascript-review.png" alt="게시물 이미지" class="mb5">
            </div>
            <div class="blog-content">
              <h4 id="title" class="mb5">자바 알고리즘 문제 풀이 입문</h4>
              <p id="time" class="blog-date mb5 fon11">강의만족도: ⭐⭐⭐</p>
              <p id="text" class="blog-excerpt mb5">자바로 코딩테스트를 준비하시는 분을 위한 강좌입니다. 코딩테스트에서 가장 많이 출제되는 Top 10 Topic을 다루고 있습니다. 주제와 연동하여<a href="./ReviewPostView.html?board=4" class="read-more">...</a></p>
            </div>
          </div>
         </div>
       </div>-->
   </section>
  
  </body>
  </html>
