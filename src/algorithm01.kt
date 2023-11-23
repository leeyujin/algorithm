
// https://www.youtube.com/watch?v=IlMVmQ7hG4w&ab_channel=algorithmjobs
// 단짠단짠
/**

Q1)
6
5 -5 6 0 2 -8
답 -> 4

Q2)
5
-5 3 0 -3 10
답 -> 2
 */

fun main(){
    val foodCount = readLine()
    var foodFlavorList: List<Int> = readLine()!!
        .split(" ")
        .map { it.toInt() }

//    완전탐색(foodFlavorList)
    누적합배열_카운팅맵(foodFlavorList)


}

// 시간복잡도 초과
private fun 완전탐색(foodFlavorList: List<Int>) {
    var foodFlavorList1 = foodFlavorList
    var result = 0

    result += foodFlavorList1.filter { it == 0 }.size
    foodFlavorList1 = foodFlavorList1.filter { it != 0 }

    for (idx in foodFlavorList1.indices) {
        var accumulateFlavor = 0
        for (idx2 in idx until foodFlavorList1.size) {
            accumulateFlavor += foodFlavorList1[idx2]
            // 누적합 0
            if (accumulateFlavor == 0) {
                result += 1
            }
        }
    }
    println(result)
}

private fun 누적합배열_카운팅맵(foodFlavorList: List<Int>) {

    // 카운팅맵
    var numCountMap = HashMap<Int, Int>()
    var result = 0

    // 누적합배열
    var accumulateList = mutableListOf(0)
    for (idx in foodFlavorList.indices) {
        accumulateList.add(accumulateList[idx] + foodFlavorList[idx])
    }

    accumulateList.forEach { data ->
        if (numCountMap[data] == null) {
            numCountMap[data] = 1
        } else {
            // 이전에 같은 값이 존재 시, 카운팅
            result += numCountMap[data]!!
            numCountMap[data] = numCountMap[data]!! + 1
        }
    }

    println(result)
}

