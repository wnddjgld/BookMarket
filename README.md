# Book Market

Spring Boot 기반의 온라인 도서 쇼핑몰 프로젝트입니다.  
도서 조회부터 장바구니, 주문, 관리자 페이지 기능을 제공합니다.

---

##  주요 기능

###  도서 (Book)
- 전체 도서 목록 조회
- 카테고리별 조회 (`IT전문서`, `IT교육교재` 등)
- 도서 상세 조회 (설명, 저자, 가격 등)
- Publisher + Category 조합 필터링

###  관리자(Admin)
- Spring Security 기반 권한 제어  
  - 관리자 전용 페이지 : `/books/add`, `/order/list` 등  
  - **기본 계정**: ID `Admin`, PW `Admin1234`
- 도서 등록 및 이미지 업로드
- 입력 유효성 검사(JPA + Validation)
  - bookId 중복 검사
  - 가격에 따른 재고 수량 제한
- 주문 관리
  - 페이징 및 정렬 지원
  - 상세 조회 / 배송 정보 수정 / 주문 삭제

###  장바구니 (Cart)
- 세션 기반 장바구니 관리
- 항목 추가 / 삭제 / 전체 비우기 지원

###  주문 (Order)
- 장바구니 기반 주문 생성
- 고객 정보, 배송지 정보 단계별 입력
- 주문 정보 확인 페이지 제공
- 주문 완료 / 취소 처리

###  기타 기능
- 예외 처리  
  - BookIdException, CategoryException + `@ControllerAdvice`
- 국제화(i18n)  
  - `messages.properties`(한국어/영어)
- 정적/동적 자원 관리  
  - `static/images`, `templates`

---

##  사용 기술 스택

| 영역 | 기술 |
|------|------|
| Backend | Java 17, Spring Boot 3.4.3, Spring MVC, Spring Data JPA, Spring Security, Spring Validation |
| Frontend | Thymeleaf, HTML5, Bootstrap 5 |
| Database | MySQL |
| Build Tool | Gradle |
| Others | Lombok |

---

##  설정 정보

### MySQL 설정

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmarketdb
spring.datasource.username=wnddjgld
spring.datasource.password=1234

파일 업로드 경로 설정
spring.servlet.multipart.location=C:/upload
file.uploadDir=C:/upload/

### 실행 방법

프로젝트 클론

git clone <repository-url>


application.properties 파일에서 DB 및 파일 경로 수정

MySQL에서 bookmarketdb 스키마 생성

CREATE DATABASE bookmarketdb;


실행

# IDE 실행
BookMarketApplication.java 실행

# 또는 Gradle CLI 실행
./gradlew bootRun        # macOS/Linux
gradlew.bat bootRun      # Windows


접속 URL

http://localhost:8080/BookMarket/home
