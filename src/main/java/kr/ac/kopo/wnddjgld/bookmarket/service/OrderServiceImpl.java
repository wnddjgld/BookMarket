package kr.ac.kopo.wnddjgld.bookmarket.service;

import kr.ac.kopo.wnddjgld.bookmarket.domain.Book;
import kr.ac.kopo.wnddjgld.bookmarket.domain.Order;
import kr.ac.kopo.wnddjgld.bookmarket.repository.BookRepository;
import kr.ac.kopo.wnddjgld.bookmarket.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void confirmOrder(String bookId, long quantity) { //도서 재고 수 확인
        Book bookById = bookRepository.getBookById(bookId);
        if(bookById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("도서 수량이 부족합니다. 구입 가능한 도서 수량: " + bookById.getUnitsInStock());
        }
        bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
    }

    @Override
    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        return orderId;
    }
}
