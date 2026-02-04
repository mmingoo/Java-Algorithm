package com.avengers.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class s1_2615 {

    static int[] dx = {-1,0,1,1};
    static int[] dy = {1,1,1,0};
    //맵 생성
    static int[][] map = new int[19][19];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 19 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 순차탐색
        for (int i = 0; i <19 ; i++) {
            for (int j = 0; j <19 ; j++) {
                if(map[i][j] != 0){

                    for (int k = 0; k < 4; k++) {
                        int cnt = countDol(i,j,map[i][j],k,1);

                        if(cnt == 5){
                            int prevR = i - dx[k] ;
                            int prevC = j - dy[k];
                            if(0<=prevR && prevR <19 && 0<= prevC && prevC < 19 && map[prevR][prevC] == map[i][j]){
                                continue;
                            }
                            System.out.println(map[i][j]);
                            System.out.println((i+1)+" "+(j+1));
                            return;
                        }
                    }
                }

            }
        }
        System.out.println(0);
    }

    public static int countDol(int currentR, int currentC, int color , int direction, int dolCnt ){
        int newR = currentR + dx[direction];
        int newC = currentC + dy[direction];
        int result = dolCnt;
        if(0<= newR && newR < 19 && 0<= newC && newC<19){
            if(color == map[newR][newC]){
                result = countDol(newR, newC, color, direction, result+1);

            }

        }
        return result;
    }
}