package com.avengers.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_14503 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        // 북: 0, 동: 1, 남: 2, 서: 3
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int startDir = Integer.parseInt(st.nextToken());

        int currentRow = startRow;
        int currentCol = startCol;
        int currentDir = startDir;

        int[][] map = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 1. 현재 칸 청소
            if (map[currentRow][currentCol] == 0) {
                map[currentRow][currentCol] = 2; // 청소된 칸은 2로 표시
                result++;
            }

            // 2. 주변 4칸 확인
            boolean hasCleanSpace = false;
            for (int i = 0; i < 4; i++) {
                int nx = currentRow + dx[i];
                int ny = currentCol + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (map[nx][ny] == 0) {
                        hasCleanSpace = true;
                        break;
                    }
                }
            }

            if (!hasCleanSpace) {
                // 청소할 곳이 없으면 후진
                int backDir = (currentDir + 2) % 4; // 반대 방향
                int backX = currentRow + dx[backDir];
                int backY = currentCol + dy[backDir];

                // 후진 가능 여부 체크
                if (backX >= 0 && backX < rows && backY >= 0 && backY < cols && map[backX][backY] != 1) {
                    currentRow = backX;
                    currentCol = backY;
                } else {
                    break; // 후진 불가능하면 종료
                }
            } else {
                // 청소할 곳이 있으면 반시계 회전하며 탐색
                currentDir = (currentDir + 3) % 4; // 반시계 회전

                int nx = currentRow + dx[currentDir];
                int ny = currentCol + dy[currentDir];

                // 앞쪽이 청소 안 된 빈 칸이면 전진
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && map[nx][ny] == 0) {
                    currentRow = nx;
                    currentCol = ny;
                }
            }
        }

        System.out.println(result);
    }
}
