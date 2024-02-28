package practice;

import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class algorithm09 {

    public static void main(String[] args) {

        System.out.println( solution( new int[]{3,1,2,3} ) );
        System.out.println( solution( new int[]{3,3,3,2,2,4} ) );
        System.out.println( solution( new int[]{3,3,3,2,2,2} ) );
    }

    public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min( set.size() ,  nums.length / 2 );
    }
}
