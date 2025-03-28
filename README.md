<br>

# 👕 Clother (Style Sharing Community) 👚

<img src="https://github.com/user-attachments/assets/8e8c7919-f4dd-45b0-9c94-faab9ea0231a">
<img src="https://github.com/user-attachments/assets/14df180e-8b17-4ba1-a5a5-573c32d46d33">

<br><br><br>

---

# 🚀 Team microsoftwo

| <img src="https://github.com/user-attachments/assets/9e5c3e83-7f0d-41ca-816c-8133409537e1" width="200"> | <img src="https://github.com/user-attachments/assets/8f52dde1-3590-4e2f-880d-32098f5d098a" width="200"> | <img src="https://github.com/user-attachments/assets/0b56df7f-c48d-4975-abff-aeb51af8f2da" width="200"> | <img src="https://github.com/user-attachments/assets/f5cbf6cc-ff54-4720-be15-390182415083" width="200"> | <img src="https://github.com/user-attachments/assets/1d2619c6-f467-485e-9d90-14c7c43bc316" width="200"> |
| :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: |
|                                                 김기종                                                  |                                                 조윤태                                                  |                                                 신민경                                                  |                                                 황수민                                                  |                                                 이예원                                                  |
| [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/rrangeess) |  [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/cxzaqq)   |  [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/mmmv41)   | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/emily9949) |  [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/oni128)   |

<br><br>

---

# 📋 목차

<a href="#1">📁 1. 프로젝트 기획</a>

<a href="#1-1">1-1. 배경 및 필요성</a>

<a href="#1-2">1-2. 주요 기능</a>

<a href="#2">🔎 2. DDD (Domain-Driven Design) </a>

<a href="#2-1">2-1. DDD (Event-Storming) </a>

<a href="#2-2">2-2. DDD (Context-Map) </a>

<a href="#3">⚙️ 3. 프로젝트 설계 </a>

<a href="#3-1">3-1. 물리 모델링 (ERD) </a>

<a href="#3-2">3-2. MSA 아키텍쳐 </a>

<a href="#3-3">3-3. REST API 설계 (Swagger) </a>

<a href="#3-4">3-4. Redis 를 활용한 JWT 토큰 관리 </a>

<a href="#4">🎮 4. 테스트 결과 </a>

<a href="#4-1">4-1. 단위 테스트 결과 </a>

<a href="#4-2">4-2. API 테스트 </a>

<a href="#5">✍🏻 5. 문서 </a>

<a href="#5-1">5-1. 요구사항 명세서 </a>

<a href="#5-2">5-2. WBS (Work Breakdown Structure) </a>

<a href="#6">🛠 6. 기술 스택 </a>

<a href="#7">🫡 7. 동료평가</a>

<br><br><br>

---

# <p id="1">📁 1. 프로젝트 기획</p>

### <p id="1-1">1-1. 배경 및 필요성</p>

기존 서비스에서 의류를 포함한 헤어, 액세사리를 아우르는 스타일링 정보를 한번에 얻는 것이 매우 어렵다. 쇼핑 앱은 보통 의류 정보만 제공하며, 헤어스타일과 메이크업 제품 정보까지 연결되지 않는다.
사용자는 원하는 스타일을 찾으면 직접 댓글로 질문하거나 추가 검색을 해야 하는 불편함이 있다. 기존 스타일 공유 서비스도 한계를 가진다. 예를 들어, 온더룩은 의류 코디만 제공하고, 룩업은 남성 코디 위주이며, 인스타그램은 스타일링 정보를 체계적으로 제공하지 않는다.
이를 해결하기 위해 ‘Clother’ 스타일링 공유 서비스를 개발했다. 사용자는 스타일 사진을 보고 헤어샵, 메이크업 제품, 의류 브랜드 정보를 한 번에 확인할 수 있으며, 같은 아이템을 활용한 다양한 코디 사례도 찾아볼 수 있다.
또한, 팔로우한 유저의 스타일 변화 및 방문한 헤어샵 정보도 확인할 수 있어 보다 편리한 스타일링 경험을 제공한다.

### <p id="1-2">1-1. 주요 기능 </p>

- 코디뿐만 아니라 헤어, 메이크업, 악세서리까지의 스타일링을 공유할 수 있는 SNS

- 사용자는 자신이 원하는 스타일의 포스팅을 선택하고, 포스팅에 달린 태그를 통해 제품 정보 알 수 있고, 구매링크를 통해 바로 구매 혹은 예약처까지 연결될 수 있다.

