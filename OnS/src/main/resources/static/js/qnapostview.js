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
    
});