package org.programmers.level_1;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/340213">동영상 재생기</a>
 */
public class lessons_340213_동영상_재생기 {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenInt = timeToSeconds(video_len);
        int posInt = timeToSeconds(pos);
        int opStartInt = timeToSeconds(op_start);
        int opEndInt = timeToSeconds(op_end);
        for (String action : commands) {
            if (opStartInt <= posInt && opEndInt >= posInt) {
                // 현재 위치가 오프닝 구간인 경우, 오프닝이 끝나는 시간으로 이동
                posInt = opEndInt;
            }
            if (action.equals("next")) {
                posInt += 10;
                if (posInt >= videoLenInt) {
                    posInt = videoLenInt;
                }
                if (opStartInt <= posInt && opEndInt >= posInt) {
                    posInt = opEndInt;
                }
            } else if (action.equals("prev")) {
                posInt -= 10;
                // 10초 이하인 경우
                if (posInt <= 0) {
                    posInt = 0;
                }
            }
        }
        int minuteToSecondsInt = posInt / 60;
        int secondsToInt = posInt % 60;
        // 사용자의 입력이 모두 끝난 후 동영상의 위치를 "mm:ss" 형식으로 return
        return String.format("%02d:%02d", minuteToSecondsInt, secondsToInt);
    }

    private static int timeToSeconds(String timeStr) {
        String minuteStr = timeStr.split(":")[0];
        String secondsStr = timeStr.split(":")[1];
        int minuteToSecondsInt = Integer.parseInt(minuteStr);
        int secondsToInt = Integer.parseInt(secondsStr);
        return (minuteToSecondsInt * 60) + secondsToInt;
    }

    public static void main(String[] args) {
//        String video_len = "07:22"; // 동영상의 길이
//        String pos = "04:05"; // 기능이 수행되기 직전의 재생위치
//        String op_start = "00:15";// 오프닝 시작 시각
//        String op_end = "04:07"; // 오프닝이 끝나는 시각
//        String[] commands = {"next"};

        String video_len = "10:55";
        String pos = "00:05";
        String op_start = "00:15";
        String op_end = "06:55";
        String[] commands = {"prev", "next", "next"};

//        String video_len = "34:33"; // 동영상의 길이
//        String pos = "13:00"; // 기능이 수행되기 직전의 재생위치
//        String op_start = "00:55";// 오프닝 시작 시각
//        String op_end = "02:55"; // 오프닝이 끝나는 시각
//        String[] commands = {"next", "prev"};

        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }
}
/*
 * 10초 전으로 이동  "prev" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 전으로 이동
 * 현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동합니다. 영상의 처음 위치는 0분 0초
 *
 * 10초 후로 이동: 사용자가 "next" 명령을 입력할 경우 동영상의 재생 위치를 현재 위치에서 10초 후로 이동
 * 동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동합니다. 영상의 마지막 위치는 동영상의 길이와 같습니다.
 *
 * 오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우
 * 자동으로 오프닝이 끝나는 위치로 이동
 * */