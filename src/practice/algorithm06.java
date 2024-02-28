package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.youtube.com/watch?v=UsWY77CCqSg&ab_channel=algorithmjobs

// yeaaonmmuunaeem -> yeoam
// helloolleh ->
// aaaaa -> a

public class algorithm06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // String -> char arrList 로 변환
        char[] charArray = input.toCharArray();
        List<Character> charList = IntStream.range(0, charArray.length)
                .mapToObj(i -> charArray[i])
                .collect(Collectors.toList());

        // 0번 index부터 순차검색 -> 다음 요소와 같으면 제거
        for(int i = 0 ; i < charList.size() ; ){
            if( i + 1 < charList.size() ){
                if( charList.get(i) == charList.get(i+1) ){
                    charList.remove(i);
                    charList.remove(i);
                    i = 0;
                    continue;
                }
            }
            i++;
        }

        System.out.println("charList = " + charList);


        // 다시반복 -> 마지막index와 같을때 return
    }

}
