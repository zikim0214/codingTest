package org.programmers.level_0;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 배열 만들기 2
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181921">프로그래머스 181921</a>
 */
public class lessons_181921 {

    public int[] solution(int l, int r) {

        // 몇개의 answer가 존재하는지 모르므로 list로 생성
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            boolean flag = true;
            for (char c : String.valueOf(i).toCharArray()) {
                if (c != '5' && c != '0') {
                    flag = false;
                    break;
                }
            }
            if (flag) answer.add(i);
        }
        if (answer.isEmpty()) answer.add(-1);
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int l = 5;
        int r = 555;
        lessons_181921 lesson = new lessons_181921();
        System.out.println(Arrays.toString(lesson.solution(l, r)));
    }
}

/*
# 문제 설명
자연수 l, r이 주어질 때, l 이상 r 이하의 수 중에서
5와 0으로만 이루어진 모든 숫자를 오름차순으로 배열하여 반환
만약 조건을 만족하는 숫자가 없다면 [-1]을 반환해야 한다.
*/

/*
# stream 이란
스트림(Stream)은 데이터의 흐름을 의미하며,
데이터를 하나씩 처리할 수 있도록 도와주는 Java의 기능입니다.
컬렉션(List, Set 등)이나 배열의 데이터를 효과적으로 처리할 수 있는 도구입니다.

# 스트림(Stream)의 특징
1. 데이터를 한 번만 처리
스트림은 한 번 사용하면 다시 사용할 수 없습니다. (재사용 불가능)

2. 원본 데이터를 변경하지 않음 (Immutable)
스트림을 사용해 데이터를 가공하더라도, 원본 데이터는 변하지 않습니다.

3. 중간 연산(Intermediate Operation)과 최종 연산(Terminal Operation)으로 구성
중간 연산: 데이터를 변환 (map, filter, sorted 등)
최종 연산: 결과를 출력 또는 컬렉션으로 변환 (forEach, collect, toArray 등)
*/