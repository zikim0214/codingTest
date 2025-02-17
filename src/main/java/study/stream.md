```java name=StreamAPIExample.java
import java.util.*;
import java.util.stream.*;

public class StreamAPIExample {
    public static void main(String[] args) {
        // List를 스트림으로 변환
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> listStream = list.stream();
        listStream.forEach(System.out::println);

        // Map을 스트림으로 변환 (키, 값 쌍)
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);
        Stream<Map.Entry<String, Integer>> mapStream = map.entrySet().stream();
        mapStream.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // Map의 키를 스트림으로 변환
        Stream<String> keyStream = map.keySet().stream();
        keyStream.forEach(System.out::println);

        // Map의 값을 스트림으로 변환
        Stream<Integer> valueStream = map.values().stream();
        valueStream.forEach(System.out::println);

        // 배열을 스트림으로 변환
        String[] array = {"Alice", "Bob", "Charlie"};
        Stream<String> arrayStream = Arrays.stream(array);
        arrayStream.forEach(System.out::println);

        // 기본형 배열을 스트림으로 변환
        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intArrayStream = Arrays.stream(intArray);
        intArrayStream.forEach(System.out::println);

        // iterate 메서드를 사용하여 스트림 생성
        Stream<Integer> iteratedStream = Stream.iterate(0, n -> n + 2).limit(5);
        iteratedStream.forEach(System.out::println);

        // peek 메서드를 사용하여 중간에 요소를 확인
        List<String> peekList = Arrays.asList("Alice", "Bob", "Charlie");
        peekList.stream()
                .peek(name -> System.out.println("Before filter: " + name))
                .filter(name -> name.startsWith("A"))
                .peek(name -> System.out.println("After filter: " + name))
                .collect(Collectors.toList());
    }
}
```

### `Stream` API는 Java 8에서 도입된 기능으로, 컬렉션(예: List, Set)이나 배열 등의 데이터 소스를 처리하고 조작하는 방법을 제공합니다. `Stream` API는 함수형 프로그래밍 스타일을 사용하여 데이터 처리를 간결하고 효율적으로 수행할 수 있도록 도와줍니다.

`Stream` API는 크게 두 가지 작업으로 나뉩니다:
1. **중간 연산 (Intermediate Operations)**: 스트림을 변환하거나 필터링하는 작업. 중간 연산은 스트림을 반환하며, 연산이 호출된 시점에서 실제로 실행되지 않고, 종단 연산이 호출될 때까지 지연됩니다.
2. **종단 연산 (Terminal Operations)**: 스트림을 처리하고 결과를 생성하는 작업. 종단 연산은 스트림을 소비하며, 연산이 호출된 시점에서 실제로 실행됩니다.

### 중간 연산 (Intermediate Operations)

1. **`filter`**
    - 요소를 필터링하여 조건을 만족하는 요소만 포함하는 스트림을 반환합니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Stream<String> filteredStream = names.stream().filter(name -> name.startsWith("A"));
    ```

2. **`map`**
    - 요소를 다른 형태로 변환하여 새로운 스트림을 반환합니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Stream<Integer> nameLengths = names.stream().map(String::length);
    ```

3. **`mapToInt`**
    - 요소를 `IntStream`으로 변환합니다. 주로 래퍼형 스트림에서 기본형 스트림으로 변환할 때 사용됩니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    IntStream nameLengths = names.stream().mapToInt(String::length);
    ```

4. **`sorted`**
    - 요소를 정렬하여 새로운 스트림을 반환합니다.
    ```java
    List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
    Stream<String> sortedStream = names.stream().sorted();
    ```

5. **`distinct`**
    - 중복된 요소를 제거하여 새로운 스트림을 반환합니다.
    ```java
    List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
    Stream<Integer> distinctStream = numbers.stream().distinct();
    ```

6. **`boxed`**
    - 기본형 스트림을 객체 스트림으로 변환합니다. 주로 `IntStream`, `LongStream`, `DoubleStream`과 같은 기본형 스트림에서 사용됩니다.
    ```java
    IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
    Stream<Integer> boxedStream = intStream.boxed();
    ```

7. **`peek`**
    - 스트림의 각 요소를 소비하지 않고 중간에 요소를 확인할 수 있습니다. 주로 디버깅 목적으로 사용됩니다.
    ```java
    List<String> peekList = Arrays.asList("Alice", "Bob", "Charlie");
    peekList.stream()
            .peek(name -> System.out.println("Before filter: " + name))
            .filter(name -> name.startsWith("A"))
            .peek(name -> System.out.println("After filter: " + name))
            .collect(Collectors.toList());
    ```

### 종단 연산 (Terminal Operations)

1. **`collect`**
    - 스트림의 요소를 컬렉션으로 변환합니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    List<String> filteredNames = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
    ```

