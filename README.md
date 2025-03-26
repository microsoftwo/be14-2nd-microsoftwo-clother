<br>

# 👕 Clother (Style Sharing Community) 👚

<img src="https://github.com/user-attachments/assets/8e8c7919-f4dd-45b0-9c94-faab9ea0231a">
<img src="https://github.com/user-attachments/assets/14df180e-8b17-4ba1-a5a5-573c32d46d33">

---

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

<br><br>

---

# 🚀 Team microsoftwo

| <img src="https://github.com/user-attachments/assets/9e5c3e83-7f0d-41ca-816c-8133409537e1" width="200"> | <img src="https://github.com/user-attachments/assets/8f52dde1-3590-4e2f-880d-32098f5d098a" width="200"> | <img src="https://github.com/user-attachments/assets/0b56df7f-c48d-4975-abff-aeb51af8f2da" width="200"> | <img src="https://github.com/user-attachments/assets/f5cbf6cc-ff54-4720-be15-390182415083" width="200"> | <img src="https://github.com/user-attachments/assets/1d2619c6-f467-485e-9d90-14c7c43bc316" width="200"> |
| :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------: |
|                                                 김기종                                                  |                                                 조윤태                                                  |                                                 신민경                                                  |                                                 황수민                                                  |                                                 이예원                                                  |
| [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/rrangeess) |  [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/cxzaqq)   |  [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/mmmv41)   | [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/emily9949) |  [<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/oni128)   |

<br><br>

---

# <p id="1">📁 1. 프로젝트 기획</p>

### <p id="1-1">1-1. 배경 및 필요성</p>

현재 의류를 포함한 헤어, 액세사리를 아우르는 스타일링 정보를 한번에 얻는 것이 매우 어렵다. 기존 쇼핑 앱은 의류 정보만 제공하며, 헤어스타일과 메이크업 제품 정보까지 연결되지 않는다. 사용자는 원하는 스타일을 찾으면 직접 댓글로 질문하거나 추가 검색을 해야 하는 불편함이 있다. 기존 스타일 공유 서비스도 한계를 가진다. 예를 들어, 온더룩은 의류 코디만 제공하고, 룩업은 남성 코디 위주이며, 인스타그램은 스타일링 정보를 체계적으로 제공하지 않는다. 이를 해결하기 위해 ‘클로저’ 스타일링 공유 서비스를 제안한다. 사용자는 스타일 사진을 보고 헤어샵, 메이크업 제품, 의류 브랜드 정보를 한 번에 확인할 수 있으며, 같은 아이템을 활용한 다양한 코디 사례도 찾아볼 수 있다. 또한, 팔로우한 유저의 스타일 변화 및 방문한 헤어샵 정보도 확인할 수 있어 보다 편리한 스타일링 경험을 제공한다.

### <p id="1-2">1-1. 주요 기능 </p>

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


### <p id="3-3">3-3. 📚 API 명세서 </p>

<details>
    <summary>API 명세서</summary>
    <div markdown="1">
        <img width="1400" alt="image" src="/readme-images/swagger/user-service-swagger.png">
        <img width="1400" alt="image" src="/readme-images/swagger/core-service-swagger.png">
    </div>
</details>

### <p id="3-4">3-4. Redis를 활용한 이메일 인증 </p>

📌 인증 절차
1. 사용자가 이메일을 입력하고 인증 요청을 보냄
2. 서버에서 랜덤 인증 코드를 생성
3. 해당 인증 코드를 Redis에 5분간 저장
4. 동시에 인증 코드를 사용자의 이메일로 전송 (SMTP 사용)
5. 사용자가 인증 코드를 입력하면, Redis에서 해당 코드가 유효한지 확인
6. 일치하면 인증 성공, 불일치 또는 만료 시 인증 실패



auth-code-expiration-millis: 300000 


### <p id="3-5">3-5. Redis 이용 트러블 슈팅 </p>

<img width="1180" alt="image" src="https://github.com/user-attachments/assets/963ad2b7-1c8e-43bf-993a-7ba8f8ed0e4b" />


<br><br>

---

# <p id="4">🎮 4. 단위 테스트</p>

### <p id="4-1">4-1. 단위 테스트 결과 </p>

<details>
    <summary>테스트 결과 확인하기</summary>
    <div markdown="1">
        <img width="1400" alt="image" src="/readme-images/unit-test/댓글생성.png">
        <img width="1400" alt="image" src="/readme-images/unit-test/특정게시물조회.png">
        <img width="1400" alt="image" src="/readme-images/unit-test/피드조회.png">
        <img width="1400" alt="image" src="/readme-images/unit-test/하위카테고리검색.png">
        <img width="1400" alt="image" src="/readme-images/unit-test/">
    </div>
</details>

### <p id="4-2">4-2. API 테스트 </p>

