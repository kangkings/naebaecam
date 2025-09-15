package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoTest {

    @DisplayName("")
    @Test
    void test(){
        // given
        Memo memo = new Memo("kang", "zzzz");
        // when
        assertEquals("kang",memo.getUsername());
        assertEquals("zzzz",memo.getContents());
        // then
    }

}