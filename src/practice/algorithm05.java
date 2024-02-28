package practice;

import java.util.*;

// 네트워크
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class algorithm05 {


    public static void main(String[] args) {
        int inputArr[][] = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        int inputArr2[][] = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };

        int inputArr3[][] = {
                {1,0,1,0,0},
                {0,1,0,0,0},
                {1,0,1,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };

        // 답 1
        int inputArr4[][] = {
                {1,0,0,1,1},
                {0,1,1,0,1},
                {0,1,1,1,0},
                {1,0,1,1,0},
                {0,1,0,0,1}
        };

        // 답 1, n = 7
        int[][] inputArr5= {
                {1,0,0,0,0,0,1},
                {0,1,1,0,1,0,0},
                {0,1,1,1,0,0,0},
                {0,0,1,1,0,0,0},
                {0,1,0,0,1,1,0},
                {0,0,0,0,1,1,1},
                {1,0,0,0,0,1,1}
        };


        System.out.println(solution(7, inputArr5));
    }

    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> networkList = new LinkedList<>();
    public static int solution(int n, int[][] computers) {

        if( n == 1 ){
            return 1;
        }

        // 반토막을 내서 값이 1이면 Queue.add
        for( int x = 1 ; x < n ; x ++){
            for( int y = 0 ; y <= x-1 ; y++ ){
                if( computers[x][y] == 1 ) {
                    queue.add(new int[]{x,y});
                }
            }
        }

        // Queue.remove -> X,Y 뒤집어서 값이 1이면 network에 추가
        while( !queue.isEmpty() ){
            int[] removed = queue.remove();
            int reversedX = removed[1];
            int reversedY = removed[0];
            if( computers[reversedX][reversedY] == 1 ){
                networkList.add(new int[]{reversedX, reversedY});
            }
        }

        // 네트워크 카운팅 - visited를 일차원 배열에 넣고, 0개수 +1, 예외 )  0만 n개, 1만 n개 일때
        int answer = 0;

        if( networkList.isEmpty() ){
            return n;
        }

        Queue<Integer> integerQueue = new LinkedList<>();
        int[] visitied = new int[n];


        while( !networkList.isEmpty()){
            int[] points = networkList.remove();
            int x = points[0];
            int y = points[1];
            integerQueue.add(x);
            integerQueue.add(y);

            while( !integerQueue.isEmpty() ) {
                Integer poll = integerQueue.poll();
                visitied[poll] = 1;

                Iterator<int[]> iterator = networkList.iterator();
                while (iterator.hasNext()) {
                    int[] ints = iterator.next();
                    int nx = ints[0];
                    int ny = ints[1];
                    if (poll == nx) {
                        integerQueue.add(ny);
                        iterator.remove();
                    } else if (poll == ny) {
                        integerQueue.add(nx);
                        iterator.remove();
                    }
                }

            }
            answer += 1;
        }

        for(int i = 0 ; i < n ; i++){
            if(visitied[i] == 0 ){
                answer += 1;
            }
        }

        return answer;
    }

}
