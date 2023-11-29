// https://www.acmicpc.net/problem/14502 연구소

import java.util.*;

public class algorithm04 {

    static int[] dx = {1 , 0 , -1 , 0};
    static int[] dy = {0 , 1 , 0 , -1};
    static Queue<int[]> virusQueue = new LinkedList<>();
    static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄에서 지도의 세로 크기 N과 가로 크기 M을 읽어옴
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 2차원 배열을 생성하여 좌표를 저장
        int[][] map = new int[N][M];

        // 벽을세움
        // (0,0) 부터 시작해서 이동시키며 지정
        int cX = 0;
        int cY = 0;
        int wallCount = 0;
        int[][] visitied = new int[N][M];


        // 둘째 줄부터 좌표를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
                if( map[i][j] == 1){
                    visitied[i][j] = 1;
                }

                if( map[i][j] == 2){
                    // 2위치는 visitied 1로 설정
                    visitied[i][j] = 1;
                    // 2위치는 Queue에 저장
                    virusQueue.add(new int[]{i,j});

                }
            }
        }

        dfs(cX, cY, wallCount, map, visitied);
        System.out.println(Collections.max(results));


        // 바이러스 퍼뜨림
        // 2근처 -> bfs
        // 안전구역 구하기


    }

    private static void dfs( int cX, int cY, int wallCount, int[][] map, int[][] visitied) {
        int N = map.length;
        int M = map[0].length;
        for (int i = 0; i < 4; i++) {
            int mX = cX + dx[i];
            int mY = cY + dy[i];
            // 방문 가능 시
            boolean canVisit = mX >= 0 && mX < N &&
                    mY >= 0 && mY < M &&
                    map[mX][mY] == 0 && visitied[mX][mY] == 0 && wallCount < 3;
            if (canVisit) {
                visitied[mX][mY] = 1;
                map[mX][mY] = 1;
                wallCount++;
                // 벽 3개 세웠을 때
                if (wallCount == 3) {
                    // 바이러스 퍼뜨리고 , 안전구역 개수 구하기
                    bfs(N, M, map);

                    // 마지막 것 다시 0으로
                    map[mX][mY] = 0;
                    wallCount--;
                }

                // 전체 다 방문 시 종료
                boolean isAllOne = true;
                Loop1:
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (visitied[j][k] == 0) {
                            isAllOne = false;
                            break Loop1;
                        }
                    }
                }
                if (isAllOne) {
                    return;
                } else {
                    dfs(mX, mY, wallCount, map, visitied);
                }
            }
        }
    }

    private static void bfs(int N, int M, int[][] map) {
        Queue<int[]> virusCloneQueue = new LinkedList<>();
        virusCloneQueue.addAll(virusQueue);
        while( ! virusCloneQueue.isEmpty() ) {
            Queue<int[]> queue = new LinkedList<>();


            int[] virusPos = virusCloneQueue.remove();
            queue.add(virusPos);

            boolean isOneTimeMoved = false;
            int[][] mapClone = new int[N][M];
            for(int i = 0 ; i < N ; i++){
                for( int j = 0 ; j < M ; j++){
                    mapClone[i][j] = map[i][j];
                }
            }
            while(! queue.isEmpty()) {


                int[] remove = queue.remove();
                int vX = remove[0];
                int vY = remove[1];
                for (int j = 0; j < 4; j++) {

                    int vmX = vX + dx[j];
                    int vmY = vY + dy[j];

                    if (vmX < 0 || vmX >= map.length || vmY < 0 || vmY >= map[0].length) {
                        continue;
                    }

                    if (mapClone[vmX][vmY] == 0) {
                        isOneTimeMoved = true;
                        // 전염
                        mapClone[vmX][vmY] = 2;
                        int[] intVal = {vmX, vmY};
                        queue.add(intVal);
                    }
                }
            }

            if(isOneTimeMoved) {
                // 안전구역 개수 구하기
                int count = 0;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (mapClone[j][k] == 0) {
                            count++;
                        }
                    }
                }
                results.add(count);
            }
        }
    }
}