- 포스팅 시에는 링크, 등록된 상품 등을 태그로 사용할 수 있고 원하는 상품이 없을 시 상품 등록 신청이 가능하다.

- 훈수 게시판을 통해 자신의 스타일링에 대한 피드백을 받을 수 있다.
  좋아요, 댓글 등 SNS의 기본적인 기능

<br><br>

---

# <p id="2">🔎 2. DDD (Domain-Driven Design)</p>

### <p id="2-1">2-1. DDD (Event-Storming)</p>

![KakaoTalk_Photo_2025-03-26-17-32-12](https://github.com/user-attachments/assets/11540776-bc6f-41bd-bc50-08364ce95aaa)

### <p id="2-2">2-2. DDD (Context-Map) </p>

![마이크로소프투-2](https://github.com/user-attachments/assets/171a896c-2645-4830-8e8b-283c8d3a420b)

<br><br>

---

# <p id="3">⚙️ 3. 프로젝트 설계</p>

### <p id="3-1">3-1. 물리 모델링 (ERD)</p>

<img width="949" alt="스크린샷 2025-03-26 15 32 07" src="https://github.com/user-attachments/assets/49a73250-0d5b-4b0f-a478-e53562cf5938" />

### <p id="3-2">3-2. MSA 아키텍쳐 </p>

![image](https://github.com/user-attachments/assets/21b8d5d9-acf6-44f7-8cba-ba36a588056a)
![msa](https://github.com/user-attachments/assets/b67bf7bd-a623-4db1-ba1f-ddb13413db21)

<br>

### <p id="3-3">3-3. 📚 API 명세서 </p>

<details>
    <summary>user-service</summary>
    <div markdown="1">
      ![user-service-swagger](https://github.com/user-attachments/assets/2372f030-ffee-4724-8ee5-4464965793c3)
    </div>
</details>

<details>
    <summary>core-service</summary>
    <div markdown="1">
      ![core-service-swagger](https://github.com/user-attachments/assets/423c352f-a830-4b8e-8c52-c29c21ff2390)
    </div>
</details>

<br>

### <p id="3-4">3-4. 🧱 Redis를 활용한 이메일 인증 </p>

회원가입 시 이메일로 전송되는 인증 코드는 일정 시간이 지나면 자동으로 무효화되어야 하며, 서버에 불필요한 데이터가 남지 않아야 한다.

따라서 Redis의 TTL(Time To Live) 기능을 사용하여 인증 번호를 저장하고, 5분이 지나면 자동으로 만료되도록 구성하였다.

<br>

### 📥 1) 인증 절차

<details>
    <summary>인증 절차</summary>
    <div markdown="1">
      <br>
        1. 사용자가 이메일 입력 후 인증 요청<br>
        2. 서버에서 6자리 인증 코드 생성<br>
        3. Redis에 인증 코드 저장 (TTL: 5분)<br>
        4. 사용자 이메일로 인증번호 발송 (SMTP 사용)<br>
        5. 사용자가 인증번호를 입력하여 검증 요청<br>
        6. Redis에서 이메일 키로 인증번호 조회<br>
        7. 인증 성공 또는 실패 판단
    </div>
</details>

<br>

### 🕑 2) TTL 적용 구조 설명

<details>
    <summary>TTL 적용 구조 설명</summary>
    <div markdown="1">
<br> 
      
1) 인증 코드의 유효 시간 설정

```java
spring:
  mail:
    auth-code-expiration-millis: 300000  # 5분
```

<br>

2. 이메일 인증번호를 Redis에 저장할 때 TTL로 설정

```java
@Value("${spring.mail.auth-code-expiration-millis}")
private long authCodeExpirationMillis;
```

<br>

3. RedisUtil 클래스 내 TTL 적용 메서드

```java
public void setDataExpire(String key, String value,
                              long duration) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Duration expireDuration = Duration.ofMinutes(duration);
        valueOperations.set(key, value, expireDuration);
    }
```

이 TTL(Time To Live)이 적용된 키는 해당 시간 이후 자동으로 만료되고 삭제된다.

</div>

</details>

<br>

### 👍🏻 3) TTL 사용 후 효과

<details>
    <summary>TTL 사용 후 효과</summary>
    <div markdown="1">
        <br>1. 설정된 TTL이 지나면 인증번호는 자동 삭제되어, 불필요한 데이터 제거 가능. <br>
        2. 인증번호는 일시적 데이터이므로, 디스크 기반 RDB 대신 인메모리 Redis에서 빠르게 처리 가능.
    </div>
</details>

<br>

### <p id="3-5">3-5. ☄️ Redis 이용 트러블 슈팅 </p>

<img width="1180" alt="image" src="https://github.com/user-attachments/assets/963ad2b7-1c8e-43bf-993a-7ba8f8ed0e4b" />

<br>

#### 🔑 이메일을 Key로, 인증 코드를 Value로 둔 이유

<details>
    <summary>설명</summary>
    <div markdown="1">
    <br>
    📌 1. 이메일은 유일한 식별자이기 때문

- 회원가입 또는 인증 과정에서 이메일은 사용자를 유일하게 식별할 수 있는 정보이다.
- Redis는 Key-Value 구조이기 때문에, 유일한 값을 key로 사용해야 나중에 덮어쓰거나 충돌이 나지 않음.
- 그래서 이메일 → 인증코드 구조로 저장하면, 같은 사람이 다시 인증 요청을 할 때 기존 인증 코드를 덮어쓰기도 쉽고, 빠르게 조회할 수 있다.

📌 2. Value인 인증 코드는 자주 바뀜

- 인증 코드는 6자리 숫자이고 5분이 지나면 사라진다.
- 따라서 Redis의 TTL(Time-To-Live) 기능을 써서 저장해두고 일정 시간 후 삭제되도록 관리하였다.
</div>
</details>

<br><br>

---

# <p id="4">🎮 4. 단위 테스트</p>

### <p id="4-1">4-1. 단위 테스트 결과 </p>

<details>
    <summary>테스트 결과 확인하기</summary>
    <div markdown="1">  
      <img width="1141" alt="댓글생성" src=https://github.com/user-attachments/assets/33e71cb6-d3e1-4574-bf55-d81c0259d1c0 />
      <img width="1141" alt="특정게시글조회" src=https://github.com/user-attachments/assets/b8319b3f-641c-4500-bd28-2c4cc1c960d2 />
      <img width="1141" alt="피드조회" src=https://github.com/user-attachments/assets/c812d542-6af2-458a-82ab-84f18144d06e />
      <img width="1141" alt="하위카테고리검색" src=https://github.com/user-attachments/assets/8404292e-7a5f-4d13-9568-605663d1c7f5 />
      <img width="1141" alt="회원가입" src="https://github.com/user-attachments/assets/38f07e02-c7d1-434a-bcbd-21f706de7acc" />
    </div>
</details>

### <p id="4-2">4-2. API 테스트 </p>

<details>
    <summary>테스트 결과 확인하기</summary>
    <div markdown="1">
    <details>
         <summary>회원 도메인 테스트 결과 확인하기</summary>
                    <summary>인증 번호 전송</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/ef8f8efc-fd62-4958-9439-c38b88db12e5>
                    <summary>인증 번호 검증</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/e078de72-5973-4408-8339-dcad4411c783>
                    <summary>회원 가입</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/210f01ac-43fa-4282-8811-ba2567023ddb>
                    <summary>로그인</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/2838e7e3-78ab-4e3b-94a6-a02f1d097d75>
                    <summary>토큰 미포함 요청</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/a52c71c7-1b9f-4fad-9180-9ae1a060673c>
                    <summary>토큰 포함 요청</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/004bac3a-2bfa-400f-83a4-54af53b04170>
    </details>
     <details>
        <summary>포스팅 도메인 테스트 결과 확인하기</summary>
                    <summary>포스팅 등록</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/7a066c54-2de6-44cc-acbb-05cf9615edd4>
                    <summary>포스팅 조회</summary>
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/714f467a-1507-40bf-8d9d-5c1bf310ad98>
     </details>
      <details>
          <summary>훈수 게시판 도메인 테스트 결과 확인하기</summary>
                    <details>
                      <summary>훈수 게시물 등록</summary>
                      <img width="1400" alt="게시물 등록" src="https://github.com/user-attachments/assets/0c9b2556-6ddb-4157-91db-82364666bb05">
                    </details>
                    <details>  
                      <summary>훈수 게시물 수정</summary>
                            <img width="1400" alt="게시물 수정" src="https://github.com/user-attachments/assets/d4e308a0-ced9-4c55-b038-a740545bf679">
                    </details>
                    <details>
                    <summary>훈수 게시물 삭제</summary>
                          <img width="1400" alt="게시물 삭제" src="https://github.com/user-attachments/assets/a465a856-ac17-40c9-855c-71b2b7f0135e" >
                    </details>
                    <details>
                    <summary>훈수 게시판 최신순(기본)조회 - 사용자</summary>
                          <img width="1400" alt="게시판 최신순 조회" src="https://github.com/user-attachments/assets/84757fed-da97-464e-b8f2-a636a58f962a" />
                    </details>
                    <details>
                    <summary>훈수 게시판 좋아요순 조회 - 사용자</summary>
                          <img width="1400" alt="게시판 좋아요순 조회" src="https://github.com/user-attachments/assets/b03d2d95-b1a1-4e6a-a1f3-74dd8a520e97" />
                    </details>
                    <details>
                    <summary>훈수 게시판 키워드별 조회 - 사용자</summary>
                          <img width="1400" alt="키워드별 조회" src="https://github.com/user-attachments/assets/16c564d6-b8ab-4449-be9f-8414fc627e9a" />
                    </details>
     </details>
      <details>
          <summary>상품 도메인 테스트 결과 확인하기</summary>
                  <summary>상품 등록 신청
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/44a37510-ca7f-41bd-9ca4-085fe1953816>
                  </summary>
                  <summary>상품 등록 신청 삭제
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/ac9a3915-6395-48c8-9555-b637092da3b7>
                  </summary>
                 <summary>상품 등록 신청 수정
                          <img width="1400" alt="image" src="https://github.com/user-attachments/assets/19b7f83c-ca08-4545-b07d-933c043e393b">
                  </summary>
                  <summary>상품 등록 신청 목록 조회
                          <img width="999" src="https://github.com/user-attachments/assets/9221f6d6-39ce-4010-ad8d-f262e7250092" />
                  </summary> 
                  <summary>카테고리별 상품 목록 조회
                        <img width="990" src="https://github.com/user-attachments/assets/1463d44a-8d39-49a5-afdc-df0573e50bc4" />
                  </summary>
                   <summary>하위 카테고리 목록 조회
                         <img width="989" src="https://github.com/user-attachments/assets/a1a3298d-ae03-4cb3-ae14-2770aceb8dfb" />
                  </summary> 
                  <summary>상품 상세 페이지 조회
                          <img width="1007" src="https://github.com/user-attachments/assets/bbe14ffa-fe17-4cc3-91b7-e3a7645572db" />
                  </summary> 
     </details>
       <details>    
          <summary>좋아요 도메인 테스트 결과 확인하기</summary>
                  <summary>좋아요 등록
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/a9c5438e-d2d2-4bcb-9b47-9ab3f0fe34f0>
                  </summary>
                  <summary>좋아요 취소
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/8a4fe730-8c62-44af-9442-aa0f8f9fdd57>
                  </summary>
                  <summary>회원 좋아요 내역 조회
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/cebae2c7-8e18-426e-a8c5-75cbdaad8b9e>
                  </summary>
                  <summary>좋아요 여부 조회
                          <img width="1400" alt="image" src=https://github.com/user-attachments/assets/077e600a-22c8-4427-9e0f-af910739473b>
                  </summary>
     </details>
      <details>
        <summary>댓글 도메인 테스트 결과 확인하기</summary>
                  <summary>댓글 등록
                        <img width="1400" alt="image" src=https://github.com/user-attachments/assets/083b74fe-5565-4fc2-a2c8-c819c0d24bf3>
                  </summary>
                  <summary>댓글 삭제
                        <img width="1400" alt="image" src=https://github.com/user-attachments/assets/dd8168cd-13e4-4fb5-b04a-6977b943be96>
                  </summary>
                  <summary>댓글 조회
                        <img width="1400" alt="image" src=https://github.com/user-attachments/assets/82ae05d4-c5e4-4449-afae-a5c6faf802a9>
                  </summary>
      </details>
    </div>

</details>
<br><br>

---

# <p id="5">✍🏻 5. 문서 </p>

### <p id="5-1">5-1. 📙 요구사항 명세서 </p>

[[🔗요구사항 명세서 Link]](https://docs.google.com/spreadsheets/d/1HQYulWkDctMpm4mhM3wYKbtAY3fCOOigEeM-M-q0jlg/edit?gid=269659385#gid=269659385)
<br>

<img width="783" alt="image" src="https://github.com/user-attachments/assets/96815989-ef5b-4b72-a3cb-ea1563a0188b" />

### <p id="5-2">5-2. 🗓️ WBS (Work Breakdown Structure) </p>

[[🔗 WBS Link]](https://docs.google.com/spreadsheets/d/1HQYulWkDctMpm4mhM3wYKbtAY3fCOOigEeM-M-q0jlg/edit?gid=393359725#gid=393359725)

<img width="1291" alt="image" src="https://github.com/user-attachments/assets/d46f9ea3-64a6-4529-a3e5-dee22989bd26" />

<br><br>

---

# <p id="6">🛠 6. 기술 스택 </p>

### 언어

![Java](https://img.shields.io/badge/Java-007396?style=plastic&logo=java&logoColor=white)

### 프레임워크

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=plastic&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=plastic&logo=spring-boot&logoColor=white)
![Spring JPA](https://img.shields.io/badge/JPA-6DB33F?style=plastic&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=plastic&logo=hibernate&logoColor=white)
![MyBatis](https://img.shields.io/badge/MyBatis-B5E7A0?style=plastic&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=plastic&logo=spring-security&logoColor=white)

### 라이브러리

![JWT](https://img.shields.io/badge/JWT-000000?style=plastic&logo=json-web-tokens&logoColor=white)

### 도구

- 에디터
  ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ-000000?style=plastic&logo=intellij-idea&logoColor=white)
- 빌드
  - ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=plastic&logo=Gradle&logoColor=white)

### 데이터베이스

![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=plastic&logo=mariadb&logoColor=white)

### 명세

![Postman](https://img.shields.io/badge/Postman-FF6C37?style=plastic&logo=postman&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=plastic&logo=swagger&logoColor=white)

### ETC

### 버전 관리

![Git](https://img.shields.io/badge/git-%23F05033.svg?style=plastic&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=plastic&logo=github&logoColor=white)

### 소통

![Notion](https://img.shields.io/badge/Notion-%23000000.svg?style=plastic&logo=notion&logoColor=white)

<br><br>

---

# <p id="7">🫡 7. 동료평가 </p>

<details>
<summary>동료 평가 확인하기</summary>
<div markdown="1">

#### ABOUT [김기종](https://github.com/rrangeess)

|  FROM  | COMMENT                                                                                                                                                                                                                                                                                                              |
| :----: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 조윤태 | 묵묵히 자신의 역할을 수행하며 책임감 있게 맡은 부분을 구현해내는 모습이 인상적이었습니다. 모르는 부분이 있을 때도 혼자 해결하고 넘어가는 것이 아니라, 적극적으로 의견을 공유하며 더 나은 방향을 고민하는 태도가 돋보였습니다. 이러한 자세는 좋은 개발자가 갖춰야 할 중요한 자질이며, 팀원들에게도 귀감이 되었습니다. |
| 신민경 |                                                                                                                                                                                                                                                                                                                      |
| 황수민 | 먼 거리에도 불구하고 대면 회의에 적극적으로 참여하려는 노력에 감탄했습니다. 체력적으로 힘들었을 텐데도 밝은 태도로 분위기를 이끌어주신 덕분에 팀원들 모두 끝까지 집중할 수 있었습니다. 특히, 발표 직전까지도 더 나은 발표를 위해 고민하고 구성해주신 덕분에, 더욱 짜임새 있는 발표 자료를 완성할 수 있었습니다. 또한, 팀원들 간의 이해도가 다를 때 기종님께서 개념을 명확하게 정리해주신 덕분에 모호한 부분을 확실히 짚고 넘어갈 수 있었습니다. 개발 과정에서도 맡은 역할을 철저히 수행해주셔서 프로젝트에 큰 도움이 되었습니다! |
| 이예원 | 맡은 업무의 다양한 기능을 묵묵히 끝까지 책임감 있게 수행하는 모습이 인상 깊었습니다. 그 덕분에  완벽한 테스트코드가 나온 것 같아요 ! 하기 싫은 일이나 어려운 일이 생겼을 때 먼저 나서서 시도해보려는 적극적인 태도도 팀에 큰 도움이 되었고 회의 중간중간 핵심 내용을 정리해줌으로써 팀원들의 이해를 돕는 모습도 굉장히 도움이 되었던 것 같아요 무엇보다 집이 가장 먼 상황에서도 매번 직접 만나 회의에 참여해주시고, 늦게까지 남아 함께 하는 모습에 정말 감사했어요. 그런 책임감 있는 태도 덕분에 팀워크가 더 단단해질 수 있었던 것 같아요 / |

#### ABOUT [조윤태](https://github.com/cxzaqq)

|  FROM  | COMMENT                                                                                                                                                                                                                                                                                                          |
| :----: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 김기종 | 저희 팀에 없어서는 안 될 브레인으로서 프로젝트 설계, 전체 로직 구현 등 모조리 언급 할 수 없을 정도로 보이는 곳, 안 보이는 곳에서 열심히 임해주고 잘해주셨습니다. 심지어 프로젝트 마감이 급박한 상황에서 발표까지 맡게 되셨는데 이 역할도 훌륭히 수행해 주셔서 이번 프로젝트 내내 감사했다고 말씀드리고 싶습니다. |
| 신민경 |                                                                                                                                                                                                                                                                                                                  |
| 황수민 | 팀의 실질적인 리더 역할을 해주셨다고 생각합니다. 프로젝트 도중 난관에 봉착했을 때도 침착하게 해결 방안을 모색하며 더 나은 방향으로 이끌어주셨습니다. 기술적인 이해도가 뛰어나 많은 도움을 받을 수 있었고, 팀원들의 질문에도 함께 고민하며 적극적으로 문제 해결을 하려고 노력해주셨습니다. 문제가 생겼을 때 바로바로 해결방안을 도출해주신 윤태님 덕분에 프로젝트 기간 동안 팀원들도 함꼐 기술적 성장을 이루어낼 수 있었던 것 같습니다. 많은 일을 맡으셨음에도 불구하고 힘든 내색 없이 끝까지 책임감 있게 임하셨으며, 겸손한 태도를 유지하는 모습이 인상적이었습니다. 특히, 강한 책임감으로 발표까지 완성도 높게 마무리하신 점은 정말 박수쳐드리고 싶습니다! |
| 이예원 | 우리 팀의 선장님. 선장님과 함께라면 언제나 든든합니다. 특히 시간이 촉박한 상황에서도 조급해하지 않고, 차분하게 문제를 해결해나가는 태도가 인상 깊었어요. 그런 태도 덕분에 팀원들도 믿고 의지할 수 있었고, 팀 전체가 흔들림 없이 나아갈 수 있었습니다. 궁금한 점이나 질문이 생기면 바쁘신 와중에도 먼저 도와주셔서 정말 감사했고 오류가 발생했을 때 로그를 활용해 빠르게 원인을 파악하고 해결해나가는 과정을 알려주셔서 많은 것을 배울 수 있었습니다. 모르는 개념에 대해 여러 번 질문을 드려도 늘 한결같은 태도로 친절히 설명해주시고 이해할 때까지 함께 고민해주는 선장님 덕분에 더 많은 성장을 할 수 있었던 것 같습니다. 항상 감사한 마음뿐입니다 / |

#### ABOUT [신민경](https://github.com/mmmv41)

|  FROM  | COMMENT                                                                                                                                                                                                                                                                                                          |
| :----: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 김기종 | 프로젝트 기간 동안 아이디어 수립 과정에서 적극적으로 자신의 의견을 피력하고, 다양한 아이디어를 제공해주는 모습이 인상 깊었습니다.또한 프로젝트 구현 과정에서 로그인, 회원가입 도메인을 담당하셨는데, 어려운 내용이었음에도 불구하고 성공적으로 구현해내는게 대단하다고 생각했고 감사했습니다.                    |
| 조윤태 | 가장 어려운 부분 중 하나였던 Spring Security를 적용하면서, 프로젝트의 보안성을 한층 높였습니다. 여기에 더해 Redis까지 활용하며 성능 개선에도 기여하는 등, 프로젝트를 더욱 완성도 높은 형태로 발전시키는 데 주요한 역할을 했습니다. 어려운 문제를 해결해 나가는 과정에서 팀원들에게도 긍정적인 영향을 주었습니다. |
| 황수민 |                                                                                                                                                                                                                                                                                                                  |
| 이예원 | 이번 프로젝트에서 가장 어려운 기능 중 하나였던 회원가입 및 로그인 기능을 자진해서 맡아, 완벽하게 구현한 점이 정말 인상 깊었습니다. 단순히 동작하는 수준이 아니라, 커스텀 예외 처리까지 깔끔하게 정리하며 짧은 개발 기간 안에 높은 완성도로 마무리해주어 팀 전체의 개발 흐름이 훨씬 안정적이었던 것 같아요. 무엇보다도 지속적으로 더 나은 구조와 코드를 고민하고 개선하려는 태도가 매우 인상적이었습니다. 복잡한 요구사항 속에서도 흔들리지 않고 차근차근 문제를 해결해나가는 모습을 보며, 수행능력과 책임감 등 배울점을 많이 느꼈던 것 같아요. 덕분에 이번 프로젝트에서 의지하면서 진행했던 것 같아요/|

#### ABOUT [황수민](https://github.com/emily9949)

|  FROM  | COMMENT                                                                                                                                                                                                                                                                                                                                                              |
| :----: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 김기종 | 팀원들 간에 의견이 서로 엇갈리거나 다양하게 나오는 때에도 남의 말에 경청하고 소통하는 모습에서 배울 점이 많다고 느꼈습니다. 또한 프로젝트 내내 항상 열심히 임하는 모습이 인상 깊었습니다. 프로젝트 마감이 얼마남지 않은 상황에서 신체적으로 안 좋은 게 느껴졌음에도 불구하고 내색하지 않고 끝까지 최선을 다 해주셔서 감사했습니다.                                   |
| 조윤태 | 모르는 부분이 생기면 주저하지 않고 학습하며 해결하려는 적극적인 자세가 정말 인상적이었습니다. 특히, 게이트웨이 필터링을 구현하는 과정에서 기존 강의를 다시 찾아보며 끈질기게 해결책을 모색하는 모습이 돋보였습니다. 피곤한 상황에서도 힘든 기색 없이 끝까지 집중력을 유지하며 맡은 역할을 수행해 준 덕분에, 팀 전체가 더욱 적극적으로 프로젝트에 임할 수 있었습니다. |
| 신민경 |                                                                                                                                                                                                                                                                                                                                                                      |
| 이예원 | 모르는 부분이 생길 때마다 함께 고민해주고 해결 방안을 같이 찾아주는 태도가 정말 인상 깊었습니다. 덕분에 막히는 순간에도 혼자 고민하지 않아도 되어 큰 힘이 되었고, 자연스럽게 팀의 협업 분위기에도 긍정적인 영향을 준 것 같아요. GitHub 사용에 익숙하지 않아 질문을 많이 했는데 항상 친절하게 알려주고, 특히 PR 코멘트에 대해 고민할 때마다 섬세한 피드백을 통해 많은 도움을 받을 수 있었고 세심하게 짚어주는 그 과정 덕분에 저도 더 나은 방식으로 코드 리뷰를 바라보게 되었던 것 같아요. 그리고 어려운 상황 속에서도 끝까지 문제를 해결하려는 끈기 있는 자세가 인상 깊었습니다. 그러한 모습 덕분에 자극받아 더 열심히 할 수 있었어요/ |

#### ABOUT [이예원](https://github.com/oni128)

|  FROM  | COMMENT                                                                                                                                                                                                                                                                                                                                       |
| :----: | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 김기종 | 육체적으로나 정신적으로나 지칠 법한 상황에도 항상 밝은 얼굴로 프로젝트에 임해주시는 모습이 인상깊었습니다. 덕분에 프로젝트 동안 큰 트러블 없이 원활히 굴러갈 수 있었다고 생각합니다. 또한 기술적인 측면에서도 도메인 기능 구현, 테스트 코드 작성들을 척척 해내시는 모습을 보고 대단하다고 느꼈고 감사했습니다.                                |
| 조윤태 | 모르는 부분이 있어도 쉽게 포기하지 않고 해결책을 찾아가며 기능을 구현하는 모습을 보며 저 역시 긍정적인 자극을 받을 수 있었습니다. 프로젝트의 완성도를 높이는 데 꾸준히 기여했을 뿐만 아니라, 좋은 아이디어를 제안해 프로젝트 주제를 정하는 과정에서도 중요한 역할을 했습니다. 덕분에 더욱 재미있고 의미 있는 프로젝트를 진행할 수 있었습니다. |
| 신민경 |                                                                                                                                                                                                                                                                                                                                               |
| 황수민 |                                                                                                                                                                                                                                                                                                                                               |

</details>
