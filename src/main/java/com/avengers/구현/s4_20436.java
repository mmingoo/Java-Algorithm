package com.avengers.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class s4_20436 {
    public static void main(String[] args) throws IOException {

        char[][] leftString = {
                {'q', 'w', 'e', 'r', 't'},
                {'a', 's', 'd', 'f', 'g'},
                {'z', 'x', 'c', 'v'}
        };

        char[][] rightString = {
                {' ', 'y', 'u', 'i', 'o', 'p'},
                {' ', 'h', 'j', 'k', 'l'},
                {'b', 'n', 'm'}
        };

        Map<Character, int[]> keyboardLocation = new HashMap<>();

        // 왼손 키보드 좌표 저장
        for (int i = 0; i < leftString.length; i++) {
            for (int j = 0; j < leftString[i].length; j++) {
                keyboardLocation.put(leftString[i][j], new int[]{i, j});
            }
        }

        // 오른손 키보드 좌표 저장
        for (int i = 0; i < rightString.length; i++) {
            for (int j = 0; j < rightString[i].length; j++) {
                keyboardLocation.put(rightString[i][j], new int[]{i, j});
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 시작 위치 입력 (z o)
        String startChar = br.readLine();
        char leftStartChar = startChar.charAt(0);   // 'z'
        char rightStartChar = startChar.charAt(2);  // 'o' (공백 건너뜀)

        // 두 번째 줄: 입력 문자열 (zoac)
        String inputString = br.readLine();

        int[] currentLeft = keyboardLocation.get(leftStartChar);
        int[] currentRight = keyboardLocation.get(rightStartChar);

        int time = 0; // 총 걸리는 시간

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            int[] targetPosition = keyboardLocation.get(currentChar);

            if (leftKey(currentChar)) { // 왼손 키인 경우
                // 맨해튼 거리 계산
                time += Math.abs(currentLeft[0] - targetPosition[0])
                        + Math.abs(currentLeft[1] - targetPosition[1]);
                currentLeft = targetPosition; // 왼손 위치 업데이트
            } else { // 오른손 키인 경우
                // 맨해튼 거리 계산
                time += Math.abs(currentRight[0] - targetPosition[0])
                        + Math.abs(currentRight[1] - targetPosition[1]);
                currentRight = targetPosition; // 오른손 위치 업데이트
            }

            time += 1; // 키 누르는 시간 추가
        }

        System.out.println(time);
    }

    // 왼손 키인지 판별하는 메서드
    static private boolean leftKey(char currentChar) {
        return "qwertasdfgzxcv".indexOf(currentChar) != -1;
    }
}