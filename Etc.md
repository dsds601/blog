# 프로젝트 중 알게된 내용
1. @Value 어노테이션으로 설정파일에 값을 주입시킬때 static 변수에 경우 잘못된 결과가 나올 수 있다<br>그럴 경우 setter 메소드를 이용하여 값을 넣으면 된다.
```java

```

1. Jwt Claim 기반 토큰의 개념
   * Claim 기반이란 사용자에 속성을 이야기한다. 토큰 자체가 사용자에 정보인 방식 Jwt는 이 Claim을 <br>
   JSON 이용하여 정의한다.
```json
{
  "ID": "ghun",
  ,"role": "admin"
}
```

