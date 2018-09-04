package model

interface Event {
    var currentEpoch: Int
    var value: Int

    fun execute(executeEpoch: Int)
}