<details>
<summary>테스트 결과 확인하기</summary>
<div markdown="1">
    <img width="1400" alt="image" src="/readme-images/postman/01인증번호전송.png">
    <img width="1400" alt="image" src="/readme-images/postman/02인증번호검증.png">
    <img width="1400" alt="image" src="/readme-images/postman/03회원가입.png">
    <img width="1400" alt="image" src="/readme-images/postman/04로그인.png">
    <img width="1400" alt="image" src="/readme-images/postman/05토큰미포함요청.png">
    <img width="1400" alt="image" src="/readme-images/postman/06토큰포함요청.png">
    <img width="1400" alt="image" src="/readme-images/postman/07상품등록신청.png">
    <img width="1400" alt="image" src="/readme-images/postman/08상품등록신청삭제.png">
    <img width="1400" alt="image" src="/readme-images/postman/09포스팅등록.png">
    <img width="1400" alt="image" src="/readme-images/postman/10포스팅조회.png">
    <img width="1400" alt="image" src="/readme-images/postman/11훈수게시판등록.png">
    <img width="1400" alt="image" src="/readme-images/postman/12훈수게시판조회.png">
    <img width="1400" alt="image" src="/readme-images/postman/13좋아요등록.png">
    <img width="1400" alt="image" src="/readme-images/postman/14좋아요취소.png">
    <img width="1400" alt="image" src="/readme-images/postman/15댓글등록.png">
    <img width="1400" alt="image" src="/readme-images/postman/16댓글삭제.png">

</div>
</details>

<br><br>

---

# <p id="5">✍🏻 5. 문서 </p>

### <p id="5-1">5-1. 📙 요구사항 명세서 </p>

[[🔗요구사항 명세서 Link]](https://docs.google.com/spreadsheets/d/1HQYulWkDctMpm4mhM3wYKbtAY3fCOOigEeM-M-q0jlg/edit?gid=269659385#gid=269659385)
<br>

### <p id="5-2">5-2. 🗓️ WBS (Work Breakdown Structure) </p>

[[🔗 WBS Link]](https://docs.google.com/spreadsheets/d/1HQYulWkDctMpm4mhM3wYKbtAY3fCOOigEeM-M-q0jlg/edit?gid=393359725#gid=393359725)

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

|  FROM  | COMMENT |
| :----: | :------ |
| 조윤태 |         |
| 신민경 |         |
| 황수민 |         |
| 이예원 |         |

#### ABOUT [조윤태](https://github.com/cxzaqq)

|  FROM  | COMMENT |
| :----: | :------ |
| 김기종 | 저희 팀에 없어서는 안 될 브레인으로서 프로젝트 설계, 전체 로직 구현 등 모조리 언급 할 수 없을 정도로 보이는 곳, 안 보이는 곳에서 
열심히 임해주고 잘해주셨습니다. 심지어 프로젝트 마감이 급박한 상황에서 발표까지 맡게 되셨는데 이 역할도 훌륭히 수행해 주셔서 이번 프로젝트 내내
감사했다고 말씀드리고 싶습니다.|
| 신민경 |         |
| 황수민 |         |
| 이예원 |         |

#### ABOUT [신민경](https://github.com/mmmv41)

|  FROM  | COMMENT |
| :----: | :------ |
| 김기종 |프로젝트 기간 동안 아이디어 수립 과정에서 적극적으로 자신의 의견을 피력하고, 다양한 아이디어를 제공해주는 모습이 인상 깊었습니다. 
또한 프로젝트 구현 과정에서 로그인, 회원가입 도메인을 담당하셨는데, 어려운 내용이었음에도 불구하고 성공적으로 구현해내는게 대단하다고 생각했고
감사했습니다.|
| 조윤태 |         |
| 황수민 |         |
| 이예원 |         |

#### ABOUT [황수민](https://github.com/emily9949)

|  FROM  | COMMENT |
| :----: | :------ |
| 김기종 |팀원들 간에 의견이 서로 엇갈리거나 다양하게 나오는 때에도 남의 말에 경청하고 소통하는 모습에서 배울 점이 많다고 느꼈습니다. 또한 프로젝트 내내 
항상 열심히 임하는 모습이 인상 깊었습니다. 프로젝트 마감이 얼마남지 않은 상황에서 신체적으로 안 좋은 게 느껴졌음에도 불구하고 내색하지 않고 
끝까지 최선을 다 해주셔서 감사했습니다.|
| 조윤태 |         |
| 신민경 |         |
| 이예원 |         |

#### ABOUT [이예원](https://github.com/oni128)

|  FROM  | COMMENT |
| :----: | :------ |
| 김기종 |육체적으로나 정신적으로나 지칠 법한 상황에도 항상 밝은 얼굴로 프로젝트에 임해주시는 모습이 인상깊었습니다. 예원님 덕분에 프로젝트 동안 
큰 트러블 없이 원활히 굴러갈 수 있었다고 생각합니다. 또한 기술적인 측면에서도 도메인 기능 구현, 테스트 코드 작성들을 척척 해내시는 모습을 보고 대단하다고 느꼈고
감사했습니다.|
| 조윤태 |         |
| 신민경 |         |
| 황수민 |         |

</details>
