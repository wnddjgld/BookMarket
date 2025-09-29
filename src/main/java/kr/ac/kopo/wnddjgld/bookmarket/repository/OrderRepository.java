package kr.ac.kopo.wnddjgld.bookmarket.repository;

import kr.ac.kopo.wnddjgld.bookmarket.domain.Order;

public interface OrderRepository {
    // 주문 목록 저장
    Long saveOrder(Order order);
}
