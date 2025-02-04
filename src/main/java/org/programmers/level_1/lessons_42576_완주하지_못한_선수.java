package org.programmers.level_1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42576">완주하지 못한 선수</a>
 */
public class lessons_42576_완주하지_못한_선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        Queue<String> pQueue = new ArrayDeque<>(Arrays.asList(participant));
        Queue<String> cQueue = new ArrayDeque<>(Arrays.asList(completion));

        while (!pQueue.isEmpty()) {
            String p = pQueue.peek();
            String c = cQueue.peek();
            if (!p.equals(c)) {
                return p;
            }
            cQueue.poll();
            pQueue.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"}; // 마라톤에 참여한 선수들
        String[] completion = {"eden", "kiki"}; // 완주한 선수들의 이름이 담긴 배열
        System.out.println(solution(participant, completion));
    }
}