package interactors

import java.util.*

class WarshallAlgorithm(private var adjacencyMatrix: Array<Array<Int>>) {

    private val d: Array<Array<Int>>
    private val n: Int

    init {
        n = adjacencyMatrix.size
        d = Array(adjacencyMatrix.size, { Array(adjacencyMatrix.size, { 0 }) })
        for (i in 0..n - 1) {
            for (j in 0..n - 1) {
                if (i == j) continue
                d[i][j] = if (adjacencyMatrix[i][j] == 1) 1 else Int.MAX_VALUE
            }
        }
        execute()
    }

    fun execute(): Array<Array<Int>> {
        for (k in 0..n - 1)
            for (i in 0..n - 1)
                for (j in 0..n - 1) {
                    if (d[i][k] != Int.MAX_VALUE && d[k][j] < Int.MAX_VALUE)
                        if (d[i][k] + d[k][j] < d[i][j])
                            d[i][j] = d[i][k] + d[k][j]
                }
        //val hash = d.map { ints -> ints.max() }.toTypedArray() as Array<Int>
        return d
    }
}