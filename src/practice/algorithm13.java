package practice;

import java.util.Arrays;
import java.util.Comparator;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class algorithm13 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{6, 10, 2})); // "6210"
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{0, 0, 0}));

    }


    public static String solution(int[] numbers) {
        // 모든 요소가 0인지 확인
        boolean allZeros = true;
        for (int num : numbers) {
            if (num != 0) {
                allZeros = false;
                break;
            }
        }
        if (allZeros) {
            return "0";
        }

        // 숫자 배열을 문자열 배열로 변환
        String[] numStrings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStrings[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 조합하여 가장 큰 수로 만들기
        Arrays.sort(numStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String case1 = s1 + s2;
                String case2 = s2 + s1;
                return case2.compareTo(case1); // 내림차순 정렬
            }
        });

        // 정렬된 문자열 배열을 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (String str : numStrings) {
            sb.append(str);
        }

        // 만들어진 문자열 반환
        return sb.toString();
    }
}
