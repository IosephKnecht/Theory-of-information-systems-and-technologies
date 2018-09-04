package domain

import data.ClockCharacters

object ClockCharacterInteractor {
    private lateinit var matrix: Array<Array<Int>>
    private lateinit var elementsOrder: Array<Int>

    fun execute(matrix: Array<Array<Int>>, elementsOrder: Array<Int>): ClockCharacters {
        this.matrix = matrix
        this.elementsOrder = elementsOrder

        val convertedMatrix = convertMatrix()

        val unusableClockDocs = mutableListOf<Int>()
        val usableClockDocs = mutableListOf<Int>()

        convertedMatrix.forEach {
            unusableClockDocs.add(it.max() ?: 0)
        }

        for (i in 0..(elementsOrder.size - 1)) {
            val sum = unusableClockDocs[i] - elementsOrder[i]
            usableClockDocs.add(if (sum > 0) sum else 0)
        }

        return ClockCharacters(unusableClockDocs.toTypedArray(), usableClockDocs.toTypedArray())
    }

    private fun convertMatrix(): Array<Array<Int>> {
        val convertedMatrix = Array(matrix.last().size, { Array(matrix.last().size, { 0 }) })
        matrix.withIndex().forEach {
            val i = it.index
            it.value.withIndex().forEach {
                if (it.value > 0) convertedMatrix[i][it.index] = elementsOrder[it.index]
            }
        }
        return convertedMatrix
    }
}