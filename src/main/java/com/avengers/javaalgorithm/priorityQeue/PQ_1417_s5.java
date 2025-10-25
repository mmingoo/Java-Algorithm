package com.avengers.javaalgorithm.priorityQeue;

import java.util.*;
import java.io.*;

public class PQ_1417_s5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int peopleCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int dasom = 0;
        int giveMoneyCnt = 0;

        if(peopleCnt == 1) {
            dasom = Integer.parseInt(br.readLine());
            System.out.println(0);
            return;
        }
        dasom = Integer.parseInt(br.readLine());

        for(int i = 1 ;i<peopleCnt; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

            while(!pq.isEmpty() && pq.peek() >= dasom) {
                int max = pq.poll();
                dasom++;
                max--;
                giveMoneyCnt++;
                pq.add(max);

            }

            System.out.println(giveMoneyCnt);
    }
}
