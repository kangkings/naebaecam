package com.example.test2;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

    @Value("${custom}")
    private String str;
    @PostConstruct
    public void printStr(){
        System.out.println("-----------------------------");
        System.out.println(str);
        System.out.println("-----------------------------");
    }


}
