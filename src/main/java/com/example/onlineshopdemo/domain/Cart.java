package com.example.onlineshopdemo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Cart  {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private Set<Products> cartItems =new HashSet<>();


    public void addToCart(Products products){
        cartItems.add(products);
    }

    public void clearCart(){
        cartItems.clear();
    }

    public int cartSize(){
        if(cartItems.isEmpty()){
            return 0;
        }

        logger.info("Cart Domain "+ cartItems.size());
        return cartItems.size();
    }

    public Set<Products> getCartItems(){
        return this.cartItems;
    }
}
