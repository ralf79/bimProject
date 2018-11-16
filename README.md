# bimProject

> http://www.bridgeimpact.com/ 의 리뉴얼 프로젝트입니다.  

## Test Bench
http://liante0904.asuscomm.com:9090/bimProject/

## Stack


### Front-end
- JSP
- jQuery 1.11.2
- CSS
- Bootstrap 3

### Server
- Java 8 & Spring Framework 3
- Linux (Synology)
- MySQL (MariaDB)
- Tomcat 8
- Docker
- ~~AWS (Expected)~~

## About
### Complete Function
- 모바일 대응(반응형 웹)
- 회원 주요기능(CRUD)
- 게시판 게시글, 댓글 주요기능(CRUD) 
- 검색 및 페이징
- 게시글 작성시 파일 기능(첨부 및 삭제)

### ChangeLog
- 회원 탈퇴시 기존 패스워드 일치 여부 확인 추가(컨트롤러) 
- 레이아웃 변경(Table 태그 제거)
- Front-end 데이터 제한 및 유효성 처리(회원, 게시글, 댓글 동작시)
- 회원가입시 이메일 인증 시스템(미 인증 로그인시도시 제한)
- 글 작성 및 수정요청 로직 변경(ajax to submit, 데이터 제한)
- 게시글 작성시 위지윅 적용(WYSIWYG)
- 글 목록에서 댓글 갯수 표시 기능추가
- 메인 페이지 레이아웃 추가(게시판 최근 글)
- 댓글 기능 구현 및 개선(비동기 및 동적)
- 검색, 페이징 기능 구현
- 게시판, 게시글 제한처리(비공개, 삭제 처리된 게시굴 및 게시판)
- 파일 IO (DB반영)
- DB암호화 (회원가입 & 수정, 로그인 완료, 클래스 생성 필요)
- Bootstrap 적용(PC, 모바일 반응형 웹 적용)

### Testing & Working
- 회원 가입후 이메일 인증 승인 로직구현 & 중복처리
- 관리자 인터셉터 구현(구체화), 게시판 공개여부 토글처리(메소드 통합)
- 컨트롤러, 서비스(비즈니스)로직 분리 & 정리


## TODOList
- SSL적용
- 테스트 중인 사이드바 적용
- 게시판 변경(기존의 사이트)
- 컨텐츠 채우기
- 디자인 색깔톤 대폭 변경
- 회원 정보 수정 페이지 개편 및 재 작성
- 이메일 인증메일 수신하여 인증 승인처리 구체화(테스트중)
- 데이터를 반영시 무결성 처리(at controller)
- 아이디 비밀번호 찾기 구현
- 회원 이메일 주소 유니크 처리, 가입시 submit전 데이터 유효성 체크
- 글 작성, 수정시 첨부파일 저장 위치 로직변경(Test or Live)
- 사용자에게 에러 페이지 및 알림처리
- openJDK 전환

## holdingList
- ~공동구매 기능(온라인 신청)~
- ~접속자의 아이피, 접속기록, 저장 및 로그인 횟수 차단~
- ~스프링 트랜잭션 적용하기(for 이메일 인증, 소셜회원가입) + 회원가입 로직 개선 및 기능 추가~

## TODO Bugfix
- 글 수정페이지 접근 후, 세션 만료시 NullPoint처리 
- 회원가입 후 이메일 인증처리 메일 발송 실패시 에러처리(재발송 혹은 알림) 
