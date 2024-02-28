package practice

fun main() {

    val solution = solution(intArrayOf(1, 1,1, 1,1), 3)
    println(solution)

 /*  val a = listOf(0,2)
    val data = a.run {
        map { println(it)
            it + 1
        } +
                map { println(it)
                    it - 1
                }
    }
    println(listOf(1,3) + listOf(-1,1))

    println(listOf(1,2,3,3,4).count { it == 3 })*/

}

fun solution(numbers: IntArray, target: Int): Int {
    val fold = numbers.fold(listOf(0)) { list, i ->
        list.run {
            map { it + i } + map { it - i }
        }
    }
    println(fold)
    return fold.count{ it == target}
}