package com.hosu.testpractice.test1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitProcessTest {
    public JunitProcessTest() {
        System.out.println("Constructor");
    }

    @BeforeAll
    public static void classAll(){
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("BeforeEach");
    }

    @Test
    public void testForTest(){
        System.out.println("TEST");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("AfterEach");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("AfterAll");
    }
}
