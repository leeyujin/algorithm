import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java
// 최단거리
public class algorithm03 {


    static int[] dx = {1 , 0 , -1 , 0};
    static int[] dy = {0 , 1 , 0 , -1};
    static int sum = 1;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        // 11
        int inputArr[][] = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        // -1
        int inputArr2[][] = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        };
        System.out.println(solution(inputArr));
//        System.out.println(solution(inputArr2));

    }

    public static int solution(int[][] maps) {
//        int answer = getBfsAnswer(maps);
        int answer = getDfsAnswer(maps);
        return answer;
    }

    private static int getBfsAnswer(int[][] maps) {
        int[][] visited =  new int[maps.length][maps[0].length];
        visited[0][0]= 1;

        // if 1. 이동할 곳 좌표 == 1 && visited[이동할곳] == 0
        bfs(maps, visited);
        int answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }

    public static void bfs(int[][] maps, int[][] visited){
        Queue<int[]> queue = new LinkedList<>();

        int[] initVal = {0,0};
        queue.add(initVal);

        while(!queue.isEmpty()) {
            int[] remove = queue.remove();
            int cX = remove[0];
            int cY = remove[1];

            for (int i = 0; i < 4; i++) {

                int mX = cX + dx[i];
                int mY = cY + dy[i];

                if (mX < 0 || mX >= maps.length || mY < 0 || mY >= maps[0].length) {
                    continue;
                }

                if (maps[mX][mY] == 1 && visited[mX][mY] == 0) {
                    visited[mX][mY] = visited[cX][cY] + 1;
                    int[] intVal = {mX, mY};
                    queue.add(intVal);
                }
            }
        }
    }

    private static int getDfsAnswer(int[][] maps) {
        int[][] visited =  new int[maps.length][maps[0].length];
        visited[0][0]= 1;

        return dfs(0, 0, maps, visited);

    }


    public static int dfs(int cX, int cY, int[][] maps, int[][] visited){

        for (int i = 0; i < 4; i++) {
            int mX = cX + dx[i];
            int mY = cY + dy[i];
            if (mX >= 0 && mX < maps.length && mY >= 0 && mY < maps[0].length && maps[mX][mY] == 1 && visited[mX][mY] == 0 ) {
                visited[mX][mY] = 1;
                sum ++;

                if (mX == maps.length - 1 && mY == maps[0].length - 1) {
                    return sum;
                }
                return dfs(mX, mY, maps, visited);
            }
        }
        return -1;

    }



}
