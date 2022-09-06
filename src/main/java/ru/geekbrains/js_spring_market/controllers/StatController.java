package ru.geekbrains.js_spring_market.controllers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.bind.annotation.GetMapping;
import ru.geekbrains.js_spring_market.model.Cart;
import ru.geekbrains.js_spring_market.service.AppLoggingAspect;
import ru.geekbrains.js_spring_market.service.StatService;

import java.util.List;
import java.util.Map;


public class StatController {
private StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/statistic")
    public Map<Class, Long> findAll(){
        return statService.doStat(statService.getMap());
    }
}
