$(document).ready(function () {
	
    // 작성 버튼 위에 마우스 올렸을 때 검은색으로 변하게 하기
    $('#writebtn').hover(
        function () {
            $(this).css('backgroundColor', 'black');
        },
        function () {
            $(this).css('backgroundColor', '#404040');
        }
    );

//게시글 버튼 클릭시 1개 게시글 메인조회페이지로 이동
/*  $('.blog-item').click(
        function () {
			 window.location.href = "reviewpostview";
        } );//click*/
        
   //게시글 작성 버튼 클릭시 작성페이지로 이동
  $('#writebtn').click(
        function () {
           window.location.href = "reviewboardwrite";
        } );
        
        //게시글 검색 버튼 클릭시 정보 전달
  /*     $('#searchbtn').click(
        function () {
          
        } );
 */
    });