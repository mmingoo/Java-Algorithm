package com.avengers.javaalgorithm;
import java.sql.Array;
import java.util.*;
import java.io.*;
public class test {

    static String str = "ababcdcdababcdcd";



    public static void splitStr() {
        int strLen  = str.length();
        int minSize = 1000;

        for(int splitSize = 1; splitSize <= strLen/2; splitSize++){
            List<String> splitList = new ArrayList<>();

            for(int i  = 0; i<=strLen; i+=splitSize){
                if(i+splitSize<=strLen){
                    splitList.add(str.substring(i,i+splitSize));
                }else{
                    splitList.add(str.substring(i));
                }

            }

            StringBuilder  sb = new StringBuilder();
            int count = 1;

            for(int i = 0; i<splitList.size()-1; i ++){
                if(splitList.get(i).equals(splitList.get(i+1))){
                    count++;
                }else if(count == 1){
                    sb.append(splitList.get(i));

                }else{
                    sb.append(count).append(splitList.get(i));
                    count = 1;

                }
            }
            if(count > 1) {
                sb.append(count).append(splitList.get(splitList.size() - 1));
            } else {
                sb.append(splitList.get(splitList.size() - 1));
            }

            System.out.println("sb = " + sb);
            minSize = Math.min(minSize, sb.length());
            System.out.println("minSize = " + minSize);

        }


    }
    public static void main(String[] args) throws IOException {
        splitStr();

    }
}