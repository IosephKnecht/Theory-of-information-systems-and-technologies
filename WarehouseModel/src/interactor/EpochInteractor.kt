package interactor

import model.*
import java.util.*

class EpochInteractor private constructor(val valueEpochs: Int) {

    private val epoch = Epoch(1, 60)
    private val notExecutedEvents: MutableList<Event> = mutableListOf()

    val workWarehouse = WorkWarehouse()
    val station = Station()
    val generalWarehouse = GeneralWarehouse()

    companion object {
        private var singleton: EpochInteractor? = null

        fun instance(valueEpochs: Int): EpochInteractor {
            if (singleton == null) {
                singleton = EpochInteractor(valueEpochs)
                return singleton!!
            } else {
                return singleton!!
            }
        }
    }

    fun execute() {
        for (i in 0..valueEpochs) {
            val currentEvents = mutableListOf<Event>()
            currentEvents.add(station.generateEvent(epoch.number))
            if (notExecutedEvents.isNotEmpty()) validateNotExecutedEvent()
            validateEvent(currentEvents)
            epoch.number++
            println("${workWarehouse.complects.size} ${currentEvents.last().value}")
            //Thread.sleep(5000)
        }
    }

    fun addNotExecutedEvent(event: Event) {
        notExecutedEvents.add(event)
    }

    private fun validateNotExecutedEvent() {
        var i = 0
        val list = notExecutedEvents
        var size = list.size
        list.reverse()
        while (i < size) {
            if (epoch.isEventEpoch(list[i])) {
                list[i].execute(epoch.number)
                list.remove(list[i])
                if (i > 0) i--
                size--
            } else {
                i++
            }
        }
    }

    private fun validateEvent(currentEvents: MutableList<Event>) {
        currentEvents.forEach {
            if (epoch.isEventEpoch(it)) {
                it.execute(epoch.number)
            } else {
                notExecutedEvents.add(it)
            }
        }
    }
}