2. **`forEach`**
    - 스트림의 각 요소에 대해 작업을 수행합니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    names.stream().forEach(System.out::println);
    ```

3. **`reduce`**
    - 스트림의 요소를 하나의 값으로 결합합니다.
    ```java
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    int sum = numbers.stream().reduce(0, Integer::sum);
    ```

4. **`count`**
    - 스트림의 요소 개수를 반환합니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    long count = names.stream().count();
    ```

5. **`findFirst`**
    - 스트림의 첫 번째 요소를 반환합니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Optional<String> first = names.stream().findFirst();
    ```

6. **`anyMatch`, `allMatch`, `noneMatch`**
    - 스트림의 요소가 특정 조건을 만족하는지 검사합니다.
    ```java
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    boolean anyStartsWithA = names.stream().anyMatch(name -> name.startsWith("A"));
    ```

### `IntStream`, `LongStream`, `DoubleStream`

Java 8에서는 기본형 특화 스트림인 `IntStream`, `LongStream`, `DoubleStream`도 도입되었습니다. 이들 스트림은 기본형 데이터를 효율적으로 처리할 수 있도록 설계되었습니다.

1. **`IntStream` 예제**
    ```java
    IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
    int sum = intStream.sum();
    ```

2. **`LongStream` 예제**
    ```java
    LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L);
    long max = longStream.max().orElse(0L);
    ```

3. **`DoubleStream` 예제**
    ```java
    DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
    double average = doubleStream.average().orElse(0.0);
    ```

### 컬렉션 요소들을 스트림으로 변환

1. **List를 스트림으로 변환**
    ```java
    List<String> list = Arrays.asList("Alice", "Bob", "Charlie");
    Stream<String> listStream = list.stream();
    listStream.forEach(System.out::println);
    ```

2. **Map을 스트림으로 변환 (키, 값 쌍)**
    ```java
    Map<String, Integer> map = new HashMap<>();
    map.put("Alice", 30);
    map.put("Bob", 25);
    map.put("Charlie", 35);
    Stream<Map.Entry<String, Integer>> mapStream = map.entrySet().stream();
    mapStream.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    ```

3. **Map의 키를 스트림으로 변환**
    ```java
    Stream<String> keyStream = map.keySet().stream();
    keyStream.forEach(System.out::println);
    ```

4. **Map의 값을 스트림으로 변환**
    ```java
    Stream<Integer> valueStream = map.values().stream();
    valueStream.forEach(System.out::println);
    ```

5. **배열을 스트림으로 변환**
    ```java
    String[] array = {"Alice", "Bob", "Charlie"};
    Stream<String> arrayStream = Arrays.stream(array);
    arrayStream.forEach(System.out::println);
    ```

6. **기본형 배열을 스트림으로 변환**
    ```java
    int[] intArray = {1, 2, 3, 4, 5};
    IntStream intArrayStream = Arrays.stream(intArray);
    intArrayStream.forEach(System.out::println);
    ```

7. **iterate 메서드를 사용하여 스트림 생성**
    - 무한 스트림을 생성하고 지정된 조건으로 요소를 생성할 수 있습니다.
    ```java
    Stream<Integer> iteratedStream = Stream.iterate(0, n -> n + 2).limit(5);
    iteratedStream.forEach(System.out::println);
    ```

`Stream` API는 데이터 처리 파이프라인을 쉽게 구성하고, 병렬 처리도 간단히 수행할 수 있게 해줍니다. 이를 통해 코드의 가독성과 유지보수성을 높일 수 있습니다.
```
`forEach` 함수는 스트림의 각 요소를 순회하며 특정 작업을 수행하는데 사용됩니다. 하지만 `forEach`는 스트림의 요소를 변환하거나 필터링하여 새로운 스트림을 생성하지 않습니다. 만약 스트림의 요소를 변환하거나 필터링하여 새로운 배열로 반환하고자 한다면, `map`, `filter`와 같은 변환 및 필터링 메서드를 사용하는 것이 더 적합합니다.

### `forEach`와 `map`, `filter`의 차이

- **`forEach`**: 스트림의 각 요소에 대해 주어진 작업을 수행합니다. 반환값이 없으며, 주로 부작용이 있는 작업(예: 출력, 로그 기록 등)에 사용됩니다.
  
  ```java
  Arrays.stream(intStrs).forEach(intStr -> System.out.println(intStr));
  ```

- **`map`**: 스트림의 각 요소를 주어진 함수에 따라 변환하여 새로운 스트림을 생성합니다.
  
  ```java
  Arrays.stream(intStrs).map(intStr -> intStr.substring(s, s + l));
  ```

