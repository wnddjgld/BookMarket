package kr.ac.kopo.wnddjgld.bookmarket.domain;

import lombok.Data;
import lombok. ToString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class Cart {
    private String cartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart() {
        cartItems = new HashMap<String, CartItem>();
        grandTotal = BigDecimal.ZERO;
    }
    public Cart(String cartId){
        this();
        this.cartId = cartId;
    }
}