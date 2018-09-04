package interactor

import java.util.*

fun generateIntValue(min: Int, max: Int): Int {
    val r = Random()
    val randomValue = min + (max - min) * r.nextDouble()
    return randomValue.toInt()
}