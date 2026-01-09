package com.avengers.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gender;
        int number;

        int switchSize = Integer.parseInt(br.readLine());
        int[] switches = new int[switchSize+1];

        StringTokenizer st = new StringTokenizer(br.readLine());


        // 스위치 할당하기
        while (st.hasMoreTokens()){
            for (int i = 1; i <= switchSize ; i++) {
                switches[i] = Integer.parseInt(st.nextToken());
            }
        }

        int peopleCnt = Integer.parseInt(br.readLine());

        // 각 사람에 대하여 진행하기
        for (int i = 0; i < peopleCnt ; i++) {
            StringTokenizer peopleInfo = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(peopleInfo.nextToken());
            number = Integer.parseInt(peopleInfo.nextToken());

            // 성별이 남자라면
            if(gender == 1){
                for(int j = 1; j <= switchSize/number; j++ ){
                    int index = number*j;

                    // 배수에 해당하는 거 변경해줌
                    switches[index] = switches[index] ==  0? 1:0;
                }
            }else {
                //우선 현재 받은 수 부터 변경해주고
                switches[number] = switches[number] ==  0? 1:0;

                for(int j = 1; j<switchSize/2; j++){
                    int left = number - j;
                    int right = number + j;

                    if(right > switchSize || left < 1) break;
                    if(switches[left] == switches[right]){
                        if(switches[left] == 0){
                            switches[left] = 1;
                            switches[right] = 1;
                        }else{
                            switches[left] = 0;
                            switches[right] = 0;
                        }
                    }else break;

                }
            }

        }
        for(int i = 1; i<=switchSize; i++){
            System.out.print(switches[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }
}
