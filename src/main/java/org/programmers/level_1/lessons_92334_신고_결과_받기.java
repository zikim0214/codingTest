package org.programmers.level_1;

import java.util.Arrays;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92334">신고 결과 받기</a>
 */
public class lessons_92334_신고_결과_받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};


        // 각 유저별로 처리 결과 메일을 받은 횟수
        return answer;
    }

    /*
     * 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템
     * 각 유저는 한 번에 한 명의 유저를 신고
     * 신고 횟수에 제한은 없습니다.
     * 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회
     *
     * k번 이상 신고된 유저는 게시판 이용이 정지된다.
     * */
    public static void main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // 전체 유저 목록
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}; // 이용자가 신고한 아이디
//        int k = 2;
        String[] id_list = {"con", "ryan"}; // 전체 유저 목록
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"}; // 이용자가 신고한 아이디
        int k = 3; // 정지 기준이 되는 신고 횟수

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}