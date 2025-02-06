package org.programmers.level_1;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77484">로또의 최고 순위와 최저 순위</a>
 */
public class lessons_77484_로또의_최고_순위와_최저_순위 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};


        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25}; // 구매한 로또 번호를 담은 배열
        int[] win_nums = {31, 10, 45, 1, 6, 19}; // 당첨 번호를 담은 배열
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
}

/*
동생이 낙서 해서 알아볼 수 없는 번호를 0으로 표기
최고 순위와 최저 순위를 알아보고 싶다.

민우가 구매한 로또 {44, 1, 0, 0, 31 25}
당첨 번호가 {31, 10, 45, 1, 6, 19}
* */