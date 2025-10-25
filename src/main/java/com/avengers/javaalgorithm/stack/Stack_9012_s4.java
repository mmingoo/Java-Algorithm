package com.avengers.javaalgorithm.stack;

import java.io.*;
import java.util.*;
public class Stack_9012_s4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i<test; i++){
            boolean yn = true;
            stack.clear();
            String testStr = br.readLine();
            char[] testCharArr = testStr.toCharArray();

            for(char ch : testCharArr){
                if(ch == '('){
                    stack.push('(');
                }else{
                    if(stack.isEmpty()){
                       yn = false;
                       break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if((stack.isEmpty() && yn)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }

}
