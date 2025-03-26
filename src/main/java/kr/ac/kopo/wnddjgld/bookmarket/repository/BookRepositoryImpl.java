package kr.ac.kopo.wnddjgld.bookmarket.repository;

import kr.ac.kopo.wnddjgld.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> listOfBooks = new ArrayList<Book>();

    public BookRepositoryImpl() {
        Book book1 = new Book();
        book1.setBookId("isbn0001");
        book1.setName("스프링부트완전정복");
        book1.setUnitPrice(BigDecimal.valueOf(35000));
        book1.setAuthor("송미영");
        book1.setDescription("스프링 부트는 스프링을 기반으로 쉽고 빠르게 웹 애플리케이션을 개발할 수 있는 도구이다. " +
                "이 책에서는 스프링 부트의 기본 개념을 쉽게 이해하고 다양한 실습 예제로 빠르게 익힐 수 있다. " +
                "그리고 단계별 실습을 따라 하다 보면 도서 쇼핑몰 구축 프로젝트를 완성할 수 있다. " +
                "개념-실습-프로젝트의 3단계 학습으로 스프링 부트를 제대로 익힌다면 개발 시간을 단축하고 생산성을 높일 수 있는 개발자로 성장할 수 있다.");
        book1.setPublisher("길벗캠퍼스");
        book1.setCategory("IT교재");
        book1.setUnitsInStock(1000);
        book1.setReleaseDate("2024/12/31");
        book1.setCondition("신규도서");

        Book book2 = new Book();
        book2.setBookId("isbn0002");
        book2.setName("Android Studio를 활용한 안드로이드 프로그래밍");
        book2.setUnitPrice(BigDecimal.valueOf(34000));
        book2.setDescription("이 책은 대학교나 IT 전문학원의 안드로이드 프로그래밍 과목 수강생을 대상으로 한다. " +
                "기본적인 프로그래밍을 접해본 독자라면 Java 기초부터 시작하여 안드로이드 앱 개발까지 한번에 학습할 수 있도록 구성되어 있다. " +
                "특별히 이번 9판에서는 버전업을 적용하여 JDK 17, Android 14.0(U), Android Studio Hedgehog에서 실습할 수 있다. 또한 연습문제 일부를 변경하였으며, " +
                "13장에 ‘경기도 맛집 찾기 앱 만들기’ 프로젝트를 추가하였다. ");
        book2.setPublisher("한빛아카데미");
        book2.setCategory("IT교재");
        book2.setUnitsInStock(800);
        book2.setReleaseDate("2024/01/19");
        book2.setCondition("신규도서");

        Book book3 = new Book();
        book3.setBookId("isbn0003");
        book3.setName("혼자 공부하는 머신러닝 딥러닝");
        book3.setUnitPrice(BigDecimal.valueOf(25000));
        book3.setAuthor("박해선");
        book3.setDescription("이 책은 수식과 이론으로 중무장한 머신러닝, 딥러닝 책에 지친 ‘독학하는 입문자’가 ‘꼭 필요한 내용을 제대로’ 학습할 수 있도록 구성했다.");
        book3.setPublisher("한빛아카데미");
        book3.setCategory("IT전문서");
        book3.setUnitsInStock(1000);
        book3.setReleaseDate("2020/12/21");
        book3.setCondition("신규도서");

        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
    }

    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }
}
