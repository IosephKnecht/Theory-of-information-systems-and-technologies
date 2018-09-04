package data

data class IncidenceMatrixes(val adjancencyMatrix: Array<Array<Int>>) {
    val inputMatrix: Array<Array<Int>>
    val outputMatrix: Array<Array<Int>>

    init {
        inputMatrix = execute({ i, j -> adjancencyMatrix[i][j] })
        outputMatrix = execute({ i, j -> adjancencyMatrix[j][i] })
    }

    private fun execute(block: (Int, Int) -> Int): Array<Array<Int>> {
        val matrix = Array<Array<Int>>(adjancencyMatrix.size,
                { Array<Int>(adjancencyMatrix.size, { 0 }) })
        adjancencyMatrix.withIndex().forEach {
            val i = it.index
            it.value.withIndex().forEach {
                matrix[i][it.index] = if (block(i, it.index) > 0) 1 else 0
            }

        }
        return matrix
    }

    override fun toString(): String {
        return super.toString()
    }
}