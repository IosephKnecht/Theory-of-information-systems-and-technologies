package data

enum class Graph(val matrix: Array<Array<Int>>) {
    graphA(arrayOf(
            arrayOf(0, 1, 1, 1, 0, 0),
            arrayOf(0, 0, 0, 1, 0, 0),
            arrayOf(0, 0, 0, 0, 1, 1),
            arrayOf(0, 0, 0, 0, 0, 1),
            arrayOf(0, 0, 0, 1, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0)
    )),
    graphB(arrayOf(
            arrayOf(0, 1, 0, 0, 0, 0, 1, 0, 0, 0),
            arrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 0, 1, 0, 1, 1, 1, 0)
    )),
    testMultiply(arrayOf(
            arrayOf(0,1,1,1,0,0,0),
            arrayOf(0,0,0,0,1,0,0),
            arrayOf(0,0,0,1,0,1,1),
            arrayOf(0,0,0,0,1,0,1),
            arrayOf(0,0,0,0,0,1,0),
            arrayOf(0,0,0,0,0,0,0),
            arrayOf(0,0,0,0,0,0,0)
    )),
    testMatrix(arrayOf(

            arrayOf(0,1,0,0,0,0,0,0,0,0,0),
            arrayOf(0,0,0,0,0,0,0,0,0,0,0),
            arrayOf(0,1,0,0,0,0,0,0,0,0,0),
            arrayOf(0,0,1,0,0,0,0,0,0,0,0),
            arrayOf(0,0,0,1,0,0,0,0,0,0,0),
            arrayOf(0,0,1,0,1,0,0,0,0,0,0),
            arrayOf(0,1,0,1,0,0,0,0,0,0,0),
            arrayOf(0,0,0,0,0,0,1,0,0,0,0),
            arrayOf(0,0,0,0,0,0,0,0,0,0,1),
            arrayOf(0,0,0,0,0,0,1,0,0,0,0),
            arrayOf(1,0,0,0,0,0,0,0,0,1,0)
    ))
}