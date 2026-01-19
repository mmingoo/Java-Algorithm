package com.avengers.javaalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class JavaAlgorithmApplication {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // 가로(동1, 서2), 세로(남3, 북4) 길이를 저장
        List<Integer> widths = new ArrayList<>();   // 동, 서
        List<Integer> heights = new ArrayList<>();  // 남, 북

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if (direction == 1 || direction == 2) {  // 동 또는 서
                widths.add(len);
            } else {  // 남 또는 북
                heights.add(len);
            }
        }

        // 가로 방향: 최대값, 최소값
        int maxWidth = Collections.max(widths);
        int minWidth = Collections.min(widths);

        // 세로 방향: 최대값, 최소값
        int maxHeight = Collections.max(heights);
        int minHeight = Collections.min(heights);

        // 전체 사각형 - 작은 사각형
        int area = (maxWidth * maxHeight) - (minWidth * minHeight);

        System.out.println(area * k);
    }
}
