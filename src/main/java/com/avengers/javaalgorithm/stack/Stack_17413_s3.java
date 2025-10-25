package com.avengers.javaalgorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Stack_17413_s3 {
    public static void main(String[] args) throws IOException {

            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Stack<Character> stack = new Stack<>();
            boolean is_in = false;

            String str = br.readLine();
            char[] str_arr =str.toCharArray();

            for(char ch : str_arr){
                if (ch == '<'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                    is_in = true;
                }
                else if(ch == '>'){
                    sb.append(ch);
                    is_in = false;
                }
                else if(ch == ' '){
                    if(is_in){
                        sb.append(ch);
                    }else{
                        while(!stack.isEmpty()){
                            sb.append(stack.pop());
                        }

                        sb.append(ch);
                    }


                }else{
                    if(is_in){
                        sb.append(ch);
                    }else{
                        stack.push(ch);
                    }
                }
            }

            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }


            System.out.println(sb);
    }

}
