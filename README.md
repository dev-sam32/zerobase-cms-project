# [ZB] 개인 프로젝트 - 커머스 서비스 (BE)
등록된 상품들을 사용자들이 구매할 수 있도록 하는 서비스

## 💡 프로젝트 기능
- 상품
  - 상품 등록 / 수정 / 삭제
    - 상품 등록시 이름, 카테고리, 가격, 수량을 입력 받는다.
    - 관리자만 가능하도록 한다.
  - 상품 조회
    - Springd Data Jpa 에서 제공하는 Pageable을 이용하여 한페이지에 20개씩 조회가 가능하게 한다.
  - 상품 검색
    - 상품명 / 카테고리 / 상품명 + 카테고리 ...
    - QueryDSL을 사용하여 검색 기능을 구현한다.

- 회원
  - 회원 가입
    - 회원 가입시 ID(username) / 비밀번호(password) / 이름(name) / 연락처(phone)을 필수(NOT NUll)로 입력 받는다.
    - `ID` : 중복되어서는 안된다. (6글자 이상 20글자 이하)
    - `비밀번호` : 편의상 글자 수 제한만 둔다. (4글자 이상 30글자 이하)
    - `이름` : (3글자 이상 10글자 이하)
    - `연락처` : 슬래시를 포함한 문자열을 입력 받는다.(13글자 이하) ex) 010-0000-0000
  - 회원 로그인
    - 가입되어 있는 ID / PW가 일치할시 로그인이 가능하게 한다.
    - 로그인 되었을 떄, Jwt Token(Access Token)을 발급하여 인가가 필요한 기능들에 접근 가능하게 한다.
      - 편의상 Access Token만을 사용하며, Token 유효기간은 하루(24시간)로 한다.
  - 회원 로그아웃
    - Jwt Token(Token 유효기간 수정을 통해 만료)로 구현한다.
  - 회원 탈퇴
    - 편의를 위해서 영구 삭제를 우선 구현한다.
    - 회원 상태 필드를 추가하고 회원 상태를 탈퇴로 변경하며, 물리적 삭제는 일정 기간 후에 완전히 삭제되도록 구현한다.(Spring Batch?)

- 주문
  - 결제
    - 포인트 충전
    - 단건 결제
      - 구입하고자 하는 상품 수량이 상품 재고 수량을 넘겼을 때, 결제 실패해야한다.(실패시 품목과 현재 재고 수량 알림)
    - Jwt Token 인증을 통해 본인만 충전/ 결제 가능하게 한다.

- 장바구니
  - 장바구니 상품 등록 / 구매 수량 변경
  - 장바구니 상품 전체 조회
  - 장바구니 상품 전체 삭제 / 결제
  - (장바구니 상품 선택 삭제 / 결제)
  - Jwt Token 인증을 통해 본인만 가능하게 한다.

## ERD
![zerobase-cms-project_v00.png](erd%2Fzerobase-cms-project_v00.png)

## 사용 기술 스택
- Spring Boot : 3.2.5
- Java : 17
- DB : H2, MySql, (Redis)

## 🚀 Trouble Shooting
