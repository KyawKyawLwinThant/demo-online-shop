package com.example.onlineshopdemo.controller;

import com.example.onlineshopdemo.domain.Cart;
import com.example.onlineshopdemo.domain.Products;
import com.example.onlineshopdemo.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    private final Cart cart;
    private final ProductsService productsService;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public CartController(Cart cart, ProductsService productsService) {
        this.cart = cart;
        this.productsService = productsService;
    }


    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable int id, HttpServletRequest request){

        boolean isExisted=false;
        for(Products products:cart.getCartItems()){
            if(products.getId()==id){
                isExisted=true;
            }
        }
        if(!isExisted){
            cart.addToCart(productsService.findById(id));
        }
        logger.info("Cart Size:"+ cart.cartSize());
        HttpSession session=request.getSession();
        session.setAttribute("cartSizes",cart.cartSize());
        return "redirect:/product/"+id;
    }
}
