<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script
    src="https://code.jquery.com/jquery-3.6.4.min.js"
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
	
    <br/>

    <div id="post-box" class="ppp20">
        <!-- 게시글 내용 -->
        <div id="post-content-box" class="pppp20 mr20 ml20">
            <div>
                <h1 id="post-title" class="mb10">클러스터에서 마스터 노드를 사용자가 선택할 수 있나요?</h1>
                <p id="post-info">
                    <span id="view-count">&nbsp;2</span>
                    <span>조회수</span>
                    <span id="post-datetime">2023.5.8 13:44·&nbsp;</span>
                    <span id="username" class="fon-bold">Help&nbsp;</span>
                </p>
            </div>
            <div id="content-delimeter" class="mt10 mb10"></div>
            <div id="content" class="mt10 mb10 fon-fam-ver">
                <p>클러스터 구성에서 사용자가 마스터 노드를 직접 선택할 수 있나요?</p><p><br></p>
                <p>마스터노드를 3대 이상 구성하고, 그 중에서 선출되는 것으로 들었습니다.</p><p><br></p>
                <p>두대의 노드로 클러스터를 구성했을 때 특정 노드를 마스터노드로 지정할 수 있는지 알고 싶습니다. </p><p><br></p>
                <p>두대의 노드를 HA 구성으로 사용하려는 목적이 있기 때문에 평상시에 마스터노드 정보를 공유할 수 있도록 두대 모두 마스터노드로 설정합니다.
                이런 경우에 특정 노드를 마스터노드로 지정할 수 있을까요? </p>
            </div>
            <div class="mt20 mb20">
                <span class="tag fon-11">#Elasticsearch</span>
                <span class="tag fon-11">#Solr</span>
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
                <h3 id="comment-counter" class="ml5">3</h3>
            </div>
            <textarea id="comment-input" class="pppp20"></textarea>
            <div id="button-box">
                <button id="comment-button" class="mt20 mb10 ml10 pt5 pb5 pl20 pr20 fon-13">등록</button>
            </div>
            <!-- 더미 데이터1 -->
            <div class="pppp10">
                <div id="comment-info" class="flex">
                    <p id="comment-username" class="fon-bold">hola</p>
                    <p id="comment-time" class="ml10">2023.5.8 14:54</p>
                </div>
                <div class="comment-content">
                    <p>저는 잘 모르겠습니다.</p>
                </div>
            </div>
            <!-- 더미 데이터2 - 대댓글 -->
            <div id="content-delimeter" class="mt10 mb10"></div>
            <div class="pppp10 ml30">
                <div id="comment-info" class="flex">
                    <p id="comment-username" class="fon-bold">help</p>
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
                    <p>저도 잘 모르겠습니다.</p>
                </div>
            </div>
        </div>

    </div>
    
</body>
</html>