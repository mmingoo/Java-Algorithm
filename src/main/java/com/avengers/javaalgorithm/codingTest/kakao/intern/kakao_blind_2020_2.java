package com.avengers.javaalgorithm.codingTest.kakao.intern;

import java.io.IOException;
import java.util.*;

class kakao_blind_2020_2 {

    public static void main(String[] args) throws IOException {
        String s = "(()())()";
        System.out.println(getChangeResult(s));       // (()())()
        System.out.println(getChangeResult("()))((()")); // ()(())()
    }

    public static String getChangeResult(String s) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (s.isEmpty()) return "";

        // 2. 문자열 w를 u, v로 분리
        String[] separated = separateToUV(s);
        String u = separated[0];
        String v = separated[1];

        // 3. 문자열 u가 올바른 괄호 문자열이라면
        if (isCorrectParenthesis(u)) {
            // v에 대해 재귀적으로 수행한 결과를 u에 이어 붙여 반환
            return u + getChangeResult(v);
        }

        // 4. 문자열 u가 올바르지 않다면 아래를 수행
        else {
            StringBuilder result = new StringBuilder();
            result.append('(');
            result.append(getChangeResult(v));
            result.append(')');

            // u의 첫 번째, 마지막 문자를 제거하고 나머지 괄호 방향을 뒤집음
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i < u.length() - 1; i++) {
                char ch = u.charAt(i);
                temp.append(ch == '(' ? ')' : '(');
            }

            result.append(temp);
            return result.toString();
        }
    }

    // 균형잡힌 괄호 문자열 u, v로 분리
    private static String[] separateToUV(String s) {
        int leftCnt = 0;
        int rightCnt = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') leftCnt++;
            else rightCnt++;

            u.append(ch);

            if (leftCnt == rightCnt) {
                v.append(s.substring(i + 1));
                break;
            }
        }

        return new String[]{u.toString(), v.toString()};
    }

    // 올바른 괄호 문자열 판단 함수
    public static boolean isCorrectParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
