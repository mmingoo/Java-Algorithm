package com.avengers.javaalgorithm.codingTest.kakao.intern;
import java.util.*;
import java.io.*;

class kakao_blind_2020_1 {
    public int solution(String s) throws IOException {
        int n = s.length();
        int result = n;
        for(int splitSize=1; splitSize<= n/2; splitSize++){
            List<String> splited = new ArrayList<>();
            for (int i = 0; i < n; i+= splitSize){
                if(i+splitSize <=n){
                    splited.add(s.substring(i, i+splitSize));
                }else{
                    splited.add(s.substring(i));
                }
            }

            StringBuilder compressed = new StringBuilder();
            int count = 1;

            for(int i =0; i <splited.size()-1; i++){
                String cur = splited.get(i);
                String next = splited.get(i+1);

                if(cur.equals(next)){
                    count += 1;
                }else{
                    if(count == 1){
                        compressed.append(cur);
                    }else{
                        compressed.append(count).append(cur);
                    }

                    count = 1;
                }


            }
            if(count == 1){
                compressed.append(splited.get(splited.size()-1));
            }else{
                compressed.append(count).append(splited.get(splited.size()-1));
            }

            result = Math.min(compressed.toString().length(), result);

        }
        return result;
    }
}