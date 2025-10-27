package com.avengers.javaalgorithm.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binary_Search_1654_s2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long max = 0;  // ← long으로 변경!
        long result = 0;  // ← long으로 변경!

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lans = new int[k];
        for(int i = 0; i<k; i++){
            int num = Integer.parseInt(br.readLine());
            lans[i] = num;
            max = Math.max(max, num);
        }

        long start = 1;  // ← long으로 변경!
        long end = max;  // ← long으로 변경!

        while(start <= end){
            long mid = (start + end) / 2;  // ← long으로 변경!
            long cnt = 0;  // ← long으로 변경!

            for(int lan : lans){
                cnt += (lan / mid);
            }

            if(cnt >= n){
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

}
