package practice;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class algorithm11 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,1,3,3,0,1,1}));
        System.out.println(solution(new int[]{4,4,4,3,3}));


    }

    public static int[] solution(int[] arr) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i : arr) {
            queue.add(i);
        }

        int beforeNum = -1;
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            Integer poll = queue.poll();

            if(beforeNum != poll){
                list.add(poll);
                beforeNum = poll;
            }

        }

        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
