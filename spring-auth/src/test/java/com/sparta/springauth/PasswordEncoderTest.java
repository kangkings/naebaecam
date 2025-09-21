package com.sparta.springauth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @DisplayName("수동 등록한 passwordEncoder 테스트")
    @Test
    void test(){
        // given
        String password = "password";
        // when

        String encodedPassword = passwordEncoder.encode(password);
        System.out.println("encodedPassword = " + encodedPassword);

        String input = "kang";
        // then
        boolean matches = passwordEncoder.matches(input,encodedPassword);
        System.out.println("matches = " + matches);
    }
}
