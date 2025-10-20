package kr.ac.kopo.wnddjgld.bookmarket.repository;

import kr.ac.kopo.wnddjgld.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {

    List<Book> getAllBookList();
    List<Book> getBookListByCategory(String category);
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);
    Book getBookById(String bookId);
    void setNewBook(Book book);


}