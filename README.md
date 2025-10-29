1. 주요 기능
도서 (Book)
도서 목록: 전체 도서 목록을 조회할 수 있습니다.

카테고리별 조회: 'IT전문서', 'IT교육교재' 등 카테고리별로 도서를 필터링하여 볼 수 있습니다.

도서 상세: 특정 도서의 상세 정보(설명, 저자, 가격 등)를 조회할 수 있습니다.

도서 필터링: Publisher(출판사)와 Category(분류)를 조합하여 도서를 검색할 수 있습니다.

관리자 (Admin)
보안: Spring Security를 사용하여 /books/add, /order/list 등 관리자 전용 페이지에 대한 접근을 제어합니다. (기본 ID: Admin, PW: Admin1234)

도서 등록: [관리자] 새로운 도서 정보를 입력하고, 도서 이미지를 업로드할 수 있습니다.

입력 유효성 검사: 도서 등록 시 JSR 303 Validation 및 Spring Validator를 사용하여 bookId 중복 검사, 가격에 따른 재고 수량 제한 등 비즈니스 로직을 검증합니다.

주문 관리: [관리자] 전체 주문 목록을 페이징 및 정렬 기능과 함께 조회할 수 있습니다.

주문 상세/수정/삭제: [관리자] 특정 주문의 상세 내역을 보거나, 배송지 정보를 수정하거나, 주문 자체를 삭제할 수 있습니다.

장바구니 (Cart)
세션 기반: 사용자의 세션 ID를 기준으로 장바구니가 생성 및 관리됩니다.

항목 추가/삭제: 도서 상세 페이지 또는 목록에서 장바구니에 도서를 추가하거나 제거할 수 있습니다.

전체 비우기: 장바구니에 담긴 모든 항목을 한 번에 삭제할 수 있습니다.

주문 (Order)
주문 프로세스: 장바구니에 담긴 상품을 기반으로 주문을 생성합니다.

정보 입력: 주문자 정보(Customer)와 배송지 정보(Shipping)를 단계별로 입력받습니다.

주문 확인: 주문 완료 전, 모든 정보(상품, 고객, 배송지)를 확인하는 페이지를 제공합니다.

주문 완료/취소: 주문을 최종 확정하거나 취소할 수 있습니다.

기타
예외 처리: BookIdException, CategoryException 등 커스텀 예외와 @ControllerAdvice를 사용하여 특정 오류 발생 시 사용자에게 적절한 오류 페이지를 안내합니다.

국제화(i18n): messages.properties를 통해 일부 UI 텍스트(도서 등록 폼)를 다국어(한/영)로 제공합니다.

정적/동적 자원: 이미지 등 정적 리소스는 static/images에서, Thymeleaf 템플릿 파일은 templates 폴더에서 관리합니다.

2. 사용된 기술
Backend: Java 17, Spring Boot 3.4.3, Spring MVC, Spring Data JPA, Spring Security, Spring Validation

Frontend: Thymeleaf, HTML5, Bootstrap 5

Database: MySQL

Build Tool: Gradle

Others: Lombok

3. 설정 정보
프로젝트 실행을 위해 application.properties 파일의 다음 항목을 로컬 환경에 맞게 수정해야 합니다.

데이터베이스 (MySQL)
Properties

spring.datasource.url=jdbc:mysql://localhost:3306/bookmarketdb
spring.datasource.username=wnddjgld
spring.datasource.password=1234
파일 업로드
도서 이미지 업로드를 위한 로컬 디렉토리 경로를 설정합니다.

Properties

spring.servlet.multipart.location=C:/upload
file.uploadDir=C:/upload/

4. 실행 방법
Git을 통해 프로젝트를 클론합니다.

application.properties 파일의 datasource 및 file.uploadDir 설정을 로컬 환경에 맞게 수정합니다.

MySQL에서 bookmarketdb 스키마를 생성합니다. (JPA ddl-auto=update로 설정되어 있어 테이블은 자동 생성됩니다.)

(IDE에서 실행) BookMarketApplication.java 파일을 실행합니다.

(Gradle CLI) 프로젝트 루트 디렉토리에서 ./gradlew bootRun (Linux/macOS) 또는 gradlew.bat bootRun (Windows) 명령어를 실행합니다.

웹 브라우저에서 http://localhost:8080/BookMarket/home (또는 application.properties에 설정된 server.servlet.context-path 기준)으로 접속합니다.
