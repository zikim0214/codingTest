package org.programmers.level_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i : ingredient) {
            deque.add(i);
              int size = deque.size();
              if (size >= 4) {
                  if (deque.peekLast() == 1 &&
                          deque.toArray()[size - 2].equals(3) &&
                          deque.toArray()[size - 3].equals(2) &&
                          deque.toArray()[size - 4].equals(1)
                  ) {
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
        /*
            2 = 야채
            3 = 고기
            1 = 빵
            즉, 1 2 3 1 인 순서가 존재 할 경우애만 햄버거가 가능하다.
        */

        int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(solution(ingredient2));
    }
}