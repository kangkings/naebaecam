package com.example.redis;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//레디스 키를 구분하는 용도
//Entity 대신
@RedisHash("item")
public class Item implements Serializable {

    @Id
    private Long id;
    private String name;
    private String description;
    private Integer price;
}
