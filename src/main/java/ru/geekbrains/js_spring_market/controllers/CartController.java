package ru.geekbrains.js_spring_market.controllers;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.js_spring_market.model.Book;
import ru.geekbrains.js_spring_market.model.Cart;
import ru.geekbrains.js_spring_market.service.BookService;
import ru.geekbrains.js_spring_market.service.CartService;

import java.util.List;

@RestController
public class CartController {
    private CartService cartService;
    private BookService bookService;

    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @GetMapping("/carts")
    public List<Cart> findAll(){
        return cartService.findAll();
    }

    //контроллер для добавления книги в корзину
    @PutMapping("/carts_add")
    public void updateCartAddItem(@RequestBody Book book, @RequestParam(name = "id") Long id)
    {
        bookService.addBookToCartByCartId(id, book);
    }

    //контроллер для удаления книги из корзины
    @PutMapping("/carts_delete")
    public void updateCartDeleteItem(@RequestBody Book book, @RequestParam (name = "id") Long id)
    {
        bookService.deleteBookFromCartByCartId(id, book);
    }
}
