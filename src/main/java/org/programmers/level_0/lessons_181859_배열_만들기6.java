package org.programmers.level_0;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181859">배열 만들기6</a>
 */
public class lessons_181859_배열_만들기6 {
    public static int[] solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
//        for (int i = 0; i < arr.length; ) {
//            if (stk.isEmpty()) {
//                stk.add(arr[i]);
//            } else {
//                int endPoint = stk.size() - 1;
//                if (stk.get(endPoint) == arr[i]) {
//                    stk.remove(endPoint);
//                } else {
//                    stk.add(endPoint + 1, arr[i]);
//                }
//            }
//            i++;
//        }
        IntStream.of(arr).forEach(value -> {
            if (stk.isEmpty()) {
                stk.add(value);
            } else {
                int endPoint = stk.size() - 1;
                if (stk.get(endPoint) == value) {
                    stk.remove(endPoint);
                } else {
                    stk.add(value);
                }
            }
        });

        return stk.isEmpty() ? new int[]{-1} : stk.stream().mapToInt(Integer::intValue).toArray();
    }

/*    새로운 배열 stk를 만드려고 한다.
        i 초기값 0 i 가 arr의 길이보다 작으면 stk*/

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0};
        System.out.println(Arrays.toString(solution(arr)));
    }
}