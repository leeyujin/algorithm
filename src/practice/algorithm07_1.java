package practice;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class algorithm07_1 {

    public static void main(String[] args) {

    }

    public static int solution(int n, int[] lost, int[] reserve) {

        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for (int i : reserve) {
            resSet.add(i);
        }
        for (int i : lost) {
            if( resSet.contains(i) )
                resSet.remove(i);
            else
                lostSet.add(i);
        }

        for (int i : resSet) {
            if( lostSet.contains(i-1) )
                lostSet.remove(i-1);
            else if( lostSet.contains(i+1) )
                lostSet.remove(i+1);
        }

        return  n - lostSet.size();
    }

}
