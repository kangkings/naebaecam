package com.springcloud.eureka.order1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Order1Application {

    public static void main(String[] args) {
        SpringApplication.run(Order1Application.class, args);
    }

}
