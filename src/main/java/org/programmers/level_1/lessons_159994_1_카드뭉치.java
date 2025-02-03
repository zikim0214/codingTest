package org.programmers.level_1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159994">카드 뭉치</a>
 */
public class lessons_159994_1_카드뭉치 {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> cards1Queue = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> cards2Queue = new ArrayDeque<>(Arrays.asList(cards2));
        for (int i = 0; i < goal.length ; i++) {
            String targetGoalStr = goal[i];
            if (!cards1Queue.isEmpty() && cards1Queue.peek().equals(targetGoalStr)) {
                cards1Queue.poll();
            } else if (!cards2Queue.isEmpty() && cards2Queue.peek().equals(targetGoalStr)) {
                cards2Queue.poll();
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
//        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(solution(cards1, cards2, goal));
    }
}