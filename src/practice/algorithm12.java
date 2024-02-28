package practice;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class algorithm12 {

    public static void main(String[] args) {
        solution(new int[]{93,30,55}, new int[]{1,30,5});
        solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        // 100 - progress[i] 를 push

        Queue<Integer> remainDayList = new LinkedList<>();
        for (int i = 0 ; i < progresses.length ; i ++ ) {
            double remainDay = Math.ceil( (double)( 100 - progresses[i] ) / speeds[i] );
            remainDayList.add((int)remainDay);
        }
        // [7, 90, 45] / speeds[1,30,5] 를 push -> [ 7, 3, 9 ]

        Integer maxVal = remainDayList.poll();
        int count = 1;
        List<Integer> result = new ArrayList<>();
        while (!remainDayList.isEmpty()){
            Integer poll = remainDayList.poll();
            // 7 > -1 -> count 증가
            if( maxVal >= poll){
                count++;
            }else{
                maxVal = poll;

                result.add(count);
                count = 1;
            }
        }
        result.add(count);

        // [7, 3, 9] 하나씩 pop하면서 다음요소가 더 작으면 +1 해서 push
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;

    }

}
