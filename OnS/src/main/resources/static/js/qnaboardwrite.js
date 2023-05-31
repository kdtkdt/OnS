$(document).ready(function(){
    // query 가져오기
    const urlParams = new URLSearchParams(window.location.search);
    const board = urlParams.get('board');
    let filename = '';

    // 에디터 초기화
    let quill = new Quill('#editor', {
        theme: 'snow'
    });

    if (board == 2) {
        // 질문 올리기 버튼으로 진입한 경우
        const title = "질문을 작성해주세요."
        $('#title').attr('placeholder', title);
        let text = 
        `[질문 내용 예시]
        - 학습 관련 질문을 남겨주세요. 
        - 상세히 작성하면 더 좋아요!
        - 먼저 유사한 질문이 있었는지 검색해보세요.
        - 서로 예의를 지키며 존중하는 문화를 만들어가요.`

        quill.setText(text);
        filename = 'QnABoard';
    } else if (board == 6) {
        // 수정 버튼으로 진입한 경우

        // 화면 초기화
        $('#title').val(localStorage.getItem('title'));
        quill.root.innerHTML = localStorage.getItem('text');

        // 이동 대상 설정
        filename = 'QnAPostView';

        // 기존 태그 추가하기
        $('#tag-box').append('<span class="tag fon-11">#Elasticsearch X</span>');
        $('#tag-box').append('<span class="tag fon-11">#Solr X</span>');
        if ($('#tag-box').children().length > 0) {
            $('#tag-box').addClass('mt20 mb20');
        }
    }

    // 태그 추가 시 삭제 대상 목록 갱신
    function refreshDeleteTagList() {
        $('.tag').click(function(){
            $(this).remove();
        })
    }

    // 질문 게시판 태그 입력, 삭제 기능
    if (board == 2 || board == 6) {
        // 태그 입력기
        $('#tag-editor').append(`<div>
        <input type="text" id="tag-input" class="fon-15 ml10 mt20 mb20 input-box" placeholder="추가하려는 태그를 입력하고 엔터키를 눌러주세요."></input>
        </div>`);

        $("#tag-input").keypress(function(event) {
            if (event.which === 13) {
                // 엔터키 입력 감지
                
                if ($('#tag-input').val() == '') {
                    return;
                }

                if ($('#tag-box').children().length == 0) {
                    $('#tag-box').addClass('mt20 mb20');
                }

                $('#tag-box').append(`<span class="tag fon-11">#${$("#tag-input").val()} X</span>`);
                $('#tag-input').val('');
                refreshDeleteTagList();
            }
        });

        // 태그 선택시 삭제 기능
        refreshDeleteTagList();
    }

    

    quill.focus();

    //save 버튼 클릭시 입력값 저장, 창 이동
    $("#save").on('click', function(){
        let content = quill.getText().replace(/\s+/g, '');
        if ($('#title').val() == '' || content == '') {
            alert('제목 혹은 내용이 작성되지 않았습니다.');
            return;
        }

        //시간 저장
        let nowTime = new Date().toLocaleString();
        localStorage.setItem("time", nowTime);
        
        //제목, 내용 입력값 저장
        localStorage.setItem("title", $("#title").val());
        localStorage.setItem("text", quill.root.innerHTML);
        
        //넘어가는 화면 지정(목록 화면)?
        location.href = `./${filename}.html?board=${board}`;
    });
    
    //delete 버튼 클릭시 이전 페이지(게시글 조회 화면) 이동
    $("#delete").on('click', function(){
        location.href = `./${filename}.html?board=${board}`;
    });

    
})