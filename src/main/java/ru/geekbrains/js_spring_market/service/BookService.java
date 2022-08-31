package ru.geekbrains.js_spring_market.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.js_spring_market.model.Book;
import ru.geekbrains.js_spring_market.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private CartService cartService;

    public BookService(BookRepository bookRepository, CartService cartService) {
        this.bookRepository = bookRepository;
        this.cartService = cartService;
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    @Cacheable("books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book save(Book book){
        return (Book) bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book book){
        Book updated_book = findById(book.getId()).get();
        updated_book.setName(book.getName());
        updated_book.setPage_count(book.getPage_count());
        updated_book.setCost(book.getCost());
    }

    @CacheEvict("books")
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    public void addBookToCartByCartId(Long cartId, Book book){
        cartService.addItemToCart(cartId, book);
    }

    public void deleteBookFromCartByCartId(Long cartId, Book book){
        cartService.deleteItemFromCart(cartId, book);
    }


}
