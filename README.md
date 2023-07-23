# OnS

- 기획 의도: 온라인 클래스 관련 정보 공유, 스터디그룹 모집 및 그룹 전용 온라인 공간 제공
- 기간 및 인원: 10일 / 3명

- 기술 스택
  - Backend: Java 17, Spring Boot 3, JSP, MyBatis 3, MySQL 8
  - Frontend: JavaScript, jQuery

- 구현 사항
  1. 질문 게시판
  2. 게시판 공용 댓글/대댓글 기능
  3. 질문글 해결/미해결 상태 변경 및 표시 기능
  4. 질문글 태그 추가 기능 및 주간 인기 태그 기능
  5. 데이터 모델 설계 및 ERD 작성

# 구현 사항

## 1. 질문 게시판

통일된 레이아웃 안에 `질문 게시판`만의 특징을 갖는 데이터를 포함하여 게시판을 구성하였습니다.

![질문 게시판 화면](https://github.com/kdtkdt/OnS/assets/135004614/a3c089e5-1663-4adc-b3f6-67355751876e)

### 관련 파일
- [QnABoard.jsp](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/webapp/WEB-INF/view/QnABoard.jsp)
- [qnaboard.js](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/js/qnaboard.js)
- [content.css](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/css/content.css#L145)
- [QnABoardController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/QnABoardController.java#L29)
- [QnAContentService.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/service/QnAContentService.java)
- [QnAContentDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/QnAContentDAO.java)
- [QnAContentDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/QnAContentDTO.java)
- [qnacontent-mapping.xml](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/mybatis/mapper/qnacontent-mapping.xml)
- [TagDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/TagDAO.java)
- [TagDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/TagDTO.java)
- [tag-mapping.xml](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/mybatis/mapper/tag-mapping.xml)

## 2. 게시판 공용 댓글/대댓글 기능

로그인하지 않은 상태에서는 스팸글 등을 방지하기 위해 작성하지 못하도록 하였습니다.

### 비로그인 상태

![비로그인 상태 댓글/대댓글](https://github.com/kdtkdt/OnS/assets/135004614/a4f6d05d-b7dc-486a-92b2-98c1eda0351f)

### 로그인 상태

![로그인 상태](https://github.com/kdtkdt/OnS/assets/135004614/089dc8b5-e1b1-4864-82e5-c5ee29e9ee25)

### 관련 파일
- [QnAPostView.jsp](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/webapp/WEB-INF/view/QnAPostView.jsp#L93)
- [comment.js](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/js/comment.js)
- [CommentRestController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/CommentRestController.java)
- [CommentService.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/service/CommentService.java)
- [CommentDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/CommentDAO.java)
- [CommentDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/CommentDTO.java)
- [comment-mapping.xml](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/mybatis/mapper/comment-mapping.xml)

