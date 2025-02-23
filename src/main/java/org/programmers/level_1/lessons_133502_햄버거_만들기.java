package org.programmers.level_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/133502">햄버거 만들기</a>
 */
public class lessons_133502_햄버거_만들기 {
    public static int solution(int[] ingredient) {
        int answer = 0;
//        Queue<Integer> queue = new ArrayDeque<>();
        // FIFO, LIFO
        // 1 2 3 1 인 순서가 존재할 경우에만 만들어짐
        // 거꾸로 생각해보자 앞에가 1인 경우보다 끝에가 1인 경우 일일히 넣기보다 끝자락부터 생각하는게 더 효율적
        // 4개 이상일때부터 끝에서부터 점검하는게 더 효율적 어차피 4개부터 성립이 되는데 미리 확인하는건 별로임.
//        for (int i : ingredient) {
//            queue.add(i);
//            int size = queue.size();
//            if (size >= 4) {
//                if (queue.toArray()[size - 1].equals(1) &&
//                        queue.toArray()[size - 2].equals(3) &&
//                        queue.toArray()[size - 3].equals(2) &&
//                        queue.toArray()[size - 4].equals(1)
//                ) {
//                    answer++;
//                }
//            }
//        }

//        Deque<Integer> deque = new ArrayDeque<>();
//
//        for (int i : ingredient) {
//            deque.add(i);
//            int size = deque.size();
//            Integer[] lastFour = deque.toArray(new Integer[0]);
//            if (size >= 4) {
//                if (lastFour[size - 4] == 1 &&
//                        lastFour[size - 3] == 2 &&
//                        lastFour[size - 2] == 3 &&
//                        lastFour[size - 1] == 1) {
//                    // 4개 제거
//                    deque.pollLast();
//                    deque.pollLast();
//                    deque.pollLast();
//                    deque.pollLast();
//                    answer++;
//                }
//            }
//        }

        Stack<Integer> stack = new Stack<>();

        for (int ing : ingredient) {
            stack.push(ing);
            // 스택에 4개 이상 쌓이면 패턴 확인
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 4) == 1 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 1) == 1) {
                    // 패턴 맞으면 4개 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }

    /*조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고
    상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장
    재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시

    상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]*/
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(solution(ingredient));
    }
}

