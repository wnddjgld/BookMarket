package kr.ac.kopo.wnddjgld.bookmarket.repository;

import kr.ac.kopo.wnddjgld.bookmarket.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
}