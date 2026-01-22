package com.avengers.javaalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JavaAlgorithmApplication {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        int peopleCnt = Integer.parseInt(br.readLine());
        for (int i = 1; i <= peopleCnt+1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            if(direction == 1){
                map.put(i, location);

            } else if (direction == 2) {
                map.put(i, 2*w+h-location);
            }else if (direction == 3){
                map.put(i, 2*w + 2*h - location);
            } else if (direction == 4 ) {
                map.put(i, w + location);
            }
        }

        int dongLocation = map.get(peopleCnt+1);
        int len = 2*w + 2*h;

        // 거리 계산
        for (int i = 1; i < peopleCnt+1 ; i++) {

            int currentLocation = map.get(i);
            int minusFromDong = Math.abs(currentLocation - dongLocation);



            // 동근이 보다 위치 값이 큰 경우
            if(dongLocation < currentLocation) {
                result += Math.min(minusFromDong, (dongLocation + (len - currentLocation)));

            }else{ /// 동근이 보다 위치 값이 작은 경우
                result += Math.min(minusFromDong, (len-dongLocation)+currentLocation);

            }
        }
        System.out.println(result);
    }
}