/*
        1. 자료구조 구현의 차이
Stack:
자바의 Stack 클래스는 Vector를 상속받아 만들어졌어요. Vector는 동기화(synchronized)된 배열 기반 구조라서 내부적으로 단순한 배열을 사용.
push()와 pop()은 배열의 끝에 직접 접근해서 연산하니까 메모리 접근이 빠르고 캐시 친화적(cache-friendly).
단점은 동기화 때문에 약간의 오버헤드가 있지만, 이 문제에선 동기화가 필요 없어도 기본 속도가 빠름.
Deque (ArrayDeque):
ArrayDeque는 동기화 없이 설계된 양방향 큐로, 원형 배열(circular buffer)을 기반으로 구현됨.
addLast()와 pollLast()는 배열의 끝에서 작동하지만, 원형 배열이라 인덱스 계산(모듈러 연산)이 추가로 필요할 수 있음.
메모리 효율성과 유연성은 더 나은데, 이 문제처럼 단순히 스택처럼만 사용할 때는 불필요한 기능이 오히려 약간의 오버헤드를 줄 수 있음.
결론: Stack은 단순 배열 기반이라 접근 속도가 미세하게 더 빠를 수 있고, ArrayDeque는 원형 배열 관리 때문에 아주 약간의 추가 연산이 들어감.
        2. 메서드 호출 방식
Stack 코드:
java
stack.push(ing);
if (stack.size() >= 4) {
int size = stack.size();
    if (stack.get(size - 4) == 1 && stack.get(size - 3) == 2 &&
        stack.get(size - 2) == 3 && stack.get(size - 1) == 1) {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
            }
push()와 pop()은 단순히 배열 끝에 추가/제거.
get(index)는 Vector의 인덱스 접근이라 직관적이고 빠름.
Deque 코드:
java
deque.addLast(ing);
if (deque.size() >= 4) {
Integer[] lastFour = deque.toArray(new Integer[0]);
int size = deque.size();
    if (lastFour[size - 4] == 1 && lastFour[size - 3] == 2 &&
lastFour[size - 2] == 3 && lastFour[size - 1] == 1) {
        deque.pollLast();
        deque.pollLast();
        deque.pollLast();
        deque.pollLast();
    }
            }
toArray() 호출: Deque는 get(index) 같은 직접 인덱스 접근 메서드가 없어서 배열로 변환 후 확인했어요. 이 과정이 추가 오버헤드를 만듦.
pollLast(): ArrayDeque에서 맨 뒤를 제거하지만, 원형 배열 관리와 null 반환 체크 로직 때문에 pop()보다 약간 느릴 수 있음.
결론: Deque 코드에서 toArray()로 배열을 만드는 과정이 실행 시간을 늘리는 주요 원인 중 하나예요. Stack은 get()으로 바로 접근하니까 더 빠름.
        3. 실제 코드 최적화 차이
Stack 코드:
단순히 get()으로 4개 요소를 바로 확인하니까 불필요한 메모리 할당이나 복사가 없음.
Deque 코드:
toArray()로 매번 새로운 배열을 만들어서 확인했어요. 이건 요소가 많아질수록 메모리 복사 비용이 커짐.
배열 변환 없이 Deque에서 직접 확인하려면 peekLast()나 반복자(Iterator)를 써야 하는데, 이 문제에선 4개 연속 요소를 쉽게 볼 방법이 없어서 toArray()를 선택했지만 효율성이 떨어짐.
개선 가능성: Deque에서 toArray() 대신 끝에서 4개를 직접 확인하는 로직을 짜면 속도가 Stack에 더 근접할 수 있어요. 예를 들어:
java
if (deque.size() >= 4) {
Iterator<Integer> iter = deque.descendingIterator();
    if (iter.next() == 1 && iter.next() == 3 &&
        iter.next() == 2 && iter.next() == 1) {
        deque.pollLast();
        deque.pollLast();
        deque.pollLast();
        deque.pollLast();
    }
            }
이렇게 하면 배열 복사를 피할 수 있지만, 반복자 생성과 호출이 약간의 오버헤드를 줄 수 있음.
        4. 실행 시간 차이의 실제 규모
입력 크기가 작을 때는 차이가 미세해서 체감하기 어려움 (예: ingredient 길이가 100 이하).
하지만 입력이 커질수록 (예: 1,000,000), toArray()의 반복 호출과 메모리 할당이 누적되면서 Stack보다 느려짐.
프로그래머스 환경처럼 테스트 케이스가 크고 반복적이면 이런 차이가 더 두드러질 수 있어요.
결론: 왜 Deque가 느렸나?
toArray() 오버헤드: Deque 코드에서 패턴 확인을 위해 배열로 변환하는 과정이 추가 비용을 유발.
구현 차이: Stack의 단순 배열 vs ArrayDeque의 원형 배열 관리 차이로 인한 미세한 성능 차이.
메서드 설계: pollLast()가 pop()보다 약간 더 복잡한 로직(null 체크 등)을 포함.
해결책
Deque로 더 빠르게 풀고 싶다면:
toArray() 대신 끝에서 4개를 직접 확인하는 로직을 구현 (예: 반복자나 별도 카운터 사용).
ArrayDeque를 스택처럼 단순히 사용하면서 불필요한 변환을 최소화.
예시 최적화 코드:
java
Deque<Integer> deque = new ArrayDeque<>();
for (int ing : ingredient) {
        deque.addLast(ing);
    if (deque.size() >= 4) {
Iterator<Integer> iter = deque.descendingIterator();
        if (iter.next() == 1 && iter.next() == 3 &&
        iter.next() == 2 && iter.next() == 1) {
        deque.pollLast();
            deque.pollLast();
            deque.pollLast();
            deque.pollLast();
answer++;
        }
        }
        }*/
