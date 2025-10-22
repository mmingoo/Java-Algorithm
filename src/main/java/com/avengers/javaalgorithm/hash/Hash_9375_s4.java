package com.avengers.javaalgorithm.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hash_9375_s4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String ,Integer> clotheKindCntMap = new HashMap<>();
        int cnt = 1;
        int n = sc.nextInt();

        for(int i = 0; i<n; i++){
            int m = sc.nextInt();

            for(int j =0; j < m; j++){
                System.out.println("입력 받기!");
                String nameKind = sc.nextLine();
                String[] nameKindArr = nameKind.split(" ");
                String kind = nameKindArr[1];

                clotheKindCntMap.put(kind,clotheKindCntMap.getOrDefault(kind,1)+1);
            }

            for(Map.Entry<String, Integer> map : clotheKindCntMap.entrySet()){
                cnt *= map.getValue()+1;
            }

            System.out.println(cnt-1);
        }


    }
}