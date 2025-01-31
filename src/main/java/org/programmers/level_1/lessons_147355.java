package org.programmers.level_1;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/147355">크기가 작은 부분 문자열</a>
 */
public class lessons_147355 {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length() - p.length(); i++) {
            String targetText = t.substring(i, i + p.length());
            if (Long.parseLong(targetText) <= Long.parseLong(p)) {
                answer ++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        lessons_147355 lessons = new lessons_147355();
        String t = "500220839878";
        String p = "7";
        System.out.println(lessons.solution(t, p));
    }
}

/*
# 문제 설명
t="3141592"이고 p="271" 인 경우, (t.length = 7, p.length = 3)
t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다.
271보다 작거나 같은 수는 141, 159 2개 입니다.
return 2;
*/

/*
# 슬라이딩 윈도우
t 위로 슬며시 이동시키면서 비교
*/