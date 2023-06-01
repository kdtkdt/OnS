<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   	
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="modal">
      <div class="modal_body">
      	<h3 class="mb20">수정되었습니다</h3>
      	<button class="check button ml10 pt5 pb5 pl20 pr20 fon-13">확인</button>
      </div>
    </div>
    <div class="modal">
      <div class="modal_body">
      	<h3 class="mb20">삭제되었습니다</h3>
      	<button class="check button ml10 pt5 pb5 pl20 pr20 fon-13">확인</button>
      </div>
    </div>
    <div id="post-box" class="ppp20">
        <!-- 게시글 내용 -->
        <div id="post-content-box" class="pppp20 mr20 ml20">
            <div>
                <h1 id="post-title" class="mb10">${postviewlist.title}</h1>
                <p id="post-info">
                    <span id="view-count">&nbsp;${postviewlist.view_count}</span>
                    <span>조회수</span>
                    <span id="post-datetime">${postviewlist.created_time}&nbsp;</span>
                    <span id="username" class="fon-bold">${postviewlist.user.nickname}&nbsp;</span>
                </p>
            </div>
            <div id="content-delimeter" class="mt10 mb10"></div>
            <div id="content" class="mt10 mb10 fon-fam-ver plus">
                <p class="fon-15">${postviewlist.contents}</p>
            </div>
            <div id="content-delimeter" class="mt10 mb10"></div>
            <!-- 수정/삭제는 게시글 작성자일 때만 보이게 수정 필요 -->
            <div id="button-box">
                <button id="delete" class="button ml10 pt5 pb5 pl20 pr20 fon-13">삭제</button>
                <button id="modify" class="button ml10 pt5 pb5 pl20 pr20 fon-13">수정</button>
            </div>
        </div>
    
        <!-- 댓글 -->
        <div id="comment-box" class="pppp20 mr20 ml20 mb20 mt10">
            <div id="comment-count-box" class="pppp10 flex">
                <h3>댓글</h3>
                <h3 id="comment-counter" class="ml5">3</h3>
            </div>
            <textarea id="comment-input" class="pppp20"></textarea>
            <div id="button-box">
                <button id="comment-button" class="button mt20 mb10 ml10 pt5 pb5 pl20 pr20 fon-13">등록</button>
            </div>
            <!-- 더미 데이터1 -->
            <c:forEach items="${commentinfo }" var="dto" varStatus="status">
	            <div class="pppp10">
	                <div id="comment-info" class="flex">
	                    <p id="comment-username" class="fon-bold">${dto.user.nickname}</p>
	                    <p id="comment-time" class="ml10">	                    
	                    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd a hh:mm"/>
	                    </p>
	                </div>
	                <div class="comment-content">
	                    <p>${commentlist[status.index].comment.contents}</p>
	                </div>
	            </div>
	            <div id="content-delimeter" class="mt10 mb10"></div>
            </c:forEach> 
            <!-- 더미 데이터2 - 대댓글 -->
            <div class="pppp10 ml30">
                <div id="comment-info" class="flex">
                    <p id="comment-username" class="fon-bold">냠냠</p>
                    <p id="comment-time" class="ml10">2023.5.8 14:55</p>
                </div>
                <div class="comment-content">
                    <div>
                        <p>그렇군요...</p>
                        <p>하아...</p>
                    </div>
                    <!-- 수정/삭제는 게시글 작성자일 때만 보이게 수정 필요 -->
                    <div>
                        <a>수정</a>
                        <span>&#124;</span>
                        <a>삭제</a>
                    </div>
                </div>
            </div>
            <!-- 더미 데이터3 -->
            <div id="content-delimeter" class="mt10 mb10"></div>
            <div class="pppp10">
                <div id="comment-info" class="flex">
                    <p id="comment-username" class="fon-bold">hoolay</p>
                    <p id="comment-time" class="ml10">2023.5.8 14:57</p>
                </div>
                <div class="comment-content">
                    <p>저 하고싶습니다.</p>
                </div>
            </div>
        </div>
    </div> 
</body>
	<script type="text/javascript">
		// $(window).on('load',function(){
		//     $('.menu').removeClass("choose");
		//     $('.menu').eq(0).addClass("choose");
		// });
		$('.check').click(function(){
			location.href = 'boardRecruitment.html?board=1';
		});
		
		/*모달창*/
	      const body = document.querySelector('body');
	      const modal = document.querySelectorAll('.modal')[0];
	      const modal2 = document.querySelectorAll('.modal')[1];
	      const mod = document.querySelector('#modify');
	      const del = document.querySelector('#delete');

	      	mod.addEventListener('click', () => {
	        	modal.classList.toggle('show');
		        if (modal.classList.contains('show')) {
			          body.style.overflow = 'hidden';
			        }
	      	});
		    del.addEventListener('click', () => {
		      	modal2.classList.toggle('show');
	        if (modal2.classList.contains('show')) {
		          body.style.overflow = 'hidden';
		        }
	      });
	
	</script>
</html>