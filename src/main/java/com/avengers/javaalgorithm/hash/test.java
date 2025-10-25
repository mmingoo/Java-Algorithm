package com.avengers.javaalgorithm.hash;
import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> before = new HashMap<>();
        String[] after = new String[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            before.put(br.readLine(), i);
        }

        for (int i = 0; i < 4; i++) {
            after[i] = br.readLine();
        }


        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(before.get(after[i]) > before.get(after[j])){
                    cnt ++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
