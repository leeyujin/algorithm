package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// https://youtu.be/59QSZJ7_Zhw?si=Mw8ycyeaVdpbpPOX
public class algorithm04_1 {

    static int N;
    static int M;
    static int[][] map;
    static Queue<int[]> virusQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 지도의 세로 크기 N과 가로 크기 M을 읽어옴
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];

        // 2차원 배열을 생성하여 좌표를 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
                if( map[i][j] == 2 ){
                    virusQueue.add(new int[]{i,j});
                }
            }
        }
        resursive(0);
        System.out.println(max);
    }


    static int max = 0;
    public static void resursive(int index){
        if( index == 3 ){
            int result = bfs();
            max = Math.max(max, result);
            return;
        }

        /**
         * 요것이 핵심..
         *  N * M을 전체 도는 방법..
         */
        for(int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j++) {
                if( map[i][j] == 0){
                    map[i][j] = 1;
                    resursive(index+1);
                    map[i][j]=0;
                }
            }
        }
    }

    static int[] dx = {1 , 0 , -1 , 0};
    static int[] dy = {0 , 1 , 0 , -1};
    private static int bfs() {
        // 2의 위치를 기준으로 바이러스를 퍼뜨린다
        Queue<int[]> virusClonedQueue = new LinkedList<>();
        virusClonedQueue.addAll(virusQueue);
        int[][] visitied = new int[N][M];

        while(!virusClonedQueue.isEmpty()){
            int[] removed = virusClonedQueue.remove();
            int cX = removed[0];
            int cY = removed[1];

            for (int i = 0; i < 4; i++) {
                int mX = cX + dx[i];
                int mY = cY + dy[i];
                if (mX < 0 || mX >= map.length || mY < 0 || mY >= map[0].length) {
                    continue;
                }

                if(map[mX][mY] == 0 && visitied[mX][mY] ==0){
                    visitied[mX][mY] = 1;
                    virusClonedQueue.add(new int[]{mX,mY});
                }
            }
        }

        // 0의 개수 구한다
        int count = 0;
        for(int i = 0 ; i < N ; i ++){
            for (int j = 0 ; j < M ; j++){
                if( visitied[i][j] == 0 && map[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }
}
















