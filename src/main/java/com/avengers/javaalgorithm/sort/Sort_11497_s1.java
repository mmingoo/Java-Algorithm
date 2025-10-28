package com.avengers.javaalgorithm.sort;
import java.util.*;
import java.io.*;

public class Sort_11497_s1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();
            int max = 0;
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            // 양쪽으로 번갈아 배치
            for (int k = 0; k < n; k++) {
                if (k % 2 == 0) dq.offerFirst(arr[k]);
                else dq.offerLast(arr[k]);
            }

            // Deque → List 변환
            List<Integer> list = new ArrayList<>(dq);

            // 인접 원소 간 차이 계산 (원형)
            for (int l = 0; l < list.size(); l++) {
                int next = (l + 1) % list.size();
                int diff = Math.abs(list.get(l) - list.get(next));
                max = Math.max(max, diff);
            }

            System.out.println(max);
        }
    }
}
