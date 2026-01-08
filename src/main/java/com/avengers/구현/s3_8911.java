package com.avengers.구현;

import com.avengers.javaalgorithm.JavaAlgorithmApplication;
import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_8911 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //방향 북서남동
        int [] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1};



        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            String directions = br.readLine();

            // 여기서 초기화!
            int nowX = 0, minX = 0, maxX = 0;
            int nowY = 0, minY = 0, maxY = 0;
            int dr = 0;

            for(int i =0; i<directions.length(); i++) {
                char command = directions.charAt(i);
                
                if(command == 'F'){
                    nowX = nowX + dx[dr];
                    nowY = nowY + dy[dr];
                } else if (command == 'B') {
                    nowX = nowX - dx[dr];
                    nowY = nowY - dy[dr];
                } else if (command == 'R') {
                    if(dr == 0) dr =3;
                    else dr--;
                } else if (command == 'L') {
                    if(dr == 3) dr =0;
                    else dr++;
                }


                minX = Math.min(nowX, minX);
                maxX = Math.max(nowX, maxX);
                minY = Math.min(nowY, minY);
                maxY = Math.max(nowY, maxY);
            }


            int h = Math.abs(minY) + Math.abs((maxY));
            int w = Math.abs(minX) + Math.abs((maxX));

            System.out.println(h*w);


        }

    }




}
