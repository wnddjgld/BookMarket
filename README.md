# 📖 BookMarket: 온라인 도서 쇼핑몰

Spring Boot 기반으로 개발된 간단한 온라인 도서 쇼핑몰 프로젝트입니다.
학습 목적으로 제작되었으며, 도서 조회, 장바구니, 주문 처리, 관리자 기능 등 기본적인 이커머스 웹 애플리케이션의 핵심 기능을 구현했습니다.

---

## 주요 기능

### 📚 도서 (Book)
* **목록 조회:** 전체 도서 목록을 보여줍니다.
* **카테고리별 조회:** `IT전문서`, `IT교육교재` 등 특정 카테고리의 도서만 필터링하여 볼 수 있습니다.
* **상세 정보:** 각 도서의 설명, 저자, 가격 등 상세 정보를 조회할 수 있습니다.
* **필터링:** 출판사(Publisher)와 분류(Category)를 조합하여 원하는 도서를 검색할 수 있습니다.

### 🔒 관리자 (Admin)
* **접근 제어:** Spring Security를 사용하여 특정 페이지(` /books/add`, `/order/list` 등)는 관리자만 접근 가능하도록 설정했습니다.
    * **기본 계정**: ID `Admin`, PW `Admin1234`
* **도서 관리:** 새로운 도서를 등록하고 관련 이미지를 업로드할 수 있습니다.
* **입력 유효성 검사:** 도서 등록 시 JPA Validation 및 Spring Custom Validator를 활용하여 다음과 같은 항목을 검증합니다:
    * `bookId` (ISBN 형식 및 중복 여부)
    * 가격(`unitPrice`)에 따른 재고(`unitsInStock`) 수량 제한 (예: 10,000원 이상 도서는 100개 미만)
* **주문 관리:** 전체 주문 목록을 조회하며, **페이징** 및 **정렬**(주문 ID, 고객 ID, 배송지, 총액 기준) 기능을 지원합니다.
    * 개별 주문의 상세 내역 조회, 배송 정보 수정, 주문 삭제가 가능합니다.

### 🛒 장바구니 (Cart)
* **세션 기반:** 사용자의 웹 세션을 기준으로 장바구니를 생성하고 관리합니다.
* **기능:** 장바구니에 도서를 추가하거나 특정 항목을 삭제하고, 전체 항목을 비울 수 있습니다.

### 💳 주문 (Order)
* **프로세스:** 장바구니에 담긴 상품들을 기반으로 주문을 생성합니다.
* **정보 입력:** 주문자 정보(Customer)와 배송지 정보(Shipping)를 단계별로 입력받습니다.
* **주문 확인:** 결제 전, 주문할 도서, 수량, 총액, 고객 정보, 배송 정보를 최종 확인할 수 있는 페이지를 제공합니다.
* **상태 처리:** 주문 완료 또는 취소 처리가 가능합니다.

### ⚙️ 기타
* **예외 처리:** `BookIdException`, `CategoryException`, `CartException` 등 비즈니스 로직에 맞는 커스텀 예외를 정의하고, `@ControllerAdvice`를 이용해 일관된 오류 페이지를 사용자에게 보여줍니다.
* **자원 관리:** 도서 이미지 등 정적 파일은 `static/images` 디렉토리에서 관리하며, 웹 페이지 템플릿은 Thymeleaf를 사용하여 `templates` 폴더 내에서 관리합니다.

---

## 사용 기술 스택

| 영역         | 기술                                                                                              |
| :----------- | :------------------------------------------------------------------------------------------------ |
| **Backend** | Java 17, Spring Boot 3.4.3, Spring MVC, Spring Data JPA, Spring Security, Spring Validation |
| **Frontend** | Thymeleaf, HTML5, Bootstrap 5                                                        |
| **Database** | MySQL                                                                                   |
| **Build** | Gradle                                                                                  |
| **Others** | Lombok                                                                                  |

---

## ⚙️ 설정 및 실행 방법

### 1. 사전 준비
* **Java 17 (JDK)** 설치
* **MySQL** 데이터베이스 설치 및 실행
* **Git** 설치

### 2. 프로젝트 클론
```bash
git clone <repository-url>
cd BookMarket-1fce37a438622a98dd1f65e1bfcf159aaa744c28
```

### 3. 설정 파일 수정

`src/main/resources/application.properties` 파일을 열어 본인 환경에 맞게 수정합니다.

**데이터베이스 연결 정보:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmarketdb
spring.datasource.username=wnddjgld
spring.datasource.password=1234
```

**파일 업로드 경로** (실제 존재하는 디렉토리 경로로 변경)

```properties
spring.servlet.multipart.location=C:/upload
file.uploadDir=C:/upload/
```

---

### 4. 데이터베이스 스키마 생성

MySQL 클라이언트를 이용해 아래 명령어를 실행합니다.

```sql
CREATE DATABASE bookmarketdb;
```

> 테이블은 Spring Data JPA의 `ddl-auto=update` 설정에 따라  
> 애플리케이션 실행 시 자동으로 생성/업데이트됩니다.

---

### 5. 접속 확인

웹 브라우저에서 아래 주소로 접속합니다.

```
http://localhost:8080/BookMarket/home
```
