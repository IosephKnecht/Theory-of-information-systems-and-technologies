package interactors

class StructuralCompactness(val warshall: WarshallAlgorithm) {
    fun execute(): Double {
        val matrix = warshall.execute()
        var commonQ = 0
        val n = matrix.size

        for (i in 0..n - 1)
            for (j in 0..n - 1) {
                if (i != j) commonQ += matrix[i][j]
            }

        return (commonQ.toDouble() / (n * (n - 1))) - 1
    }
}