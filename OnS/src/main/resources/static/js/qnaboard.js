$(document).ready(function(){

    // 질문 올리기 버튼 선택한 경우
    $('#question-btn').click(function(){
        window.location.href = './QnABoardWrite.html?board=2';
    });

    // 게시물을 선택한 경우
    $('.blog-list').click(function(){
        window.location.href = './QnAPostView.html?board=2';
    });

    $('#search-btn').click(function(){
        if ($('#search-input').val() == '') {
            alert('검색할 질문을 입력해주세요.');
        } else {
            // 검색 결과로 갱신
        }
    })
});