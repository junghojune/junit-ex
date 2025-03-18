package com.hosu.testpractice.test1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class AssertEqualsTest {

    @Test
    void assertEqualsExTest() {
        int a = 2;
        int b = 2;

        assertEquals(a, b);
    }

    private String toUpperCase(String str) {
        if (str == null) {
            throw new NullPointerException("str is null");
        }
        return str.toUpperCase();
    }

    @Test
    void toUpperCaseThrowNullPointExceptionTrueTest() {
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                toUpperCase(null);
            }
        });
    }


    @Test
    void toUpperCaseThrowNullPointerException() {
        try {
            String str = toUpperCase(null);
            fail(); // 실패로 강제하고 싶을때 사용하는 메서드
        } catch (NullPointerException e) {
            assertEquals("str is null", e.getMessage());
        }
    }
}
