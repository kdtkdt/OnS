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

- 통일된 레이아웃 안에 `질문 게시판`만의 특징을 갖는 데이터를 포함하여 게시판을 구성하였습니다.
- 키워드를 이용하여 검색할 수 있습니다.

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

- 로그인하지 않은 상태에서는 스팸글 등을 방지하기 위해 작성하지 못하도록 하였습니다.

### 비로그인 상태

![비로그인 상태 댓글/대댓글](https://github.com/kdtkdt/OnS/assets/135004614/a4f6d05d-b7dc-486a-92b2-98c1eda0351f)

### 로그인 상태

![로그인 상태](https://github.com/kdtkdt/OnS/assets/135004614/089dc8b5-e1b1-4864-82e5-c5ee29e9ee25)

### 관련 파일

- [QnAPostView.jsp](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/webapp/WEB-INF/view/QnAPostView.jsp#L93)
- [comment.js](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/js/comment.js)
- [content.css](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/css/content.css#L253-L303)
- [CommentRestController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/CommentRestController.java)
- [CommentService.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/service/CommentService.java)
- [CommentDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/CommentDAO.java)
- [CommentDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/CommentDTO.java)
- [comment-mapping.xml](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/mybatis/mapper/comment-mapping.xml)

## 3. 질문글 해결/미해결 상태 변경 및 표시 기능

질문이 해결된 경우 질문 작성자가 해결 표시를 할 수 있게 하였습니다.

### 해결 상태

![질문 해결 상태 화면](https://github.com/kdtkdt/OnS/assets/135004614/50ebeb4e-00da-4ff2-b819-3e87ee3b8955)

### 미해결 상태

![질문 미해결 상태 화면](https://github.com/kdtkdt/OnS/assets/135004614/76cb6683-1b48-4110-842f-18fafab403de)

### 관련 파일

- [QnAPostView.jsp](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/webapp/WEB-INF/view/QnAPostView.jsp#L53-L60)
- [qnapostview.js](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/js/qnapostview.js#L90-L100)
- [content.css](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/css/content.css#L309-L373)
- [QnARestController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/QnARestController.java#L100-L107)
- [QnAContentService.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/service/QnAContentService.java#L115-L117)
- [QnAContentDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/QnAContentDAO.java#L28)
- [QnAContentDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/QnAContentDTO.java#L18)
- [qnacontent-mapping.xml](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/mybatis/mapper/qnacontent-mapping.xml#L104-L106)

## 4. 질문글 태그 추가 기능 및 주간 인기 태그 기능

### 태그 추가 기능

- 질문 글 추가/수정 시 태그 추가/삭제가 가능합니다.
- 최대 5개까지 태그를 추가할 수 있습니다.
- 중복 태그는 추가할 수 없습니다.

![질문글 수정화면 내 태그 기능 화면](https://github.com/kdtkdt/OnS/assets/135004614/57af2a60-5953-4c11-ba0d-a7b4a43c81ed)

### 태그 추가 기능 관련 파일
- [QnABoardWrite.jsp](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/webapp/WEB-INF/view/QnABoardWrite.jsp#L46-L51)
- [qnaboardwrite.js](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/js/qnaboardwrite.js#L38-L105)
- [content.css](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/css/content.css#L202-L214)
- [QnABoardController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/QnABoardController.java#L84)
- [QnAContentService.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/service/QnAContentService.java#L95-L104)
- [TagDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/TagDAO.java)
- [TagDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/TagDTO.java)
- [QnAContentDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/QnAContentDTO.java#L20)

### 주간 인기 태그 기능

- 일주일 동안 작성된 질문글에 포함된 태그를 누적 갯수가 가장 많은 순으로 출력 합니다.
- 태그를 선택하여 검색할 수 있습니다.

![주간 인기 태그 중 JPA 선택 결과](https://github.com/kdtkdt/OnS/assets/135004614/27d98cfc-4754-4b6e-b005-f2fdacba0c9b)

### 주간 인기 태그 기능 관련 파일
- [QnABoard.jsp](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/webapp/WEB-INF/view/QnABoard.jsp#L107-L116)
- [qnaboard.js](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/js/qnaboard.js#L36-L56)
- [content.css](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/static/css/content.css#L161-L173) 주간 인기 태그를 담고있는 컨테이너용 css 표시, 이외 태그 관련 css 는 태그 추가 기능 관련 파일에 추가한 것과 동일
- [QnABoardController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/QnABoardController.java#L39-L48)
- [QnAContentService.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/service/QnAContentService.java#L33-L39) 태그 검색 기능
- [QnAContentService.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/service/QnAContentService.java#L106-L109) 인기 태그 불러오기 기능
- [QnAContentDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/QnAContentDAO.java)
- [TagDAO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dao/TagDAO.java#L16)
- [TagDTO.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/dto/TagDTO.java)
- [tag-mapping.xml](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/resources/mybatis/mapper/tag-mapping.xml#L26-L34)

## 5. 데이터 모델 설계 및 ERD 작성

![ERDCLOUD](https://github.com/kdtkdt/OnS/assets/135004614/d4e6dafd-be1d-4983-8b93-826f4481f6c2)

# 문제점

## 1. REST API 에 모두 동사 사용, 수정에 모두 PUT 메서드 사용

- JSON을 주고받기만 하면 REST API라 잘못 알고있었습니다.
- REST API 권장 사항으로 동작은 HTTP 메서드로 나타내고, resource를 명사로 사용할 것을 권장하고 있지만, 당시 지식이 없어 모두 동사로 하였습니다.
- 수정은 PUT 메서드만 알고 PATCH 메서드는 존재 조차 모르고 있었습니다.

[QnARestController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/QnARestController.java)

```java
@PostMapping("/api/qna/write")
@PutMapping("/api/qna/modify")
@DeleteMapping("/api/qna/delete")
@PutMapping("/api/qna/read")
@PutMapping("/api/qna/solve")
```

- 위에서 대표적인 문제로 @PutMapping("/api/qna/read") 를 봤을 때, 뭘 하겠다는 건지 전혀 파악이 안되는 것을 알 수 있습니다. 실제로는 조회수를 업데이트합니다.
- @PutMapping("/api/qna/solve") 은 질문 해결여부를 수정합니다. PUT과 DELETE로 나누거나, PATCH 메서드로 게시글의 부분 정보로서 수정을 하는게 더 옳았다고 생각됩니다.

## 2. Controller, Service, DAO 에서 모두 하나의 DTO 사용

- Controller 나 Service에서 사용하기 위해 별도의 DTO 파일을 생성하는게 불필요하게 복잡하다고 생각했었습니다.
- 이로 인해 아래와 같이 단 하나의 값을 변경하는데, 불필요한 null properties 와 함께 값을 반환했습니다.

[QnARestController.java](https://github.com/kdtkdt/OnS/blob/%EC%A0%95%EC%84%B1%EA%B5%AD/OnS/src/main/java/com/ons/study/controller/QnARestController.java#L100-L107)

```java
// 질문 해결 여부 변경
	@PutMapping("/api/qna/solve")
	public ResponseEntity<QnAContentDTO> updateSolve (@RequestBody QnAContentDTO qnaContent, HttpSession session) {
		qnaContentService.updateQnaContentSolved(qnaContent.getId());
		boolean isSolved = !qnaContent.isSolved();
		qnaContent = new QnAContentDTO();
		qnaContent.setSolved(isSolved);
		return ResponseEntity.ok(qnaContent);
	}
```

업데이트 중입니다...