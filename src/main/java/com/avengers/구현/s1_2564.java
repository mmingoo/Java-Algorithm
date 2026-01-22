package com.avengers.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());  // 가로
        int height = Integer.parseInt(st.nextToken()); // 세로
        int perimeter = 2 * (width + height);  // 전체 둘레

        int storeCnt = Integer.parseInt(br.readLine());
        int[] storePositions = new int[storeCnt];

        // 상점 위치를 1차원 좌표로 변환
        for (int i = 0; i < storeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            storePositions[i] = getPosition(direction, distance, width, height);
        }

        // 동근이 위치
        st = new StringTokenizer(br.readLine());
        int direction = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int dongPosition = getPosition(direction, distance, width, height);

        int result = 0;
        for (int storePos : storePositions) {
            int directPath = Math.abs(dongPosition - storePos);
            int aroundPath = perimeter - directPath;
            result += Math.min(directPath, aroundPath);
        }

        System.out.println(result);
    }

    // 방향과 거리를 1차원 좌표로 변환
    private static int getPosition(int direction, int distance, int width, int height) {
        switch (direction) {
            case 1: // 북
                return distance;
            case 2: // 남
                return width + height + (width - distance);
            case 3: // 서
                return 2 * width + height + (height - distance);
            case 4: // 동
                return width + distance;
            default:
                return 0;
        }
    }
}
