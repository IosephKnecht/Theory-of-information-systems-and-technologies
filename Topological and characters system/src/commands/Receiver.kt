package commands

import helper.Holder
import helper.Structures

class Receiver() {
    var matrix: Array<Array<Int>>? = Structures.structureA.mass
        get() = field
        private set(value) {
            field = value
        }

    fun addVertex() {
        val list = convertToList()
        //Line listener...
        val newLine = mutableListOf<Int>()
        for (i in 0..(matrix?.size ?: 1) - 1) {
            val sym = readLine()
            newLine.add(enterSym(sym))
        }
        //Add last diagonal element...
        newLine.add(0)

        //Native logic of method...
        list.add(newLine)
        for (i in 0..list.size - 2) {
            list[i].add(newLine[i])
        }
        val newMatrix = convertToArray(list)
        println("New vertex will be added...")
        matrix = newMatrix
    }

    fun removeVertex(index: Int) {
        val list = convertToList()
        if (index > 0 && index <= list.size) {
            list.removeAt(index - 1)
            list.forEach { it.removeAt(index - 1) }
            val newMatrix = Array(list.size, { Array(list.size, { 0 }) })
            for (i in 0..newMatrix.size - 1)
                for (j in 0..newMatrix.size - 1)
                    newMatrix[i][j] = list[i][j]
            matrix = newMatrix
            println("Success")

        } else println("Uncorrect vertex's index")
    }

    fun calcul() {
        val holder = Holder(matrix)
        println(holder)
    }

    fun addMatrix(rank: Int) {
        val enterMatrix = Array(rank, { Array(rank, { 0 }) })
        for (i in 0..rank - 1) {
            for (j in 0..rank - 1) {
                val sym = readLine()
                enterMatrix[i][j] = enterSym(sym)
            }
            println()
        }
        matrix = enterMatrix
    }

    private fun convertToList(): MutableList<MutableList<Int>> {
        var list: MutableList<MutableList<Int>> = mutableListOf()
        matrix?.forEach {
            list.add(mutableListOf())
            val index = list.size - 1
            it.forEach {
                list[index].add(it)
            }
        }
        return list
    }

    private fun convertToArray(list: MutableList<MutableList<Int>>): Array<Array<Int>> {
        val newMatrix = Array(list.size, { Array(list.size, { 0 }) })

        for (i in 0..newMatrix.size - 1)
            for (j in 0..newMatrix.size - 1)
                newMatrix[i][j] = list[i][j]
        return newMatrix
    }

    private fun enterSym(sym: String?): Int {
        var testSym = sym
        do {
            try {
                val value = testSym!!.toInt()
                if (value == 0 || value == 1) return value
                else throw UnsupportedOperationException()
            } catch (e: Exception) {
                println("Incorrect value")
                testSym = readLine()
            }
        } while (true)
    }
}