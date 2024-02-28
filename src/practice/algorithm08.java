package practice;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860
// https://born2bedeveloper.tistory.com/26
public class algorithm08 {

    public static void main(String[] args) {

        System.out.println(solution("JAN"));
    }

    public static int solution(String name) {
        int answer = 0;
        int leftRightMin = name.length() - 1;

        for( int i = 0 ; i < name.length() ; i ++) {
            // 상-하 이동 최소값 min(case1, case2)
            // case1) 뒤 알파벳 idx - 'A'
            // case2) 26 - 뒤 알파벳 idx + 1
            answer += Math.min( name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')  );

            if( i + 1 < name.length()  && name.charAt(i+1) == 'A' ){
                int endA = i+1;
                while( endA < name.length() && name.charAt(endA) == 'A' )
                    endA += 1;
                leftRightMin = Math.min( leftRightMin ,  i * 2 + ( name.length() - endA) );  // 오 -> 왼
                leftRightMin = Math.min( leftRightMin , (name.length() - endA) * 2 + i );
            }
        }

        return answer+ leftRightMin;
    }
}
