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