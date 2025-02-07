package org.programmers.level_1;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77484">로또의 최고 순위와 최저 순위</a>
 */
public class lessons_77484_로또의_최고_순위와_최저_순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int maximum; // 최대 순위
        int minimum; // 최소 순위
        int zeroCount = 0;
        int matchCount = 0;

        // 순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정
        // 로또 번호를 순회하면서 0의 개수와 당첨 번호와 일치하는 번호의 개수 확인
        // 순위 계산
        // 0이 전부 당첨번호 일 가능성도 있음 or 0이 전부 당첨이 안되는 번호 일 수도 있다.
        // 0의 개수를 포함한 최고 순위
        // 0의 개수를 제외한 최저 순위

        // 모두다 0일 경우
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else if (Arrays.stream(win_nums).anyMatch(num -> num == lotto)) {
                matchCount++;
            }
        }
        maximum = totalMatchNumber(matchCount + zeroCount);
        minimum = totalMatchNumber(matchCount);
        return new int[]{maximum, minimum};
    }

    // java 14부터 정식으로 도입 switch 표현식
    private static int totalMatchNumber(int i) {
        return switch (i) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            case 1, 0 -> 6;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        //  로또 번호와 당첨 번호를 비교하여 최고 순위와 최저 순위를 계산
//        int[] lottos = {44, 1, 0, 0, 31, 25}; // 구매한 로또 번호를 담은 배열
//        int[] win_nums = {31, 10, 45, 1, 6, 19}; // 당첨 번호를 담은 배열
        int[] lottos = {0, 0, 0, 0, 0, 0}; // 구매한 로또 번호를 담은 배열
        int[] win_nums = {38, 19, 20, 40, 15, 25}; // 당첨 번호를 담은 배열
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
}

/*
동생이 낙서 해서 알아볼 수 없는 번호를 0으로 표기
최고 순위와 최저 순위를 알아보고 싶다.

민우가 구매한 로또 {44, 1, 0, 0, 31 25}
당첨 번호가 {31, 10, 45, 1, 6, 19}
* */