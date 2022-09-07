package ru.geekbrains.js_spring_market.service;

import java.util.Map;

public class StatService {
    private AppLoggingAspect appLoggingAspect;
    private Map<Class, Long> map;

    public StatService(AppLoggingAspect appLoggingAspect, Map<Class, Long> map) {
        this.appLoggingAspect = appLoggingAspect;
        this.map = map;
    }

    public Map<Class, Long> getMap() {
        return map;
    }

    public void addBookTime(Long time){
        map.put(BookService.class, appLoggingAspect.getBookTime());
    }

    public void addCartTime(Long time){
        map.put(CartService.class, appLoggingAspect.getCartTime());
    }

    public Map doStat(Map<Class, Long> map){
        return map;
    }
}
