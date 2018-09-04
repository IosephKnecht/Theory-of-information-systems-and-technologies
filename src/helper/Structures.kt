package helper

enum class Structures(val mass: Array<Array<Int>>) {
    structureA(mass = arrayOf(
            arrayOf(0, 1, 0, 0, 0),
            arrayOf(1, 0, 1, 0, 0),
            arrayOf(0, 1, 0, 1, 0),
            arrayOf(0, 0, 1, 0, 1),
            arrayOf(0, 0, 0, 1, 0)
    )),
    structureB(mass = arrayOf(
            arrayOf(0, 1, 0, 1, 0),
            arrayOf(1, 0, 1, 0, 0),
            arrayOf(0, 1, 0, 0, 1),
            arrayOf(0, 0, 1, 0, 1),
            arrayOf(1, 0, 0, 1, 0)
    )),
    structureC(mass = arrayOf(
            arrayOf(0, 0, 0, 0, 1),
            arrayOf(0, 0, 0, 0, 1),
            arrayOf(0, 0, 0, 0, 1),
            arrayOf(0, 0, 0, 0, 1),
            arrayOf(1, 1, 1, 1, 0)
    )),
    structureD(mass = arrayOf(
    arrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1),
    arrayOf(1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0),
    arrayOf(0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0),
    arrayOf(0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0),
    arrayOf(0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0),
    arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
    arrayOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1),
    arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0)
    ))

}