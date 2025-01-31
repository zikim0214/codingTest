package org.programmers.level_0;


import java.util.Arrays;

/**
 * 특이한 정렬
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120880">프로그래머스 120880</a>
 */
public class lessons_120880_1 {

    public int[] sortClass(int[] numList, int n) {
        Integer[] arr = Arrays.stream(numList).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            int diff1 = Math.abs(a - n);
            int diff2 = Math.abs(b - n);

            if (diff1 == diff2) return b - a;  // 거리가 같으면 큰 수가 앞으로
            return diff1 - diff2;  // 거리 차이가 작은 순서대로
        });

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int n = 4;
        int[] numList = {1, 2, 3, 4, 5, 6};
        lessons_120880_1 lessons = new lessons_120880_1();
        System.out.println(Arrays.toString(lessons.sortClass(numList, n)));
    }
}
