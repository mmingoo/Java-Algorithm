package com.avengers.javaalgorithm;
import java.io.*;
import java.util.*;

public class test {
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
