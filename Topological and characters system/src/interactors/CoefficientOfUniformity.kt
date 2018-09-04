package interactors

class CoefficientOfUniformity(val matrix: Array<Array<Int>>) {

    private fun valueOfRibs(): Int {
        var sum = 0;
        for (i in 0..matrix.size - 1) {
            for (j in i + 1..matrix[i].size - 1) {
                sum += if (matrix[i][j] != 0) 1 else 0
            }
        }
        return sum;
    }

    private fun execute(): Double {
        var sum = 0.0;
        for (i in 0..matrix.size - 1) {
            sum += Math.pow(calculStrSum(i).toDouble(), 2.0);
        }
        return sum - 4 * (Math.pow(valueOfRibs().toDouble(), 2.0) / matrix.size);
    }

    private fun calculStrSum(strNum: Int): Int {
        var sum = 0;
        for (i in 0..matrix[strNum].size - 1) {
            sum += matrix[strNum][i]
        }
        return sum;
    }

    override fun toString(): String {
        return "Coefficient of uniformity=${execute()}";
    }
}