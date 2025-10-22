package com.avengers.javaalgorithm.hash;

import java.util.*;

public class Hash_10816_s4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> originNumMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            originNumMap.put(num, originNumMap.getOrDefault(num, 0) + 1);
        }

        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int num = sc.nextInt();
            sb.append(originNumMap.getOrDefault(num, 0)).append(" ");  // 공백으로 변경!
        }

        System.out.println(sb);
        sc.close();
    }
}