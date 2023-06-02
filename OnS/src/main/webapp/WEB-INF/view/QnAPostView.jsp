<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ons.study.dto.QnAContentDTO"%>
<%@ page import="com.ons.study.dto.CommentDTO"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"
	integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
	crossorigin="anonymous"></script>

<link href="./css/import.css" rel="stylesheet" type="text/css" />
<script src="./js/qnapostview.js"></script>
<script src="./js/menu.js"></script>

<title>OnS | 온라인 스터디</title>
</head>
<body>
	<!-- 로고 및 메뉴 추가 -->
	<jsp:include page="header.jsp" />

	<br />

	<div id="post-box" class="ppp20">
		<!-- 게시글 내용 -->
		<div id="post-content-box" class="pppp20 mr20 ml20">
			<div>
				<h1 id="post-title" class="mb10">${qnaContent.getTitle()}</h1>
				<p id="post-info">
					<%
					QnAContentDTO dto = (QnAContentDTO) request.getAttribute("qnaContent");
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm");
					out.println("<span id='view-count'>&nbsp;" + dto.getViewCount() + "</span><span>조회수</span>");
					out.println("<span id='post-datetime'>" + dto.getCreatedTime().format(dtf) + "&nbsp;·&nbsp;</span>");
					out.println("<span id='username' class='fon-bold'>" + dto.getNickname() + "&nbsp;</span>");
					%>
				</p>
			</div>
			<div id="content-delimeter" class="mt10 mb10"></div>
			<div id="content" class="mt10 mb10 fon-fam-ver">
				${qnaContent.getContents()}
			</div>
			<div class="mt20 mb20">
				<c:forEach items="${tags }" var="tag">
					<span class="tag fon-11">${tag }</span>
				</c:forEach>
			</div>
			<div id="content-delimeter" class="mt10 mb10"></div>
			<!-- 수정/삭제는 게시글 작성자일 때만 보이게 수정 필요 -->
			<div id="button-box">
				<button id="list-button" class="ml10 pt5 pb5 pl20 pr20 fon-13">목록</button>
				<button id="delete-button" class="ml10 pt5 pb5 pl20 pr20 fon-13">삭제</button>
				<button id="modify-button" class="ml10 pt5 pb5 pl20 pr20 fon-13">수정</button>
			</div>
		</div>

		<!-- 댓글 -->
		<div id="comment-box" class="pppp20 mr20 ml20 mb20 mt10">
			<div id="comment-count-box" class="pppp10 flex">
				<h3>답변</h3>
				<h3 id="comment-counter" class="ml5"><%= dto.getCommentCount() %></h3>
			</div>
			<textarea id="comment-input" class="pppp20"></textarea>
			<div id="button-box">
				<button id="comment-button"
					class="mt20 mb10 ml10 pt5 pb5 pl20 pr20 fon-13">등록</button>
			</div>
			<!-- 더미 데이터1 -->
			<c:forEach items="${comments }" var="comment">
				<div class="pppp10 comment-content-box">
					<input type=hidden class="comment-parent" value="${comment.getParentId()}"/>
					<div id="comment-info" class="flex">
						<p id="comment-username" class="fon-bold">${comment.getNickname()}</p>
						<p id="comment-time" class="ml10">${comment.getCreatedTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm"))}</p>
					</div>
					<div class="comment-content">
						<p>${comment.getContents()}</p>
					</div>
				</div>
				<div id="content-delimeter" class="mt10 mb10"></div>
			</c:forEach>			
		</div>

	</div>

</body>
</html>