# BLOG 백엔드

# 1. Security
1. Basic Authentication
    1. 사용자 이름, 비밀번호 Base64 인코딩 -> 헤더 포함하여 전송
    2. 안전하지 않음
   3. Authorization: Basic ~
2. Bearer Token
   1. 헤더에 토큰을 전송 포함하여 전송
   2. JWT를 사용하여 인증
   3. 간단한 방식, 상태유지x, 확장성 높음
   4. 토큰 노출 위험, 토큰 관리 필요
   5. Authorization: Bearer ~
3. OAuth
   1. 토큰 기반 사용자가 자격을 증명 x 미리 인증 받아 토큰 사용
   2. 위 토큰을 이용하여 API 요청 방식 OAuth 2.0
   3. ex) google, facebook

* JWT (JSON Web Token) : 클레임이라 불리는 정보를 JSON 형태로 전송하기 위한 토큰
  * 인증과 정보 교환에 사용, 서명이 되어있어 신뢰성 확보
  * Header: 토큰의 타입과 사용된 알고리즘 정보 (Base64 인코딩)
  * Payload: 클레임 정보, 대상, 발행자, 만료 시간 등 정보 포함 (Base64 인코딩)
  * Signature: Header와 Payload, Secret key를 사용하여 생성된 서명 포함