package domain

import data.CircuitError

object MultiplyInteractor {

    private lateinit var powsMatrix: MutableList<Array<Array<Int>>>
    private lateinit var adjacencyMatrix: Array<Array<Int>>

    fun execute(adjacencyMatrix: Array<Array<Int>>): List<Array<Array<Int>>> {
        powsMatrix = mutableListOf()
        this.adjacencyMatrix = adjacencyMatrix

        recursive(adjacencyMatrix)
        val result = mutableListOf(adjacencyMatrix)
        result.addAll(powsMatrix)
        return result
    }

    @Throws(CircuitError::class)
    private fun recursive(matrix: Array<Array<Int>>): Array<Array<Int>> {
        if (powsMatrix.size >= 2 && contentEquals(powsMatrix[powsMatrix.size - 1], powsMatrix[powsMatrix.size - 2])) {
            return matrix
        } else {
            val result = multiply(adjacencyMatrix, try {
                powsMatrix.last()
            } catch (e: NoSuchElementException) {
                //powsMatrix.add(matrix)
                matrix
            })
            if (isHaveCycle(result)) throw CircuitError()
            powsMatrix.add(result)
            recursive(matrix)
        }
        return arrayOf()
    }

    private fun contentEquals(first: Array<Array<Int>>, second: Array<Array<Int>>): Boolean {
        if (first.size == second.size) {
            for (i in 0..(first.size - 1)) {
                if (!first[i].contentEquals(second[i])) return false
            }
            return true
        } else {
            return false
        }
    }

    private fun isHaveCycle(matrix: Array<Array<Int>>): Boolean {
        for (i in 0..(matrix.size - 1)) {
            for (j in 0..(matrix.size - 1)) {
                if (i == j) {
                    if (matrix[i][j] != 0) return true
                }
            }
        }
        return false
    }

    private fun multiply(first: Array<Array<Int>>,
                         second: Array<Array<Int>>): Array<Array<Int>> {
        val output = Array(first.size, { Array(second.size) { 0 } })
        first.withIndex().forEach {
            val i = it.index
            it.value.withIndex().forEach {
                val j = it.index
                for (k in 0..(first.size - 1)) {
                    output[i][j] += first[i][k] * second[k][j]
                }
            }
        }
        return output
    }
}