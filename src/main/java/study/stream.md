Java의 `Stream` 메서드는 Java 8에서 도입된 기능으로, 컬렉션(예: List, Set)이나 배열 등의 데이터 소스를 처리하고 조작하는 방법을 제공합니다. `Stream` API는 함수형 프로그래밍 스타일을 사용하여 데이터 처리를 간결하고 효율적으로 수행할 수 있도록 도와줍니다.

`Stream` API는 크게 두 가지 작업으로 나뉩니다:
1. **중간 연산 (Intermediate Operations)**: 스트림을 변환하거나 필터링하는 작업. 중간 연산은 스트림을 반환하며, 연산이 호출된 시점에서 실제로 실행되지 않고, 종단 연산이 호출될 때까지 지연됩니다.
2. **종단 연산 (Terminal Operations)**: 스트림을 처리하고 결과를 생성하는 작업. 종단 연산은 스트림을 소비하며, 연산이 호출된 시점에서 실제로 실행됩니다.

아래에 주요 `Stream` 메서드들을 설명하겠습니다:

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

3. **`sorted`**
    - 요소를 정렬하여 새로운 스트림을 반환합니다.
   ```java
   List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
   Stream<String> sortedStream = names.stream().sorted();
   ```

4. **`distinct`**
    - 중복된 요소를 제거하여 새로운 스트림을 반환합니다.
   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
   Stream<Integer> distinctStream = numbers.stream().distinct();
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

`Stream` API는 데이터 처리 파이프라인을 쉽게 구성하고, 병렬 처리도 간단히 수행할 수 있게 해줍니다. 이를 통해 코드의 가독성과 유지보수성을 높일 수 있습니다.