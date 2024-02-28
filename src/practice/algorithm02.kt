package practice

// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=kotlin
// 타켓넘버
class Solution {
    lateinit var numbers: IntArray
    var target: Int = 0
    var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        this.numbers = numbers;
        this.target = target;

        // n번째 요소 +1, -1
        dfs(0,0)
        return answer
    }

    private fun dfs(idx: Int, sum: Int) {

        if( idx == numbers.size ){
            if( sum == target ){
                answer ++
            }
            return;
        }

        dfs( idx +1, sum + numbers[idx])
        dfs( idx +1, sum - numbers[idx])
    }
}






