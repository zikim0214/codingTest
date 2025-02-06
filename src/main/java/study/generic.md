### **✅ 제네릭 타입 매개변수별 사용 예제**

| 타입 매개변수 | 의미 | 사용 예제 |
|-------------|--------------------------|------------------------------------------------|
| **`E`** | 컬렉션 요소의 타입 (Element) | `List<E>`, `Queue<E>`, `Set<E>` |
| **`T`** | 일반적인 타입 (Type) | `Box<T>`, `Pair<T, U>` |
| **`K, V`** | 맵의 키-값 타입 (Key, Value) | `Map<K, V>`, `HashMap<K, V>` |
| **`?`** | 알 수 없는 타입 (Wildcard) | `List<?>`, `Collection<? extends Number>` |

---

## **📌 1. `E` (Element) – 컬렉션 요소 타입**
📌 **컬렉션 프레임워크에서 요소 타입을 일반화할 때 사용**
```java
import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();  // E가 String으로 대체됨

        queue.offer("apple");
        queue.offer("banana");

        String fruit = queue.poll();  // poll()의 반환 타입 E가 String으로 대체됨
        System.out.println(fruit); // apple
    }
}
```
**📌 `E`의 역할:**
- `Queue<E>`는 요소 타입을 일반화함 → `E`가 `String`으로 변환됨
- `offer(E e)`, `poll()`에서 `E`가 `String`으로 대체됨

---

## **📌 2. `T` (Type) – 일반적인 타입 매개변수**
📌 **제네릭 클래스에서 다양한 타입을 다룰 때 사용**
```java
class Box<T> {  // T는 어떤 타입이든 가능
    private T item;

    public void setItem(T item) { this.item = item; }
    public T getItem() { return item; }
}

public class GenericExample {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello");
        System.out.println(stringBox.getItem()); // Hello

        Box<Integer> intBox = new Box<>();
        intBox.setItem(100);
        System.out.println(intBox.getItem()); // 100
    }
}
```
**📌 `T`의 역할:**
- `T`는 `String`, `Integer` 등 어떤 타입이든 사용 가능
- **런타임이 아니라 컴파일 타임에 타입이 결정됨**

---

## **📌 3. `K, V` (Key, Value) – 맵의 키-값 타입**
📌 **맵 자료구조에서 키-값 쌍을 다룰 때 사용**
```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();  // K → String, V → Integer

        map.put("apple", 10);
        map.put("banana", 5);

        int value = map.get("apple");  // V → Integer
        System.out.println(value); // 10
    }
}
```
**📌 `K, V`의 역할:**
- `K`는 `String`, `V`는 `Integer`로 변환됨
- **유연한 데이터 저장 가능** (예: `Map<Integer, String>`, `Map<String, Double>` 등)

---

## **📌 4. `?` (Wildcard) – 알 수 없는 타입**
📌 **타입을 제한하지 않고 범용적으로 사용할 때 사용**
### **(1) `List<?>` – 어떤 타입이든 받을 수 있음**
```java
import java.util.*;

public class WildcardExample {
    public static void printList(List<?> list) {  // ?는 모든 타입 허용
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "cherry");
        List<Integer> intList = Arrays.asList(1, 2, 3);

        printList(stringList); // apple, banana, cherry
        printList(intList);    // 1, 2, 3
    }
}
```
📌 **`List<?>`의 역할:**
- 어떤 타입의 `List`든 받을 수 있음
- `List<String>`, `List<Integer>` 등 다양한 타입을 지원

---

### **(2) `? extends Number` – 상한 경계 와일드카드**
📌 **Number 또는 그 하위 타입만 허용 (`Integer`, `Double` 등)**
```java
import java.util.*;

public class UpperBoundWildcard {
    public static double sumList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();  // Number의 메서드 사용 가능
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println(sumList(intList)); // 6.0
        System.out.println(sumList(doubleList)); // 7.5
    }
}
```
📌 **`? extends Number`의 역할:**
- `Number`의 하위 타입(`Integer`, `Double`)만 허용
- `doubleValue()` 등 `Number`의 메서드 사용 가능

---

### **(3) `? super Integer` – 하한 경계 와일드카드**
📌 **Integer 또는 그 상위 타입 (`Number`, `Object`)만 허용**
```java
import java.util.*;

public class LowerBoundWildcard {
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        addIntegers(numberList);

        System.out.println(numberList); // [10, 20]
    }
}
```
📌 **`? super Integer`의 역할:**
- `Integer` 또는 그 상위 타입(`Number`, `Object`)만 허용
- `list.add(10);` 가능 (하위 타입 추가 가능)

---

## **🚀 정리**
| 제네릭 기호 | 의미 | 사용 예제 |
|-------------|--------------------------|------------------------------------------------|
| **`E`** | 컬렉션 요소의 타입 (Element) | `Queue<E>`, `List<E>` (예: `Queue<String>`) |
| **`T`** | 일반적인 타입 (Type) | `Box<T>`, `Pair<T, U>` (예: `Box<Integer>`) |
| **`K, V`** | 맵의 키-값 타입 (Key, Value) | `Map<K, V>`, `HashMap<K, V>` (예: `Map<String, Integer>`) |
| **`?`** | 알 수 없는 타입 (Wildcard) | `List<?>`, `Collection<? extends Number>` |

✅ **제네릭을 활용하면 타입 안정성과 코드 재사용성이 향상됨** 🚀