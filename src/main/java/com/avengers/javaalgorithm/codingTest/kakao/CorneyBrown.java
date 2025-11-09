package com.avengers.javaalgorithm.codingTest.kakao;

import java.util.*;
import java.io.*;
public class CorneyBrown {
    static int c = 11;
    static int b = 2;

    public static Integer catchMe(int conyLoc, int brownLoc){
        int time = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{brownLoc, 0});

        List<Map<Integer, Boolean>> visited = new ArrayList<>(200001);
        for(int i = 0; i<200001; i++){
            visited.add(new HashMap<>());
        }

        while(conyLoc<= 200000){
            conyLoc += time;
            if(visited.get(conyLoc).containsKey(time)){
                return time;
            }

            int queueSize = queue.size();
            for(int i = 0; i<queueSize; i++){
                int[] current = queue.poll();
                int currentPosition = current[0];
                int currentTime = current[1];

                int newTime = currentTime+1;

                int newPosition = currentPosition - 1;
                if(0 <= newPosition && newPosition <= 200000){
                    visited.get(newPosition).put(newTime, true);
                    queue.add(new int[]{newPosition, newTime});

                }

                newPosition = currentPosition + 1;
                if(0 <= newPosition && newPosition <= 200000){
                    visited.get(newPosition).put(newTime, true);
                    queue.add(new int[]{newPosition, newTime});

                }

                newPosition = currentPosition * 2;
                if(0 <= newPosition && newPosition <= 200000){
                    visited.get(newPosition).put(newTime, true);
                    queue.add(new int[]{newPosition, newTime});
                }



            }

            time += 1;
        }


        return null;
    }

    public static void main(String[] args) {
        System.out.println(catchMe(c, b));  // 5가 나와야 합니다!

        System.out.println("정답 = 3 / 현재 풀이 값 = " + catchMe(10, 3));
        System.out.println("정답 = 8 / 현재 풀이 값 = " + catchMe(51, 50));
    }
}