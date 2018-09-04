import data.Graph
import data.IncidenceMatrixes
import domain.*

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AlgorithmPresenter.calculCharactersGraph(Graph.testMultiply.matrix)
        }
    }
}