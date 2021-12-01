fun main() {
    fun part1(input: List<Int>): Int {
        var sum = 0;
        for (i in 1 until input.size) {
            if (input[i] > input[i - 1]) {
                sum++;
            }
        }
        return sum;
    }

    fun part2(input: List<Int>): List<Int> {
        val newList = arrayListOf<Int>()
        for (i in 1 until input.size - 1) {
            newList.add(input[i - 1] + input[i] + input[i + 1])
        }
        return newList
    }

    val testInput = readInput("input1")
    val mapInt = testInput.map { it.toInt() }
}
