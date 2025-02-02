package org.programmers.level_1;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159994">카드 뭉치</a>
 */
public class lessons_159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int card1Index = 0;
        int card2Index = 0;

        // goal.length를 기준으로 할 경우 ArrayIndexOutOfBoundsException 주의
        for (int i = 0; i < goal.length; i++) {
            String targetGoalStr = goal[i];
            if (card1Index < cards1.length && cards1[card1Index].equals(targetGoalStr)) {
                card1Index++;
            } else if (card2Index < cards2.length && cards2[card2Index].equals(targetGoalStr)) {
                card2Index++;
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        lessons_159994 lessons = new lessons_159994();
//        String[] cards1 = {"i", "drink", "water"};
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(lessons.solution(cards1, cards2, goal));
    }
}