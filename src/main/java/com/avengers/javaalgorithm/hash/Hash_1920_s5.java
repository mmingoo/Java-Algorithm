package com.avengers.javaalgorithm.hash;

import java.util.*;

public class Hash_1920_s5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        HashSet<Integer> originSet = new HashSet<>();

        for(int i = 0 ; i<n; i++){
            originSet.add(sc.nextInt());
        }

        int m = sc.nextInt();

        HashSet<Integer> findSet = new HashSet<>();
        for(int i = 0; i<m; i++){
            int num = sc.nextInt();
           if( originSet.contains(num)){
               sb.append("1\n");
           }else{
               sb.append("0\n");
           }
        }

        System.out.println(sb);
        sc.close();


    }


}
