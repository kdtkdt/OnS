$(document).ready(function() {

	// 질문 올리기 버튼 선택한 경우
	$('#question-btn').click(function() {
		window.location.href = '/qnawrite';
	});

	// 질문 게시물을 선택했을 때 query parameter 로 id 전달
	$(document).on('click', '#articles-container article', function() {
		let clickedArticle = $(this);
		let id = clickedArticle.find('.qna-id').val();
		window.location.href = `/qnapostview?id=${id}`;
	});

	$('#search-btn').click(function() {
		if ($('#search-input').val() == '') {
			alert('검색할 질문을 입력해주세요.');
		} else {
			// 검색 결과로 갱신
		}
	})
});