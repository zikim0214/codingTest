package org.programmers.level_1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64061">크레인 인형뽑기 게임</a>
 */
public class lessons_64061_크레인_인형뽑기_게임 {

    public static int solution(int[][] board, int[] moves) {
        int removedCount = 0;
        Stack<Integer> mStack = new Stack<>();

        // 8개의 위치 넘버 루프
        for (int pickupLocationNum : moves) {
            // 위치넘버
            int move = pickupLocationNum - 1;
            // 5개의 줄
            // 위치 넘버는 열의 번호를 가리킴
            // 결국 5개의 열을 점검하는 로직
            for (int row = 0; row < board.length; row++) {
                // 스택에 동일한 숫자가 없는 경우 board[row][move] != mStack.peek()
                // 스택에 아예 없는 경우 mStack.isEmpty()
                if (board[row][move] != 0){
                    // 0 이 아니니까 stack에 넣어야지
                    mStack.push(board[row][move]);



                }
                if (!mStack.isEmpty()) {
                    if (board[row][move] != mStack.peek()) {
                        mStack.push(board[row][move]);
                        board[row][move] = 0;
                    } else if (board[row][move] == mStack.peek()) {
                        mStack.pop();
                        board[row][move] = 0;
                        removedCount += 2;
                    }
                } else {
                    mStack.push(board[row][move]);
                    board[row][move] = 0;
                }
            }
        }
        return removedCount;
    }

    public static void main(String[] args) {
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4}; // 크레인을 작동시킨 위치가 담긴 배열
        int[][] board = // 게임 화면의 격자의 상태가 담긴 2차원 배열
                {
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}
                };
        System.out.println(solution(board, moves));
    }
}

/*
# 스택(Stack)은 데이터 구조의 한 종류로, LIFO(Last In, First Out) 원칙

push(item): 스택의 맨 위에 데이터를 추가합니다.
pop(): 스택의 맨 위에 있는 데이터를 제거하고 반환합니다.
peek() 또는 top(): 스택의 맨 위에 있는 데이터를 제거하지 않고 반환합니다.
isEmpty(): 스택이 비어 있는지 확인합니다.
size(): 스택에 있는 데이터의 개수를 반환합니다.
search(Object o): 특정 아이템의 위치를 반환합니다. 1부터 시작하며, 맨 위에 있을 경우 1을 반환합니다. 아이템이 없으면 -1을 반환합니다.
*/

