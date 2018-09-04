package domain

object ElementOrderInteractor {

    fun execute(powsMatrix: List<Array<Array<Int>>>): Array<Int> {
        val elemtsOrder = Array(powsMatrix.last().size, { 0 })
        for (i in 0..(powsMatrix.size - 2)) {
            for (j in 0..(elemtsOrder.size - 1)) {
                val leftSum = sumColumn(powsMatrix[i], j)
                val rightSum = sumColumn(powsMatrix[i + 1], j)
                if (leftSum > 0 && rightSum == 0) {
                    elemtsOrder[j] += leftSum
                } else {
                    if (leftSum > rightSum) elemtsOrder[j] += leftSum - rightSum
                    //else elemtsOrder[j] += rightSum - leftSum
                }
            }
        }
        return elemtsOrder
    }

    private fun sumColumn(matrix: Array<Array<Int>>, number: Int): Int {
        var sum = 0
        matrix.forEach {
            sum += it[number]
        }
        return sum
    }
}