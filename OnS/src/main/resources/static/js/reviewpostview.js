$(document).ready(function () {

    // 버튼 위에 마우스 올렸을 때 검은색으로 변하게 하기
    $('button').hover(
        function () {
            $(this).css('backgroundColor', 'black');
        },
        function () {
            $(this).css('backgroundColor', '#404040');
        }
    );

    $('#delete-button').click(function () {
        if (confirm("정말 삭제하시겠습니까?")) {
            // 삭제 요청
            const url = './ReviewBoard.html?board=4';
            window.location.href = url;
        }
    });

    $('#modify-button').click(function () {
        // 게시글 제목과 내용 수정 페이지로 넘겨주기

        // 제목과 글 내용 가져오기
        const title = $('#post-title').val();
        const content = $('#content').val();

        // 폼을 생성하고 데이터를 추가
        const form = $('<form method="GET" action="./ReviewModify.html"></form>');
        form.append('<input type="text" name="board" value="' + 4 + '"/>');
        // form.append('<input type="hidden" name="title" value="' + title + '"/>');
        // form.append('<input type="hidden" name="content" value="' + content + '"/>');

        // 폼을 body에 추가하고 전송
        $('body').append(form);
        form.submit();
        
    });

    let commentCounter = parseInt($('#comment-counter').text());

    // 시연용 댓글 추가 기능
    $('#comment-button').click(function () {
        const comment = $('#comment-input').val();
        const now = new Date();
        if (comment === '') {
            alert('댓글 내용을 입력해 주세요.');
            return;
        }
        $('#comment-box').append('<div id="content-delimeter" class="mt10 mb10"></div>');

        $('#comment-box').append(`<div id="comment-content-container${commentCounter}" class="pppp10">`);
        $(`#comment-content-container${commentCounter}`).append('<div id="comment-info' + commentCounter + '" class="flex">');
         //작성자 이름
        $(`#comment-info${commentCounter}`).append('<p id="comment-username" class="fon-bold">help</p>');
         //작성 시간
        $(`#comment-info${commentCounter}`).append(`<p id="comment-time" class="ml10">${now.getFullYear()}.${now.getMonth()+1}.${now.getDate()} ${now.getHours()}:${now.getMinutes()}</p>`);
        $(`#comment-content-container${commentCounter}`).append('</div>');//53번째 줄 end

        $(`#comment-content-container${commentCounter}`).append('<div id="comment-content' + commentCounter + '" class="comment-content">');
        //댓글 내용
        $(`#comment-content${commentCounter}`).append(`<div><p>${comment}</p></div>`);
        //수정, 삭제 버튼
        $(`#comment-content${commentCounter}`).append(`<div id="button-box"><button id="modify-btn">수정 </button><span>&#124;</span>
        <button id="delete-btn">삭제</button></div>`);
        
        $(`#comment-content-container${commentCounter}`).append('</div>');//60번째 줄 end
        $('#comment-box').append('</div>');//52번째 줄 end
        ++commentCounter;
        $('#comment-counter').text(commentCounter);
        $('#comment-input').val('');
    });
    
    //추천수 버튼

});