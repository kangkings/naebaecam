package com.sparta.junit5practice;

import org.junit.jupiter.api.BeforeEach;

public class BeforeAfterTest {

    @BeforeEach
    void setUp() {
        System.out.println("각각의 테스트 코드가 실행되기 전에 수행");
    }
}
