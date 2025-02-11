package org.programmers.level_1;

import java.util.Map;
import java.util.stream.IntStream;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/340199">지폐 접기</a>
 */
public class lessons_340199_지폐접기 {

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        // 접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접습니다.
        // 한쪽이 크다면 계속 접어야한다.
        while (Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1]) || Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])) {
//            while (wallet[0] < bill[0] || wallet[1] < bill[1]) {
            // 지폐의 긴 쪽을 반으로 접음
            if (bill[0] > bill[1]) {
                bill[0] = bill[0] / 2;
            } else {
                bill[1] = bill[1] / 2;
            }
            answer++;
        }
        // 지갑에 넣기 위해서 지폐를 최소 몇 번 접어야 하는지 return
        return answer;
    }


    public static void main(String[] args) {
        int[] wallet = {30, 15}; // 지갑의 가로, 세로 크기를 담은 정수 리스트
        int[] bill = {26, 17}; // 지폐의 가로, 세로 크기를 담은 정수 리스트
//        int[] wallet = {50, 50}; // 지갑의 가로, 세로 크기를 담은 정수 리스트
//        int[] bill = {100, 241}; // 지폐의 가로, 세로 크기를 담은 정수 리스트

        System.out.println(solution(wallet, bill));
    }
}

/*
1. 지폐를 접을 때는 항상 길이가 긴 쪽을 반으로 접습니다.
2. 접기 전 길이가 홀수였다면 접은 후 소수점 이하는 버립니다. Math.abs
3. 접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접습니다.
*/
