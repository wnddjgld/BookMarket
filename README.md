# 📖 BookMarket (도서 쇼핑몰 프로젝트)

**BookMarket**은 Spring Boot를 기반으로 구축된 웹 도서 쇼핑몰 애플리케이션입니다.  
도서 조회, 회원 관리, 장바구니, 주문 처리 프로세스부터 관리자 페이지까지 쇼핑몰의 핵심 기능을 구현한 학습 및 실무 지향 프로젝트입니다.

---

## 🛠 Tech Stack

### Backend
| 기술 | 상세 내용 |
| :--- | :--- |
| **Java** | JDK 17 |
| **Framework** | Spring Boot 3.4.3 |
| **Security** | Spring Security (인증 및 인가 처리) |
| **Data Access** | Spring Data JPA (회원, 주문), Spring JDBC Template (도서, 장바구니) |
| **Validation** | Bean Validation, Custom Validator (재고/가격 검증) |
| **Build Tool** | Gradle 8.12.1 |

### Frontend
| 기술 | 상세 내용 |
| :--- | :--- |
| **Template Engine** | Thymeleaf (Layout Dialect 포함) |
| **CSS Framework** | Bootstrap 5.3 |
| **Script** | JavaScript (장바구니 로직, 유효성 검사) |

### Infrastructure & Database
* **Database:** MySQL 8.x
* **File Storage:** Local File System (`C:/upload/`)

---

## ✨ Key Features (주요 기능)

### 1. 📚 도서 관리 (Book Management)
* **도서 목록 및 상세 조회**: 전체 도서 목록 페이징 및 개별 상세 정보 조회
* **카테고리별 분류**: IT전문서, IT교육교재 등 카테고리 필터링
* **도서 검색**: Matrix Variable을 활용한 다중 조건 검색 (출판사, 카테고리 등)
* **관리자 기능**:
    * 신규 도서 등록 (이미지 업로드 포함)
    * 도서 정보 수정 및 삭제
    * **유효성 검사**: 가격, 재고 수, ISBN 패턴 검사 및 커스텀 검사(가격 대비 재고 제한 등) 적용

### 2. 🛒 장바구니 (Cart)
* **세션 기반 장바구니**: 로그인 여부와 관계없이 세션 ID를 활용한 장바구니 유지
* **기능**: 장바구니 담기, 수량 변경, 항목 삭제, 전체 비우기
* **실시간 계산**: 항목별 소계 및 전체 주문 금액 자동 계산

### 3. 💳 주문 프로세스 (Order Process)
* **단계별 주문**: `고객 정보 입력` -> `배송 정보 입력` -> `주문 확정` -> `주문 완료`
* **주문 검증**: 주문 시점의 재고 수량 확인 및 차감 로직 (`OrderService`)
* **주문 취소**: 세션 만료 및 주문 데이터 롤백

### 4. 👤 회원 시스템 (Member System)
* **회원가입**: 사용자 정보 등록 및 중복 ID 체크 (JPA 기반)
* **인증(Login)**: Spring Security를 이용한 로그인/로그아웃 처리
* **권한 관리**: 일반 사용자(USER)와 관리자(ADMIN) 권한 분리 및 페이지 접근 제어
* **회원 정보 수정 및 탈퇴**

### 5. 🛠 관리자 모드 (Admin)
* **접근 제어**: URL 기반 보안 설정을 통해 `/books/add`, `/order/list` 등 관리자 메뉴 접근 제한
* **주문 관리**: 전체 주문 내역 조회 (페이징, 정렬 기능 포함)
* **배송 관리**: 주문 건에 대한 배송지 정보 수정

---

## 💾 Database Schema & Configuration

### 주요 테이블
* **Book**: 도서 정보 (PK: `b_bookId`)
* **Member**: 회원 정보 (PK: `num`, Unique: `memberId`)
* **Orders**: 주문 정보 (Customer, Shipping 정보 포함)
* **Customer / Shipping / Address**: 주문 관련 부가 정보

### 환경 설정 (`application.properties`)
로컬 환경에 맞춰 DB 연결 정보와 파일 업로드 경로를 설정해야 합니다.

```properties
# MySQL 설정
spring.datasource.url=jdbc:mysql://localhost:3306/bookmarketdb
spring.datasource.username=사용자명
spring.datasource.password=비밀번호

# 파일 업로드 경로 (필수: 해당 폴더가 생성되어 있어야 함)
file.uploadDir=C:/upload/
spring.servlet.multipart.location=C:/upload
