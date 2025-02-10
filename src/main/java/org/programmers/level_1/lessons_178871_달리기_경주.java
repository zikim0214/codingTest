package org.programmers.level_1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/178871">달리기 경주</a>
 */
public class lessons_178871_달리기_경주 {
    public static String[] solution(String[] players, String[] callings) {

        // 조작하기 위해 순위의 index가 필요하다.
        Map<String, Integer> playerToMap = IntStream.range(0, players.length)
                .boxed()
                .collect(Collectors.toMap(i -> players[i], i -> i));

        for (String callingPlayer : callings) {
            int currentRankNum = playerToMap.get(callingPlayer);
            if (currentRankNum > 0) {
                // 이전 플레이어
                String prevPlayer = players[currentRankNum - 1];
                // 불려진 플레이어와 그 앞에 있는 플레이어의 순위 변경
                players[currentRankNum - 1] = players[currentRankNum];
                players[currentRankNum] = prevPlayer;
                // 순위 map도 변경
                playerToMap.put(callingPlayer, currentRankNum - 1);
                playerToMap.put(prevPlayer, currentRankNum);
            }
        }

        // 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return
        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"}; // 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열
        String[] callings = {"kai", "kai", "mine", "mine"}; // 해설진이 부른 이름을 담은 문자열 배열
        System.out.println(Arrays.toString(solution(players, callings)));
    }
}