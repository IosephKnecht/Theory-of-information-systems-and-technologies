package domain

import data.IncidenceMatrixes
import data.Vertex

object AdjacencyInteractor {
    private lateinit var levelList: Array<Array<Vertex>>

    fun execute(incidenceMatrixes: IncidenceMatrixes,
                levelList: Array<Array<Vertex>>): Array<Array<Vertex>> {
        this.levelList = levelList
        incidenceMatrixes.adjancencyMatrix.withIndex().forEach {
            val strNum = it.index
            it.value.withIndex().forEach {
                if (it.value != 0) findVertex(strNum)?.str!![findVertex(it.index)?.newPosition!!] = 1
            }
        }
        return levelList
    }

    private fun findVertex(position: Int): Vertex? {
        levelList.forEach {
            it.withIndex().forEach {
                if (it.value.oldPosition == position) return it.value
            }
        }
        return null
    }
}