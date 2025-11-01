package com.avengers.javaalgorithm.dingcodingco.week1;

import java.util.*;
import java.io.*;

public class s5_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] strArr = str.toCharArray();

        int zeroCnt = 0;
        int oneCnt = 0;
        boolean action = false;

        for (char c : strArr) {
            if (c == '0') {
                if (!action) {
                    zeroCnt++;
                    action = true;
                }

            } else {
                action = false;
            }
        }

        boolean action2= false;

        for (char c : strArr) {
            if (c == '1') {
                if (!action2) {
                    oneCnt++;
                    action2 = true;
                }

            } else {
                action2 = false;
            }
        }

        System.out.println(Math.min(zeroCnt,oneCnt));

    }

}
