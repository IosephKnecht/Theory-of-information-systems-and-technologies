package domain

import data.IncidenceMatrixes
import data.Vertex

object LevelInteractor {
    private var inputMatrix = mutableListOf<MutableList<Int>>()
    private lateinit var incidentMatrix: IncidenceMatrixes

    private fun convertInputMatrix() {
        incidentMatrix.inputMatrix.forEach {
            inputMatrix.add(it.toMutableList())
        }
    }

    fun execute(incidentMatrix: IncidenceMatrixes): Array<Array<Vertex>> {
        this.incidentMatrix = incidentMatrix
        convertInputMatrix()

        val levelList = mutableListOf<MutableList<Vertex>>()
        while (inputMatrix.isNotEmpty()) {
            val removeList = mutableListOf<Int>()
            inputMatrix.withIndex().forEach {
                if (nullVertex(it.index)) removeList.add(it.index)
            }
            levelList.add(addVertexesOnLevel(removeList.toTypedArray(), countVertexesOnLevels(levelList),
                    try {
                        val value = levelList.last().size - 1
                        if (value == 0) removeList.size else value
                    } catch (e: Exception) {
                        0
                    }).toMutableList())
            removeVertexes(removeList.toTypedArray())
        }
        return levelList.map { it.toTypedArray() }.toTypedArray()
    }

    private fun nullVertex(i: Int): Boolean {
        inputMatrix.withIndex().forEach {
            if (inputMatrix[it.index][i] != 0) return false
        }
        return true
    }

    private fun removeVertexes(list: Array<Int>) {
        val sortList = list.sortedArray()
        var rowCount = 0
        sortList.forEach {
            val index = it
            inputMatrix.forEach {
                it.removeAt(index - rowCount)
            }
            rowCount++
        }
        var count = 0
        sortList.forEach {
            inputMatrix.removeAt(it - count)
            count++
        }
    }

    private fun addVertexesOnLevel(list: Array<Int>, count: Int, lastLevelSise: Int): Array<Vertex> {
        val vertexes = mutableListOf<Vertex>()
        list.withIndex().forEach {
            val list = Array(incidentMatrix.adjancencyMatrix.size) { 0 }
            vertexes.add(Vertex(it.value + lastLevelSise, it.index + count, list))
        }
        return vertexes.toTypedArray()
    }

    private fun countVertexesOnLevels(levelList: MutableList<MutableList<Vertex>>): Int {
        var count = 0
        levelList.forEach {
            count += it.size
        }
        return count
    }
}