package com.avengers.javaalgorithm.dingcodingco.week2;

public class 더하거나빼거나 {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0,0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int nowNum){

        int n = numbers.length;

        if(idx == n && target==nowNum){
            answer ++;
            return;
        }

        if(idx ==n){
            return;
        }

        dfs(numbers, target, idx+1, nowNum + numbers[idx]);
        dfs(numbers, target, idx+1, nowNum - numbers[idx]);
    }

}

