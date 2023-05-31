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
        window.location.href="reviewboardwrite";
        } );
        
 
    });
