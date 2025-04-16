package kr.ac.kopo.wnddjgld.bookmarket.repository;

import kr.ac.kopo.wnddjgld.bookmarket.domain.Book;

import java.util.List;


public interface BookRepository {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category);
}
