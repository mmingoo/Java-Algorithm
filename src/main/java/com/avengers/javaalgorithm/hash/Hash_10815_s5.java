package com.avengers.javaalgorithm.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Hash_10815_s5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer getSt = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> getMap = new HashMap<>();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer findSt = new StringTokenizer(br.readLine());

        while(getSt.hasMoreTokens()){
            int num = Integer.parseInt(getSt.nextToken());
            getMap.put(num,1);
        }

        while(findSt.hasMoreTokens()){
            int findNum = Integer.parseInt(findSt.nextToken());
            int result = getMap.getOrDefault(findNum,0);

            sb.append(result).append(" ");
        }

        System.out.println(sb);


    }

}
