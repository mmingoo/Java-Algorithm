package com.avengers.javaalgorithm.sort;

import java.util.*;
import java.io.*;
public class Sort_1946_s1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i<testCase; i++){
            int applicantCnt = Integer.parseInt(br.readLine());
            int[][] pr =new int[applicantCnt][2];


            for(int j =0; j<applicantCnt; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                pr[j][0] = Integer.parseInt(st.nextToken());
                pr[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(pr, (a,b) -> a[0]-b[0]); // 내림차순
            int count = 1;
            int minInterviewRank = pr[0][1];

            for(int j = 1; j < applicantCnt; j++){
                if (pr[j][1] < minInterviewRank){
                    count ++ ;
                    minInterviewRank = pr[j][1];
                }
            }
            System.out.println(count);

        }
    }
}
