package practice;/*
class practice.Solution {

    int[] dx = {1 , 0 , -1 , 0};
    int[] dy = {0 , 1 , 0 , -1};
    int sum = 1;


    public int practice.solution(int[][] maps) {
        int[][] visited =  new int[maps.length][maps[0].length];
        visited[0][0]= 1;

        return dfs(0, 0, maps, visited);
    }

    public  int dfs(int cX, int cY, int[][] maps, int[][] visited){

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
}*/
