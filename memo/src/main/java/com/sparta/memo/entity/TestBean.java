package com.sparta.memo.entity;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
    @Value("${spring.datasource.url}")
    private String url;

    @PostConstruct
    public void init() {
        System.out.println("Datasource URL: " + url);
    }
}

