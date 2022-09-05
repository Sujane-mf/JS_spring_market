package ru.geekbrains.js_spring_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.js_spring_market.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
