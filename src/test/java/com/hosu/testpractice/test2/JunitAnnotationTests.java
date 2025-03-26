package com.hosu.testpractice.test2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import com.hosu.testpractice.domain.user.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitAnnotationTests {

    @Test
    @DisplayName("User의 이름은 Null이면 예외 발생")
    void userNameNullThenException() {
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름은 공백이면 예외 발생")
    void userNameIsBlankThenException() {
        assertThatThrownBy(() -> new User(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 위 두개의 방법을 한번에 테스트는 하는 방법
    @ParameterizedTest // 인자값이 중복일때 사용하면 좋다
    @ValueSource(strings = {" ", ""})
    @NullAndEmptySource
    void parameterizedTestExample(String userName) {
        System.out.println("username => " + userName);
        assertThatThrownBy(() -> new User(userName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "2, 4", "2, 6"})
    void csvSourceExampleTest(int input, int expected){
        assertEquals(expected, input * 2);
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME) // SHORT_DISPLAY_NAME 이 기본값
    void repeatedTestExample(RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        assertEquals(currentRepetition, repetitionInfo.getTotalRepetitions());

    }

    @TestFactory
    List<DynamicNode> testFactoryExampleTests() {
        // 동적으로 값을 가져와서 사용해야 할 경우 해당 메소드를 이용한다
        int size = 10;
        List<DynamicNode> result = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            int finalI = i;
            result.add(dynamicTest("Test CaseName" + i, () -> System.out.println("Dynamic Test #" + finalI)));
        }
        return result;
    }
}
