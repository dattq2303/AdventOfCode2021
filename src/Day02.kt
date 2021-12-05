enum class Move {
    FORWARD {
        override fun changePosition(position: Position, value: Int): Position {
            position.horizontal = position.horizontal + value;
            return position;
        }

        override fun changePositionWithAim(position: AimPosition, value: Int, aim: Int): AimPosition {
            position.horizontal = position.horizontal + value;
            position.depth = position.depth + (value * aim);
            return position;
        }
    },
    UP {
        override fun changePosition(position: Position, value: Int): Position {
            position.depth = position.depth + value;
            return position;
        }

        override fun changePositionWithAim(position: AimPosition, value: Int, aim: Int): AimPosition {
            position.aim = position.aim - value;
            return position
        }

    },
    DOWN {
        override fun changePosition(position: Position, value: Int): Position {
            position.depth = position.depth - value;
            return position; }

        override fun changePositionWithAim(position: AimPosition, value: Int, aim: Int): AimPosition {
            position.aim = position.aim + value;
            return position
        }
    }, ;

    abstract fun changePosition(position: Position, value: Int): Position
    abstract fun changePositionWithAim(aimPosition: AimPosition, value: Int, aim: Int): AimPosition
}

class MoveValue(val type: Move, val value: Int);

class Position(var depth: Int, var horizontal: Int)

class AimPosition(var depth: Int, var horizontal: Int, var aim: Int);



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

    val testInput = readInput("input2")
    val inputDay2 = testInput.map { it.split(" "); }

    val moveList: MutableList<MoveValue> = mutableListOf()

    for (input in inputDay2) {
        when (input[0]) {
            "forward" -> moveList.add(MoveValue(Move.FORWARD, input[1].toInt()))
            "up" -> moveList.add(MoveValue(Move.UP, input[1].toInt()))
            "down" -> moveList.add(MoveValue(Move.DOWN, input[1].toInt()))
            else -> {
            }
        }
    }


//    val position = Position(0, 0)
//    for (value1 in moveList) {
//        print(" ${value1.type} + ${value1.value} ")
//        println()
//        value1.type.changePosition(position, value1.value)
//        print(" ${position.depth} + ${position.horizontal} ")
//        println()
//    }

    val aimPosition = AimPosition(0, 0, 0)
    for (value in moveList) {
        print(" ${value.type} + ${value.value} ")
        println()

        value.type.changePositionWithAim(aimPosition, value.value, aimPosition.aim)
        print(" ${aimPosition.depth} + ${aimPosition.horizontal} + ${aimPosition.aim}")
        println()
    }

}

