# Junit 학습

## @ParameterizedTest

테스트에 필요한 매개변수를 전달해주는 어노테이션 

### 사용 상황

한 개의 메서드가 다수의 테스트 케이스를 가지는 경우 사용하면 좋다.
테스트 케이스별 상이하게 적용해야 하는 테스트 데이터는 parameters로 전달 할 수 있어서 중복을 제거 할 수 있다.

### test method에 parameter 전달하는 방법

@ValueSourc(strings = {” ”, “chahca”})

- Test Method에 전달할 값(Parameter)을 어노테이션의 배열로 지정한다.
- Test Method는 배열 길이 만큼 실행되고, 배열의 요소가 하나씩 인자 값으로 전달 된다.
- TYPES은 인자 값으로 사용할 타입의 복수명사(ints, string, bytes, etc)로 선언 해야 한다.
    - int형 타입선언 예시 @ValueSourc(ints = {1, 2, 3, 4})

@CsvSource(value = {"1,2", "2, 4","3, 6"})

- 하나의 Test Method에 두개의 인수를 전달해야 하는 경우 사용한다.
- 하나는 테스트 메서드에 인자 값으로 사용하고 나머지 하나는 기대값으로 사용한다.
- CSV의 구분값(delimiter)은 기본적으로 ,(쉼표)이고 delimiter(char형) 또는
delimiterString(String형) 옵션을 이용해서 구분값을 지정 할 수 있다.

---

## @RepeatedTest

지정된 횟수(value)만큼 반복적으로 실행되도록 설정하는 어노테이션

### 사용 상황

10번 반복해서 테스트 해야 하는 경우, For 구문을 사용해서 Test Code를 작성 할 수도 있지만,  RepeatedTest 어노테이션을 사용하면 For 구문 없이 반복 실행할 수 있다.

### 문법

@RepeatedTest(value = 10, name = RepeatedTest.*LONG_DISPLAY_NAME*)

- value: 반복 횟수
- name = RepeatedTest.LONG_DISPLAY_NAME: Test명 명시

Default(SHORT) : "repetition " + 현재 반복 횟수 + " of " + 총 반복 횟수

![image.png](Junit%20%E1%84%92%E1%85%A1%E1%86%A8%E1%84%89%E1%85%B3%E1%86%B8%201c278f499da5807ebed9e54186c5045e/image.png)

---

## @TestFactory

동적으로 Test Method를 생성하는 팩토리 메서드를 정의하는 어노테이션

### 사용 상황

- 동적으로 다양한 Test Case를 검증해야 하는 경우
- 인수 테스트(E2) 처럼 사용자 시나리오 테스트를 하는 경우

### 문법

@TestFactory
List<DynamicNode> testFactory()

- Test Case를 생성하는 팩토리임을 알리는 기능을 한다.
- @TestFactory 어노테이션이 붙은 메서드는 private 및 static으로 선언 할 수 없다.

 Test Method 문법

- Return Type: Stream, Collection, Iterable, Iterator
    - <T>: DynamicNode
- Return Type이 Collections 타입을 반환하지 않는 경우, JUnitException이 발생하면서 테스트가
Fail로 종료된다.
