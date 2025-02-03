package org.programmers.level_0;


import java.util.Arrays;

/**
 * 특이한 정렬
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120880">프로그래머스 120880</a>
 */
public class lessons_120880_특이한_정렬 {

    public static int[] sortClass(int[] numList, int n) {
        int numListLength = numList.length;

        // 배열의 전체 길이에서 한 원소씩 줄여나가며 반복
        for (int i = 0; i < numListLength - 1; i++) {
            for (int j = 0; j < numListLength - i - 1; j++) {
                int diff1 = Math.abs(numList[j] - n);
                int diff2 = Math.abs(numList[j + 1] - n);
                if (diff1 > diff2 || (diff1 == diff2 && numList[j] < numList[j + 1])) {
                    int temp = numList[j];
                    numList[j] = numList[j + 1];
                    numList[j + 1] = temp;
                }
            }
        }
        return numList;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] numList = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(sortClass(numList, n)));
    }
}
/*
# 버블 정렬 알고리즘

정수 4를 기준으로 4와 가까운 수부터 정렬하려고 합니다.
이때 4로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
정수가 담긴 배열 {1, 2, 3, 4, 5, 6} 와 정수 4가 주어질 때
{1, 2, 3, 4, 5, 6}의 원소를 4로부터 가까운 순서대로 정렬한 배열을
return 하도록 solution 함수를 완성해주세요.
*/
