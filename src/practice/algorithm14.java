package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class algorithm14 {
    public static void main(String[] args) {
//        System.out.println(practice.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5,15}}));
    }

    public static int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        // 모든 명함을 순회하며 가장 긴 가로 길이와 세로 길이를 찾음
        for (int[] size : sizes) {
            maxWidth = Math.max(maxWidth, Math.max(size[0], size[1]));
            maxHeight = Math.max(maxHeight, Math.min(size[0], size[1]));
        }

        return maxWidth * maxHeight;
    }
}
