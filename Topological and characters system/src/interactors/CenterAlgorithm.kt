package interactors

import kotlin.math.pow

class CenterAlgorithm(val dMatrix: Array<Array<Int>>) {
    private val q: Double
    private val listZi = mutableListOf<Double>()

    init {
        q = calculQ();

        var j = -1
        dMatrix.forEach {
            listZi.add(calculZi(++j))
        }
    }

    fun execute(): Double {
        val maxZi = listZi?.max()
        val result = (dMatrix.size - 1) * 2 * maxZi!! * (1.0 / (maxZi * dMatrix.size - 2))
        return result
    }

    private fun calculZi(strNum: Int): Double {
        var sum = 0
        for (i in 0..dMatrix.size - 1)
            sum += dMatrix[strNum][i]

        return (q / 2) * (1.0 / sum)
    }

    private fun calculQ(): Double {
        var sum: Double = 0.0
        for (i in 0..dMatrix.size - 1)
            for (j in 0..dMatrix.size - 1) {
                if (i != j) sum += dMatrix[i][j]
            }
        return sum
    }
}