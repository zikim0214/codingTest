package org.programmers.level_0;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181912">배열 만들기5</a>
 */
public class lessons_181912_배열_만들기5 {
    public static int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();

//        for (String intStr : intStrs) {
//            String subStr = intStr.substring(s, s + l);
//            int subStrToInt = Integer.parseInt(subStr);
//            if (subStrToInt > k) {
//                answer.add(subStrToInt);
//            }
//        }
//        return answer.stream().mapToInt(Integer::intValue).toArray();
        return Arrays.stream(intStrs)
                .map(subStr -> subStr.substring(s, s + l))
                .mapToInt(Integer::parseInt)
                .filter(subStr -> subStr > k)
                .toArray();
    }

    /*intStrs의 각 원소마다 s번째 인덱스에서 시작하여 l짜리 부분의 문자열을 잘라 정수로 변환
            정수값이 k보다 큰 값을 return 하시오 */
    public static void main(String[] args) {
        String[] intStrs = {"0123456789", "9876543210", "9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;
        System.out.println(Arrays.toString(solution(intStrs, k, s, l)));
    }
}