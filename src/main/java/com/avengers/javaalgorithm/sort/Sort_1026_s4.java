package com.avengers.javaalgorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Sort_1026_s4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int result = 0;

        for(int i = 0; i<n; i++){
            list1.add(Integer.parseInt(st1.nextToken()));
            list2.add(Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(list1);
        Collections.sort(list2,Collections.reverseOrder());

        for(int i = 0; i<n; i++){
            result+= list1.get(i) * list2.get(i);
        }

        System.out.println(result);

    }
}
