package com.avengers.javaalgorithm.hash;

import java.io.*;
import java.util.*;


public class Hash_2002_s1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // HashMap으로 입장 순서 저장
        Map<String, Integer> hash = new HashMap<>();
        String[] after = new String[n];
        int cnt = 0;

        // 입장 순서를 해시맵에 저장
        for (int i = 0; i < n; i++) {
            hash.put(br.readLine(), i);
        }

        // 출구 순서를 배열에 저장
        for (int i = 0; i < n; i++) {
            after[i] = br.readLine();
        }

        // 추월 횟수 계산
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 현재 나간 차(i)가 뒤에 나간 차(j)보다 입장이 늦었다면 추월
                if (hash.get(after[i]) > hash.get(after[j])) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

}
