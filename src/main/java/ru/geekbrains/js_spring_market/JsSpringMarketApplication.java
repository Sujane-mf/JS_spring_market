package ru.geekbrains.js_spring_market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JsSpringMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsSpringMarketApplication.class, args);
    }

}
