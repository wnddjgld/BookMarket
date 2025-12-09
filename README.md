# 📖 BookMarket (도서 쇼핑몰 프로젝트)

**BookMarket**은 Spring Boot 기반 도서 쇼핑몰 웹 애플리케이션입니다.  
도서 조회, 회원 관리, 장바구니, 주문 처리, 관리자 기능까지 실제 쇼핑몰 핵심 요소를 학습 및 실무 관점에서 구현한 프로젝트입니다.

---

## 🛠 Tech Stack

### Backend
| 기술 | 상세 내용 |
| :--- | :--- |
| **Java** | JDK 17 |
| **Framework** | Spring Boot 3.4.3 |
| **Security** | Spring Security (인증 및 인가) |
| **Data Access** | Spring Data JPA(회원, 주문), Spring JDBC Template(도서, 장바구니) |
| **Validation** | Bean Validation + Custom Validator (재고/가격 검증) |
| **Build Tool** | Gradle 8.12.1 |

### Frontend
| 기술 | 상세 내용 |
| :--- | :--- |
| **Template Engine** | Thymeleaf (Layout Dialect) |
| **CSS Framework** | Bootstrap 5.3 |
| **Script** | JavaScript (장바구니, 입력 유효성 검사) |

### Infrastructure & Database
- **Database:** MySQL 8.x  
- **File Storage:** Local File System (`C:/upload/`)

---

## ✨ Key Features (주요 기능)

### 1. 📚 도서 관리 (Book Management)
- 전체 도서 목록 조회 (페이징)
- 카테고리 필터링 (IT전문서, IT교육교재 등)
- 다중 조건 검색 (Matrix Variable 기반)
- 관리자 기능
  - 신규 도서 등록 (이미지 업로드)
  - 도서 수정/삭제
  - 가격/재고/ISBN 규칙 기반 유효성 검사 + 사용자 정의 검사

### 2. 🛒 장바구니 (Cart)
- 세션 기반 장바구니 (로그인 여부와 관계없이 유지)
- 장바구니 담기, 수량 변경, 삭제, 전체 비우기
- 실시간 가격 계산 (소계/총액)

### 3. 💳 주문 프로세스 (Order Process)
- 주문 단계:  
  `고객 정보 입력 → 배송 정보 입력 → 주문 확정 → 주문 완료`
- 주문 시점 재고 검증 및 차감 처리 (OrderService)
- 주문 취소 시 롤백

### 4. 👤 회원 시스템 (Member System)
- 회원가입 (중복 ID 검사 포함)
- 로그인/로그아웃 (Spring Security)
- 권한 분리 (USER / ADMIN)
- 내 정보 수정 및 회원 탈퇴

### 5. 🛠 관리자 모드 (Admin)
- URL 기반 접근 제어 (Spring Security)
- 주문 목록 조회 (페이징/정렬)
- 배송지 수정 기능

---

## 💾 Database Schema & Configuration

### 주요 테이블
- **Book** — 도서 정보 (`b_bookId`)
- **Member** — 회원 정보 (`num`, unique: `memberId`)
- **Orders** — 주문 기본 정보
- **Customer / Shipping / Address** — 주문 부가 정보

### application.properties 예시

```properties
# MySQL 설정
spring.datasource.url=jdbc:mysql://localhost:3306/bookmarketdb
spring.datasource.username=사용자명
spring.datasource.password=비밀번호

# 파일 업로드 경로
file.uploadDir=C:/upload/
spring.servlet.multipart.location=C:/upload

🚀 How to Run

1. 사전 준비

-   Java 17 설치
-   MySQL 설치 후 DB 생성

CREATE DATABASE bookmarketdb;

-   이미지 업로드 폴더 생성 C:/upload/

------------------------------------------------------------------------

2. 빌드 및 실행

Repository Clone

git clone

Build

./gradlew build

Run

./gradlew bootRun

------------------------------------------------------------------------

3. 접속 경로

-   메인 페이지: http://localhost:8080/BookMarket/home

-   로그인 페이지: http://localhost:8080/BookMarket/login

------------------------------------------------------------------------

📂 Project Structure

src/main/java/kr/ac/kopo/wnddjgld/bookmarket ├── config # Security,
Resource, Validation 설정 ├── controller # MVC Controllers (Book, Cart,
Order, Member…) ├── domain # Entity & DTO (Book, Member, Order…) ├──
exception # Custom Exception & Global Handler ├── repository # JPA
Repository & JDBC Template Impl ├── service # Business Logic └──
validator # Custom Validators
