# Melona

- Melon Clone Coding by Java Swing & Spring Boot

# 기획

- **프로젝트 소개**
  - _우리가 만들 App_
    - 멜론, Spotify 와 같은 음악 스트리밍 서비스
  - _프로젝트 동기_
    - 객체지향을 살리고 각각의 참여 객체들이 다른 객체들과 상호작용할 수 있으면서 재밌는 것을 만들어보자는 생각에
  - _현행 서비스 분석_
    - Melon
      - tls 통신에 encrypted 된 data 를 주고받음
      - http 를 이용하여 웹소켓을 사용
      - 레퍼런스가 없어서 wireshark 로 패킷을 분석해야 했음
        - 결국 Http 통신 위에서 tls 통신을 한다는 것을 파악
    - Spotify
      - [참고 자료](https://engineering.atspotify.com/2018/08/31/smoother-streaming-with-bbr/)
      - 동작 원리
        - 인코딩된 각 음악 트랙을 파일로 저장하고 HTTP 서버에 복사
        - 사용자가 노래를 재생할 때 GET 요청으로 음악 스트림 파일을 요청
        - 음악 건너띄기 일시정지 기능에 대해서는 BBR 알고리즘을 사용
          - BBR : google 이 개발한 TCP Congestion 제어 알고리즘
            - 더 빠른 data 전송을 위해 개발됨
            - 우리의 프로젝트 목표는 객체지향을 더 잘 느낄 수 있는 프로젝트를 하기 위함이라 건너띄기, 일시정지 와 같은 행동에 대한 고민은 하지 않을 것
    - 분석 결과
      - Melon 과 Spotify 의 공통점인 HTTP 통신으로 음악 file 을 stream 화 하여 stream 전송을 한다
      - 보다 객체지향적인 파트인 사용자 회원가입, 로그인, 음악 file의 Stream 제어, 플레이리스트에 집중하려 함
        - 또한 권한 및 인증에 대한 관리보다 객체지향 설계 및 참여 객체간 주고받는 message 에 집중하려함
  - _팀 소개 및 역할_
    - 장원익(16) : Backend - Java Spring Boot
    - 한진규(20) : Frontend - Java Swing
- **기획**
  - 기능 명세
    - 회원 가입, 로그인
    - 음악 재생
    - 음악 저장
  - 요구사항 분석
  - 기타
    - UI Wireframe
      - Kakao Oven
    - 협업 방법
      - Code의 Version Control : Git
      - 일정 관리 : Github Kanban
      - Issue Tracking : Github Issue
    - 개발 방법론
      - 폭포수 모델
    - 음악 file
      - sound cloud
- **설계**
  - _UI 설계_
    - Kakao Oven
  - _시스템 아키텍쳐_
    - 3 tier 아키텍쳐 (front-back-db)
      - front-back : HTTP
      - back-db : Socket
    - 통신 방법 : Restful 한 http 의 API 통신
    - 음악 file 전송 : InputStreamSource 를 상속하는 MultipartFile 객체를 response body 에 포함
  - _기술 스택_
    - Front-End : Java Swing
    - Back-End : Spring Boot
    - Database : MySql
    - Build Tool : Gradle
  - _도메인 모델링_
    - 사용자
    - 노래
    - 플레이리스트
  - _DB 설계_
    - ERD
  - _API 설계_
    - 회원 관리
      - 회원가입 : POST `/api/authenticate/register`
      - 로그인 : POST `/api/authenticate/login`
    - _음악 관리_
      - 전체 음악 조회 : GET `/api/musics`
      - 특정 음악 재생 : GET `/api/musics/{musicId}`
      - 내 플레이리스트 조회 : GET `/api/users/{userId}/playlists`
      - 플레이리스트 전체 재생 : GET `/api/users/{userId}/playlists/{musicId}`
      - 플레이리스트 저장 : POST `/api/users/playlists`
- **앞으로의 계획**
  - 일정
    - WBS 로 설명

# 자료

- MultipartFile [Java Docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/multipart/MultipartFile.html)
- Java Swing 으로 Music Player 만들기 [tistory](https://aristatait.tistory.com/17)
- How to Make a GUI Music Player In Java [youtube](https://www.youtube.com/watch?v=OX3CFHLV9ws)
