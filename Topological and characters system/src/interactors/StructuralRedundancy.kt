package interactors

class StructuralRedundancy(private val matrix: Array<Array<Int>>) {
    private fun execute(): Double {
        var sum = 0.0;
        for (i in 0..matrix.size - 1) {
            for (j in 0..matrix[i].size - 1) {
                if (i != j) {
                    sum += matrix[i][j];
                }
            }
        }
        return ((0.5) * sum * (1.0 / (matrix.size - 1))) - 1;
    }

    override fun toString(): String {
        return "Structural Redundancy = ${execute()}"
    }
}