- **`filter`**: 스트림의 각 요소를 주어진 조건에 따라 필터링하여 새로운 스트림을 생성합니다.
  
  ```java
  Arrays.stream(intStrs).filter(intStr -> intStr.length() > k);
  ```

### `forEach` 대신 `map`과 `filter` 사용 예제

아래는 `forEach`를 사용하지 않고 `map`과 `filter`를 사용하여 문제를 해결하는 예제입니다:

```java name=lessons_181912_배열_만들기5.java
import java.util.Arrays;

public class lessons_181912_배열_만들기5 {
    public static int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
                     .map(intStr -> intStr.substring(s, s + l))  // 부분 문자열 추출
                     .mapToInt(Integer::parseInt)               // 정수로 변환
                     .filter(subStrToInt -> subStrToInt > k)     // 필터링
                     .toArray();                                // 배열로 변환
    }

    public static void main(String[] args) {
        String[] intStrs = {"0123456789", "9876543210", "9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;
        System.out.println(Arrays.toString(solution(intStrs, k, s, l)));
    }
}
```

### 결론

`forEach`는 스트림의 각 요소에 대해 작업을 수행하는데 유용하지만, 변환 및 필터링 작업에는 적합하지 않습니다. 변환 및 필터링 작업에는 `map`, `filter`와 같은 메서드를 사용하는 것이 더 적합하며, 이를 통해 원하는 결과를 얻을 수 있습니다.


기본형 스트림과 객체 스트림의 차이를 이해하는 것은 Java Stream API를 효과적으로 사용하는 데 매우 중요합니다. 이 두 가지 스트림은 데이터 처리 및 변환에 있어 서로 다른 기능과 성능 최적화를 제공합니다.

## 기본형 스트림 vs 객체 스트림

### 기본형 스트림 (Primitive Streams)
기본형 스트림은 기본형 데이터를 효율적으로 처리하기 위해 설계된 스트림입니다. Java는 기본형 스트림을 위해 `IntStream`, `LongStream`, `DoubleStream`을 제공합니다. 기본형 스트림은 박싱과 언박싱을 피하여 성능을 최적화합니다.

- **IntStream**: `int` 타입의 스트림
- **LongStream**: `long` 타입의 스트림
- **DoubleStream**: `double` 타입의 스트림

### 객체 스트림 (Object Streams)
객체 스트림은 객체 데이터를 처리하는 일반적인 스트림입니다. 모든 참조 타입(객체)을 처리할 수 있으며, 더 많은 중간 연산과 종단 연산을 제공합니다.

- **Stream<T>**: 제네릭 타입 `T`의 스트림

### 주요 차이점

1. **데이터 타입**:
   - 기본형 스트림은 `int`, `long`, `double`과 같은 기본형 데이터를 처리합니다.
   - 객체 스트림은 모든 참조 타입(객체)을 처리합니다.

2. **성능**:
   - 기본형 스트림은 박싱과 언박싱을 피하여 성능을 최적화합니다.
   - 객체 스트림은 박싱과 언박싱이 필요할 수 있으므로 성능이 약간 떨어질 수 있습니다.

3. **메서드**:
   - 기본형 스트림은 기본형 데이터에 특화된 메서드를 제공합니다 (`sum`, `average`, `min`, `max` 등).
   - 객체 스트림은 일반적인 중간 연산 (`map`, `filter`, `flatMap` 등)과 종단 연산 (`collect`, `reduce` 등)을 제공합니다.

### 예제 코드

기본형 스트림과 객체 스트림을 사용하는 예제를 통해 차이를 이해해보겠습니다.

```java name=PrimitiveStreamExample.java
import java.util.stream.IntStream;

public class PrimitiveStreamExample {
    public static void main(String[] args) {
        // IntStream 사용 예제
        int[] intArray = {1, 2, 3, 4, 5};

        // IntStream을 사용하여 각 요소를 두 배로 만들고 합계 구하기
        int sum = IntStream.of(intArray)
                           .map(n -> n * 2)
                           .sum();

        System.out.println("Sum of doubled values: " + sum);
    }
}
```

```java name=ObjectStreamExample.java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectStreamExample {
    public static void main(String[] args) {
        // 객체 스트림 사용 예제
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");

        // 객체 스트림을 사용하여 문자열을 정수로 변환하고 각 요소를 두 배로 만들어 리스트로 수집
        List<Integer> doubledList = stringList.stream()
                                              .map(Integer::parseInt)
                                              .map(n -> n * 2)
                                              .collect(Collectors.toList());

        System.out.println("List of doubled values: " + doubledList);
    }
}
```

### 주요 차이점 요약

