<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/js/jquery-3.6.4.min.js" ></script>
<link href="/css/import.css" rel="stylesheet" type="text/css" />

    <title>OnS | 온라인 스터디</title>
    
<style type="text/css">
	input[name=stars]{
		margin:0;
	}
	.board-box.plus{
		align-items: stretch;
	}
</style>
</head>
<body>

	<div id="header"></div>
	<br />
	<div id="wrap">
		<form action="reviewboardwrite" method="post">
		<div class="board-box plus pppp20">
			<div id="titlearea" class="mb15">
				<input type="text" name="title" class="fon-20 pb5" placeholder="강의명을 작성해주세요"/>
			</div>
			<!-- 작성자 -->
			<!-- 강의종류 선택
			<h4 id="categoryh6" class="mb5">강의 종류 </h4>
			<select id="category" class="mb10 select">
					<optgroup label="front-end">
						<option id="javascript" selected>-- 선택하세요 --</option>
						<option id="javascript">JAVASCRIPT</option>
						<option id="css">CSS</option>
						<option id="html">HTML</option>
						<option id="react">REACT</option>
					</optgroup>
					<optgroup label="back-end">
						<option id=java>JAVA</option>
						<option id=sql>SQL</option>
					</optgroup>
				</select>-->
				<!-- 강의만족도 선택 -->
				<h4>강의 만족도</h4>
			<div id="rating" class="mb5">
				<input type="radio" name="rating" value="⭐">⭐ 
				<input type="radio" name="rating" value="⭐⭐">⭐⭐ 
				<input type="radio" name="rating" value="⭐⭐⭐">⭐⭐⭐ 
				<input type="radio" name="rating" value="⭐⭐⭐⭐">⭐⭐⭐⭐ 
				<input type="radio" name="rating" value="⭐⭐⭐⭐⭐">⭐⭐⭐⭐⭐
			</div>

			<div id="textarea">
				<textarea id="comment-input" name="contents" class="textarea pppp20">
🐥 모두에게 도움이 될 수 있도록 강의 후기 예시를 참고해 작성해주세요 🐥
						
[강의 후기 예시]
  
🐣 강의 진도율
🐣 공부한 내용
🐣 강의 개선사항
🐣 강의 추천여부
</textarea>
				<br>
				<div class="btn-box mt20">
					<input type="submit" id="savebtn" class="button ml10 pt5 pb5 pl20 pr20 fon-13" value="저장"/>
					<button id="backbtn" class="button ml10 pt5 pb5 pl20 pr20 fon-13">취소</button>
				</div>
			</div>
			
			<!--titlearea end-->
		</div>
		<!-- board-box pppp end -->
				</form>
	</div>
</body>
</html>
