package com.avengers.javaalgorithm.hash;
import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        String[] outTunnel = new String[n];
        int cnt = 0;

        for(int i = 0 ; i<n; i++){
            map.put(br.readLine(), i);
        }

        for(int i = 0; i<n; i++){
            outTunnel[i] = br.readLine();
        }

        for(int i = 0; i<n-1; i++){
            for(int j = i; j<n; j++){
                if(map.get(outTunnel[i]) > map.get(outTunnel[j])){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
