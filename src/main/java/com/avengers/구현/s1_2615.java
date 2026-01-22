package com.avengers.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_2615 {
    static int[][] map = new int[19][19];
    static int[][][] memo = new int[19][19][4];

    static int dx[] = {-1,0,1,1};
    static int dy[] = {1,1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i <19 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j<19; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(findFive());
        }

    }

    private static String findFive() {
        for (int i = 0; i <19 ; i++) {
            for (int j = 0; j <19 ; j++) {
                if (map[i][j] != 0){
                    for (int k = 0; k <4 ; k++) {
                        if(memo[i][j][k] == 0 && calc(i,j,k,map[i][j]) == 5){
                            return map[i][j] + "\n" + i +" " + j;
                        }

                    }
                }
            }
        }
        return "0";
    }

    private static int calc(int i, int j, int k, int color) {
        int nx = i + dx[k];
        int ny = j + dy[k];

        if(map[i][j] == color){
            return memo[i][j][k] =  calc(nx,ny,k,color) + 1;
        }
        return 1;

    }


}
