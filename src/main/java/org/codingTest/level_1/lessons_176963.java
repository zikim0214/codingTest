package org.codingTest.level_1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/176963">추억 점수</a>
 */
public class lessons_176963 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 각 인물의 그리움 점수 매핑
        HashMap<String, Integer> yearningByNameMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            yearningByNameMap.put(name[i], yearning[i]);
        }
        // 결과 배열 초기화
        int[] answer = new int[photo.length];

        // 사진의 배열
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            // 각 사진 별 배열
            for (int j = 0; j < photo[i].length; j++) {
                // 사진 속 인물의 이름을 가져온 후 각 인물의 그리움을 담은 map 과 비교하여 값을 추출.
                // 단, 이름이 존재하지 않으면 0으로 초기값 return
                String targetName = photo[i][j];
                sum = sum + yearningByNameMap.getOrDefault(targetName, 0);
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        lessons_176963 lessons = new lessons_176963();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain"},
                {"may", "kein", "brin"},
                {"kon", "kain", "may", "radi"}
        };
        System.out.println(Arrays.toString(lessons.solution(name, yearning, photo)));
    }
}

/*
# 문제 설명

["may", "kein", "kain"] name
[5점, 10점, 1점] yearning

추억점수는 16

["kali", "mari", "don", "tony"]
["kali", "mari", "don"]의 그리움 점수가 각각 [11점, 1점, 55점]


*/


