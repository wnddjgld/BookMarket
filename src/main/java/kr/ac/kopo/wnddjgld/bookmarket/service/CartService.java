package kr.ac.kopo.wnddjgld.bookmarket.service;

import kr.ac.kopo.wnddjgld.bookmarket.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}