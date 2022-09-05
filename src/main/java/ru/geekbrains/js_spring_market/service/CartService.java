package ru.geekbrains.js_spring_market.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.geekbrains.js_spring_market.model.Book;
import ru.geekbrains.js_spring_market.model.Cart;
import ru.geekbrains.js_spring_market.repository.CartRepository;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    @Cacheable("carts")
    public List<Cart> findAll(){return cartRepository.findAll();}

    public void addItemToCart(Long cartId, Book book){
        cartRepository.findById(cartId).get().getItems().add(book);
    }

    public void deleteItemFromCart(Long cartId, Book book){
        cartRepository.findById(cartId).get().getItems().remove(book);
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }

    @Cacheable
    public List<Book> findAllItemsInCartByCartId(Long id){
        return cartRepository.findById(id).get().getItems();
    }
}
