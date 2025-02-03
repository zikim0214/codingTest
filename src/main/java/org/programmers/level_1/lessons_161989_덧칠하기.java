package org.programmers.level_1;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/161989">덧칠하기</a>
 * */
public class lessons_161989_덧칠하기 {
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        for (int i = 0; i < section.length;) {
            // 페인트 칠 횟수
            answer++;
            // 최대 칠할 수 있는 범위
            int end = section[i] + m -1;
            while ((i < section.length) && (section[i] <= end)){
                i++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        /* result 2 */
        int n1 = 8; // 벽의 길이, 구역의 개수
        int m1 = 4; // 롤러의 길이
        int[] section1 = {2, 3, 6}; // 페인트를 다시 칠해야 하는 구역의 번호
        System.out.println(solution(n1, m1, section1));

        /* result 4 */
        int n2= 4; // 벽의 길이, 구역의 개수
        int m2 = 1; // 롤러의 길이
        int[] section2 = {1, 2, 3, 4}; // 페인트를 다시 칠해야 하는 구역의 번호
        System.out.println(solution(n2, m2, section2));
    }
}

/*
* 최대 범위를 칠함으로, 페인트 칠 횟수를 최소화하는 것.
* */