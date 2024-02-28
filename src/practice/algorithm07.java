package practice;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class algorithm07 {

    public static void main(String[] args) {
//
        System.out.println( solution(5, new int[]{3,4}, new int[]{4,5})); // 4
        System.out.println( solution(7, new int[]{2,4,7}, new int[]{1,3,5})); // 6
        System.out.println( solution(10, new int[]{3,4,9,7}, new int[]{8,2,3})); // 8
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 중복 제거
        Set<Integer> lostSet = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());

        Set<Integer> reserveSet = Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet());

        Queue<Integer> lostQ = Arrays.stream(lost)
                .filter(i -> ! reserveSet.contains(i))
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        Queue<Integer> reserveQ = Arrays.stream(reserve)
                .filter(i -> ! lostSet.contains(i))
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int answer = n - lostQ.size();


        // lostQ 비어있는지 기준 ->  reserveQ.pop()-1 == lostQ.pop() || == reserveQ.pop()+1, 이면 count +1,
        while( ! lostQ.isEmpty() ){

            if( ! reserveQ.isEmpty() ){
                Integer lostNum = lostQ.poll();
                Integer reserveNum = reserveQ.poll();

                if( reserveNum - lostNum == -1 || reserveNum - lostNum == 1 ){
                    answer += 1;
                }
            }else{
                break;
            }
        }

        return answer;
    }

}
