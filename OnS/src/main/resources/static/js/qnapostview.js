$(document).ready(function () {

    const urlParams = new URLSearchParams(window.location.search);
    const board = urlParams.get('board');
    let filename = '';
    
    if (board == 1 || board == 5) {

        filename = 'postviewRecruitment';

    } else if (location.href.includes('/qnapostview')) {

        filename = 'QnABoard';
        
        // 버튼 위에 마우스 올렸을 때 검은색으로 변하게 하기
        $('#button-box > button').hover(
            function () {
                $(this).css('backgroundColor', 'black');
            },
            function () {
                $(this).css('backgroundColor', '#404040');
            }
        );
    
        $('#list-button').click(function () {
            const url = `/qnaboard`;
            window.location.href = url;
        });
    
        $('#delete-button').click(function () {
            if (confirm("정말 삭제하시겠습니까?")) {
                // 삭제 요청
                const url = `./${filename}.html?board=${board}`;
                window.location.href = url;
                localStorage.removeItem('title');
                localStorage.removeItem('text');
                alert("삭제가 완료되었습니다.");
            }
        });
    
        $('#modify-button').click(function () {
            // 게시글 제목과 내용 수정 페이지로 넘겨주기
    
            // 제목과 글 내용 가져오기
            const title = $('#post-title').text();
            const content = $('#content').html().replace(/\s+/g, ' ')
                                                .replace(/<\/p>\s+<p>/g, "</p><p>")
                                                .trim();
    
            // 로컬스토리지에 게시물 데이터 저장
            localStorage.setItem('title', title);
            localStorage.setItem('text', content);
    
            // 폼을 생성하고 데이터를 추가
            const form = $('<form method="GET" action="./QnABoardWrite.html"></form>');
            form.append('<input type="text" name="board" value="' + 6 + '"/>');
            // form.append('<input type="hidden" name="title" value="' + title + '"/>');
            // form.append('<input type="hidden" name="content" value="' + content + '"/>');
    
            // 폼을 body에 추가하고 전송
            $('body').append(form);
            form.submit();
        });
    }
	
	var elements = $('.comment-parent'); // 동일한 클래스를 가진 요소들 가져오기

    elements.each(function(index, element) {
        var value = $(element).attr('value'); // value 속성의 값 가져오기

        // 대댓글이 아닌 경우 parentId가 없어 0이 되므로 0보다 큰 경우 왼쪽 마진 추가
        if (value > 0) {
            $(element).siblings('#comment-info, .comment-content').addClass('ml30');
        }
    });

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
        $(`#comment-info${commentCounter}`).append('<p id="comment-username" class="fon-bold">help</p>');
        $(`#comment-info${commentCounter}`).append(`<p id="comment-time" class="ml10">${now.getFullYear()}.${now.getMonth()+1}.${now.getDate()} ${now.getHours()}:${now.getMinutes()}</p>`);
        $(`#comment-content-container${commentCounter}`).append('</div>');
        $(`#comment-content-container${commentCounter}`).append('<div id="comment-content' + commentCounter + '" class="comment-content">');
        $(`#comment-content${commentCounter}`).append(`<div>`);
        let sentences = comment.split('\n');
        for(let sentence of sentences) {
            $(`#comment-content${commentCounter} > div`).append(`<p>${sentence}</p>`);
        }
        $(`#comment-content${commentCounter}`).append(`</div>`);
        $(`#comment-content${commentCounter}`).append('<div><a>수정</a><span>&nbsp;&#124;&nbsp;</span><a>삭제</a></div>');
        $(`#comment-content-container${commentCounter}`).append('</div>');
        $('#comment-box').append('</div>');
        ++commentCounter;
        $('#comment-counter').text(commentCounter);
        $('#comment-input').val('');
    });
});