- **데이터 타입**: 기본형 스트림은 기본형 데이터를, 객체 스트림은 객체 데이터를 처리합니다.
- **성능 최적화**: 기본형 스트림은 박싱과 언박싱을 피하여 성능을 최적화합니다.
- **메서드 제공**: 기본형 스트림은 기본형 데이터에 특화된 메서드를, 객체 스트림은 더 많은 중간 및 종단 연산을 제공합니다.

이 예제들을 통해 기본형 스트림과 객체 스트림의 차이를 더 잘 이해할 수 있을 것입니다. 추가적인 질문이 있으면 언제든지 말씀해 주세요!




이 설명은 Java의 `Stream<T>` 인터페이스에 있는 `collect` 메서드에 대한 것입니다. `collect` 메서드는 스트림의 요소들을 수집하여 최종 결과를 생성하는데 사용됩니다. 이를 위해 `Collector`를 사용하며, `Collector`는 수집 전략을 캡슐화한 객체입니다. 이 메서드는 스트림의 요소를 변환하여 원하는 자료 구조로 만들거나, 특정 기준에 따라 그룹화하거나, 다른 방식으로 축약하는 데 사용됩니다.

### 주요 내용
- **`collect` 메서드**:
  - 스트림의 요소를 수집하여 최종 결과를 생성하는 데 사용됩니다.
  - `Collector` 객체를 매개변수로 받아서 수집 전략을 정의합니다.
  - 이 메서드는 스트림의 최종 연산(terminal operation)입니다.

### 매개변수
- **`collector`**: 스트림의 요소를 수집하는 방법을 정의하는 `Collector` 객체입니다.

### 반환값
- **수집 결과**: `Collector`가 정의한 방식대로 수집된 최종 결과를 반환합니다.

### API 사용 예제
1. **문자열 스트림을 리스트로 수집**:
   ```java
   List<String> asList = stringStream.collect(Collectors.toList());
   ```

2. **`Person` 객체를 도시에 따라 그룹화**:
   ```java
   Map<String, List<Person>> peopleByCity = personStream.collect(Collectors.groupingBy(Person::getCity));
   ```

3. **`Person` 객체를 주와 도시에 따라 그룹화**:
   ```java
   Map<String, Map<String, List<Person>>> peopleByStateAndCity = personStream.collect(Collectors.groupingBy(Person::getState, Collectors.groupingBy(Person::getCity)));
   ```

### 참고
- `Collectors` 클래스는 다양한 수집 전략을 제공하는 정적 메서드를 포함하고 있습니다.
- 병렬 스트림에서 동작할 때, `Collector`가 concurrent하고 스트림이 정렬되지 않았거나 `Collector`가 정렬되지 않았다면 병렬 수집이 수행됩니다.
- 병렬 수집 중에는 여러 개의 중간 결과가 생성, 채워지고 병합되어 안전하게 동작합니다. 따라서 비동기 데이터 구조(예: `ArrayList`)를 사용할 때도 추가적인 동기화가 필요하지 않습니다.

### 예제 코드

```java name=StreamCollectExample.java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectExample {
    public static void main(String[] args) {
        // 예제 1: 문자열 스트림을 리스트로 수집
        Stream<String> stringStream = Stream.of("apple", "banana", "cherry");
        List<String> asList = stringStream.collect(Collectors.toList());
        System.out.println(asList);

        // 예제 2: Person 객체를 도시에 따라 그룹화
        List<Person> people = Arrays.asList(
            new Person("Alice", "New York"),
            new Person("Bob", "San Francisco"),
            new Person("Charlie", "New York")
        );
        Map<String, List<Person>> peopleByCity = people.stream()
                                                       .collect(Collectors.groupingBy(Person::getCity));
        System.out.println(peopleByCity);

        // 예제 3: Person 객체를 주와 도시에 따라 그룹화
        List<Person> peopleWithState = Arrays.asList(
            new Person("Alice", "New York", "NY"),
            new Person("Bob", "San Francisco", "CA"),
            new Person("Charlie", "New York", "NY")
        );
        Map<String, Map<String, List<Person>>> peopleByStateAndCity = peopleWithState.stream()
                                                                                     .collect(Collectors.groupingBy(Person::getState, Collectors.groupingBy(Person::getCity)));
        System.out.println(peopleByStateAndCity);
    }
}

class Person {
    private String name;
    private String city;
    private String state;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Person(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return name + " (" + city + ", " + state + ")";
    }
}
```

이 예제 코드에서는 `Stream`의 `collect` 메서드를 사용하여 다양한 방법으로 데이터를 수집하는 방법을 보여줍니다. `Person` 클래스는 도시와 주 정보를 포함한 객체를 나타냅니다.