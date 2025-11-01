package com.avengers.javaalgorithm.dingcodingco.week1;
import java.util.*;
import java.io.*;

public class s3_1929 {
    public static List<Integer> findPrimeListUnderNumber(int number) {
        List<Integer> primeList = new ArrayList<>();

        for (int n = 2; n <= number; n++) { // 2~number 까지의 숫자들이 n 에 들어가는 것을 반복한다.

            boolean isPrime = true;
            for (int i : primeList) { // 2 부터 n -1 까지를 i 에 들어가는 것을 반복한다.
                if (i * i <= n && n % i == 0) {    // n = 2, 3, 4, ... 20
                    isPrime = false;                //  n = 2 i = x -> 얘는 아무일도 안일어나고 prime_list 들어감.
                    break;                          //  n = 3 i = 2 -> 얘는 아무일도 안일어나고 prime_list 들어감.
                }                                   //  n = 4 i = 3, 2 -> break 문이 수행되게 되면, for else 의 else 가 실행되지 않습니다. 따라서, prime_list 에 들어가지 않는다.
            }
            if (isPrime) {
                primeList.add(n);
            }
        }

        return primeList;
    }

    public static void main(String[] args) {
        int input = 20;
        List<Integer> result = findPrimeListUnderNumber(input);
        System.out.println(result);
    }
}
