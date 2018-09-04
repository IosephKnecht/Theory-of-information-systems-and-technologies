package helper

import interactors.*

class Holder(val mass: Array<Array<Int>>?) {

    override fun toString(): String {
        if (mass != null) {
            val warshallAlgorithm = WarshallAlgorithm(mass)

            val r = StructuralRedundancy(mass)
            val sigma2 = CoefficientOfUniformity(mass)
            val q = StructuralCompactness(warshallAlgorithm)
            val center = CenterAlgorithm(warshallAlgorithm.execute())

            return "$r\n" +
                    "$sigma2\n" +
                    "Compactness = ${q.execute()}\n" +
                    "Diametr of graph = ${getDiametr(warshallAlgorithm.execute())}\n" +
                    "Center = ${center.execute()}"
        }
        return "Please,add matrix..."
    }

    private fun getDiametr(mass: Array<Array<Int>>): Int? {
        val hashList = mutableListOf<Int?>()
        mass.forEach {
            hashList.add(it.max())
        }
        return (hashList as List<Int>).max()
    }
}