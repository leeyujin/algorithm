package practice;

import java.util.Arrays;
import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class algorithm15 {

    public static void main(String[] args) {

        System.out.println( solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println( solution(new String[]{"123", "456", "789"}));
        System.out.println( solution(new String[]{"12", "123", "1235", "567", "88"}));

    }

    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        for(int i = 0 ; i < phone_book.length ; i ++ ){

            for(int j = i+1 ; j < phone_book.length ; j++){
                if( phone_book[j].startsWith( phone_book[i] ) ) {
                    return false;
                }
            }
        }

        return true;
    }


}
