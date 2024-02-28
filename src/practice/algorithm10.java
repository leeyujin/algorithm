package practice;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class algorithm10 {

    public static void main(String[] args) {

//        System.out.println(practice.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"} ));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"} ));

    }

    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            map.put( s, map.getOrDefault(s, 0) + 1 );
        }

        for (String s : completion) {
            map.put( s, map.get(s) -1 );
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if( stringIntegerEntry.getValue() == 1 ){
                return stringIntegerEntry.getKey();
            }
        }

        return null;
    }


}
