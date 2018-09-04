import data.IncidenceMatrixes
import domain.*

object AlgorithmPresenter {
    fun calculCharactersGraph(adjacencyMatrix: Array<Array<Int>>) {
        val incidenceMatrixes = IncidenceMatrixes(adjacencyMatrix)
        val levelList = LevelInteractor.execute(incidenceMatrixes)
        val newLevelList = AdjacencyInteractor.execute(incidenceMatrixes, levelList)

        val newAdjacencyMatrix = mutableListOf<Array<Int>>()

        newLevelList.forEach {
            it.forEach {
                newAdjacencyMatrix.add(it.str)
            }
        }

        val multiplyMatrixes = MultiplyInteractor.execute(newAdjacencyMatrix.toTypedArray())
        val elementsOrder = ElementOrderInteractor.execute(multiplyMatrixes)
        val characters = ClockCharacterInteractor.execute(newAdjacencyMatrix.toTypedArray(), elementsOrder)

        newLevelList.withIndex().forEach {
            println("Level#${it.index}")
            it.value.forEach {
                println(it.str.joinToString())
            }
        }

        printResult(elementsOrder) {
            println("Order  element#${it.index} = ${it.value}")
        }

        printResult(characters.unusableClockDocs) {
            println("Document #${it.index} unused of clock = ${it.value}")
        }

        printResult(characters.usableClockDocs) {
            println("Document #${it.index} use of clock = ${it.value}")
        }
    }

    private fun <T> printResult(mass: Array<T>, block: (IndexedValue<T>) -> Unit) {
        mass.withIndex().forEach {
            block(it)
        }
    }
}