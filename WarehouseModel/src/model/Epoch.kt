package model

class Epoch(var number: Int, val valueEpoch: Int) {

    fun isEventEpoch(event: Event): Boolean {
        return number * valueEpoch > event.currentEpoch * event.value
    }
}