package com.avengers.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class s3_1063 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String Klocation = st.nextToken();
        String Dlocation = st.nextToken();
        int cnt = Integer.parseInt(st.nextToken());

        // 문자를 숫자 좌표로 변환 (A=1, B=2, ..., H=8)
        int kX = Klocation.charAt(0) - 'A' + 1;
        int kY = Klocation.charAt(1) - '0';
        int dolX = Dlocation.charAt(0) - 'A' + 1;
        int dolY = Dlocation.charAt(1) - '0';

        // 방향 벡터: R, L, B, T, RT, LT, RB, LB
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

        HashMap<String, Integer> dir = new HashMap<>();
        dir.put("R", 0);
        dir.put("L", 1);
        dir.put("B", 2);
        dir.put("T", 3);
        dir.put("RT", 4);
        dir.put("LT", 5);
        dir.put("RB", 6);
        dir.put("LB", 7);

        for (int i = 0; i < cnt; i++) {
            String newDir = br.readLine();

            // 왕의 새로운 위치
            int newKX = kX + dx[dir.get(newDir)];
            int newKY = kY + dy[dir.get(newDir)];

            // 왕이 체스판을 벗어나면 무시
            if (newKX < 1 || newKX > 8 || newKY < 1 || newKY > 8) {
                continue;
            }

            // 왕의 새 위치가 돌의 위치와 같다면
            if (newKX == dolX && newKY == dolY) {
                // 돌의 새로운 위치
                int newDolX = dolX + dx[dir.get(newDir)];
                int newDolY = dolY + dy[dir.get(newDir)];

                // 돌이 체스판을 벗어나면 왕도 이동 불가
                if (newDolX < 1 || newDolX > 8 || newDolY < 1 || newDolY > 8) {
                    continue;
                }

                // 왕과 돌 모두 이동
                kX = newKX;
                kY = newKY;
                dolX = newDolX;
                dolY = newDolY;
            } else {
                // 왕만 이동
                kX = newKX;
                kY = newKY;
            }
        }

        // 숫자 좌표를 문자로 변환하여 출력
        System.out.println((char)(kX - 1 + 'A') + "" + kY);
        System.out.println((char)(dolX - 1 + 'A') + "" + dolY);
    }
}
