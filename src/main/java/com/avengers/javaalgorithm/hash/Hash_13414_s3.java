package com.avengers.javaalgorithm.hash;
import java.io.InputStream;
import java.util.*;
import java.io.*;
public class Hash_13414_s3 {
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int possibleCnt = Integer.parseInt(st.nextToken());
            int readyListSize = Integer.parseInt(st.nextToken());

            HashMap<String,Integer> readyCntMap = new HashMap<>();

            for(int i =0; i<readyListSize; i++){
                String studentNum = br.readLine();
                readyCntMap.put(studentNum, i);
            }


            String[] readyArr = new String[readyListSize];
            for (Map.Entry<String, Integer> map : readyCntMap.entrySet()){
                readyArr[map.getValue()] = map.getKey();
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < readyListSize; i++){
                if(readyArr[i]!=null && possibleCnt >0){
                    sb.append(readyArr[i]).append("\n");
                    possibleCnt --;
                }

            }

            System.out.println(sb);




    }

}
