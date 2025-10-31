package com.avengers.javaalgorithm;
import java.util.*;
import java.io.*;
public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long start = 0;
        long end = 0;
        long result = 0;
        int[] lanArr = new int[k];

        for(int i = 0; i<k; i++){
            int num = Integer.parseInt(br.readLine());
            lanArr[i] = num;
            end = Math.max(end, num);
        }



        while(start<=end){
            long lanCnt = 0;
            long mid = 0;

            mid = (start+end)/2;

            for(int i =0; i<k; i++){
                lanCnt += (lanArr[i]/mid);
            }

            if(lanCnt >= n){
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

    }
}