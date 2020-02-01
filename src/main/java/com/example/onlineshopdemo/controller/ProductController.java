package com.example.onlineshopdemo.controller;

import com.example.onlineshopdemo.domain.Products;
import com.example.onlineshopdemo.service.CategoryService;
import com.example.onlineshopdemo.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductsService productsService;
    private final CategoryService categoryService;

    public ProductController(ProductsService productsService, CategoryService categoryService) {
        this.productsService = productsService;
        this.categoryService = categoryService;
    }
    @GetMapping("/product")
    public String create(Model model){
        model.addAttribute("products",new Products());
        model.addAttribute("cateogries",categoryService.findAll());
        return "admin/productForm";
    }
    @PostMapping("/product")
    public String process(@Valid Products products, BindingResult result, RedirectAttributes redirectAttributes,Model model){
        if (result.hasErrors()){
            model.addAttribute("cateogries",categoryService.findAll());
            return "admin/productForm";
        }
        productsService.create(products);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String showAllProducts(Model model){
        model.addAttribute("products",productsService.findAll());
        model.addAttribute("success",model.containsAttribute("success"));
        return "admin/products";
    }

    @GetMapping("/home")
    public String goHome(){
        return "user/home";
    }


    @GetMapping("/product/category/{id}")
    public String productsByCategory(@PathVariable("id")int id,Model model){
            model.addAttribute("products",productsService.findProductsByCategoryid(id));
            return "user/products";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable int id, Model model, HttpServletRequest request){
        model.addAttribute("product",productsService.findById(id));
        HttpSession session=request.getSession(false);
        if(session!=null){
            model.addAttribute("cartSize",session.getAttribute("cartSizes"));
        }
        return "user/product";
    }

}
