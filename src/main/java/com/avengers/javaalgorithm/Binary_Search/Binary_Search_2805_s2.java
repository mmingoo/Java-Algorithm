package com.avengers.javaalgorithm.Binary_Search;

import java.util.*;
import java.io.*;
public class Binary_Search_2805_s2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer treeSt = new StringTokenizer(br.readLine());

        int[] trees = new int[n];

        for(int i = 0; i <n; i++){
            trees[i] = Integer.parseInt(treeSt.nextToken());
            max = Math.max(max, trees[i]);
        }

        int left = 0;
        int right = max;
        int answer = 0;
        while(left<=right) {
            int mid = (left + right) / 2;
            int total = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            if (total >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;

            }

        }
        System.out.println(answer);
    }

}
