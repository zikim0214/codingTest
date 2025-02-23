package org.programmers.level_1;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92334">신고 결과 받기</a>
 */
public class lessons_92334_신고_결과_받기 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        // 유저별로 누구를 신고했는지 기록하기 위한 맵 (Set으로 중복 신고 제거)
        // 정지된 유저를 찾기 위해 메서드 생성
        Map<String, Set<String>> reportLog = new HashMap<>();

        // 유저별 신고당한 횟수 저장 (각 사용자가 몇 번 신고당했는지 저장, k번 이상인지 판단)
        // k 번 이상이라면 정지이며 정지되게 신고한 사용자들은 메일을 받는다.
        Map<String, Integer> reportCount = new HashMap<>();

        // 결과값 순서 중요
        LinkedHashMap<String, Integer> idIndex = new LinkedHashMap<>();

        // 초기화
        for (String s : id_list) {
            reportLog.put(s, new HashSet<>());
            reportCount.put(s, 0);
            idIndex.put(s, 0);
        }

        for (String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0];  // 신고한 사람
            String reported = split[1];  // 신고당한 사람
            // 중복 신고를 무시하고 기록
            // Set.add()는 중복 추가 시 false를 반환하니까, 처음 신고일 때만 카운트 증가
            if (reportLog.get(reporter).add(reported)) {
                // 신고당한 횟수 증가: k번 이상인지 확인하기 위해
                reportCount.put(reported, reportCount.get(reported) + 1);
            }
        }

        for (Map.Entry<String, Integer> r2 : reportCount.entrySet()) {
            String reportedName = r2.getKey(); // 신고당한 사람
            Integer reportedCount = r2.getValue(); // 신고당한 카운트
            // k 번 이상이라면 정지
            if (reportedCount >= k) {
                for (Map.Entry<String, Set<String>> r3 : reportLog.entrySet()) {
                    String reporterName = r3.getKey(); // 신고자
                    Set<String> stoppedName = r3.getValue(); // 신고당한 사람
                    // 정지된 사용자를 신고했다면 메일 수 증가
                    if (stoppedName.contains(reportedName)) {
                        idIndex.put(reporterName, idIndex.get(reporterName) + 1);
                    }
                }
            }
        }
        // 각 유저별로 처리 결과 메일을 받은 횟수
        return  idIndex.values().stream().mapToInt(Integer::intValue).toArray();
    }

    /*
        1. 각 사용자는 다른 사용자를 신고할 수 있음 (중복 신고는 1회로 처리).
        2. 신고 횟수가 k번 이상인 사용자는 정지됨.
        3. 정지된 사용자를 신고한 사람들은 메일로 결과를 받음.
    */
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // 전체 유저 목록
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}; // 이용자가 신고한 아이디
        int k = 2;
//        String[] id_list = {"con", "ryan"}; // 전체 유저 목록
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"}; // 이용자가 신고한 아이디
//        int k = 3; // 정지 기준이 되는 신고 횟수

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}