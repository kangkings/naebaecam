package com.example.redis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    //String은 레디스 자료형이 아닌 자바의 자료형
    //RedisTemplate을 상속받은 클래스
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, ItemDto> itemRedisTemplate;

    @DisplayName("")
    @Test
    void stringOpsTest() {
        // given
        //지금 레디스 템플릿에 설정된 타입을 바탕으로
        //레디스 문자열 조작을 할거다
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        // when
        ops.set("name", "test");
        System.out.println(ops.get("name"));
        // then
        SetOperations<String, String> setOps = stringRedisTemplate.opsForSet();
        setOps.add("hobbies", "hobby1");
        setOps.add("hobbies", "hobby2", "hobby3");
        System.out.println(setOps.size("hobbies"));

        stringRedisTemplate.expire("hobbies", 10, TimeUnit.SECONDS);
    }

    @DisplayName("")
    @Test
    void itemRedisTemplateTest() {
        // given
        ValueOperations<String, ItemDto> ops = itemRedisTemplate.opsForValue();
        ops.set("my:keyboard", ItemDto.builder()
                .name("기계식")
                        .price(11111)
                        .description("OMG")
                .build());
        // when
        System.out.println(ops.get("my:keyboard"));
        // then
        HashOperations<String, String, ItemDto> hashOps = itemRedisTemplate.opsForHash();
        hashOps.put("mouse","12345",ItemDto.builder()
                .name("기계식")
                .price(11111)
                .description("OMG")
                .build());

    }
}
