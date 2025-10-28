package com.avengers.javaalgorithm.sort;
import java.util.*;
import java.io.*;

public class Sort_3273_s3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int left = 0;
        int right = n-1;
        int sum = 0;
        int cnt = 0;

        int[] numbers = new int[n];
        for(int i =0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        while(left<right){
            sum = numbers[left] + numbers[right];
            if(sum == target){
                cnt ++;
                left++;
                right--;
            }
            else if(sum < target){
                left ++;
            }else{
                right--;
            }
        }


        System.out.println(cnt);
    }
}