package model

import interactor.EpochInteractor
import interactor.generateIntValue
import model.events.KitRequest
import model.events.KitResponse
import java.util.*

class Station(val name: String = "Station",
              val id: UUID = UUID.randomUUID()) : EventHandler {
    override fun executeEvent() {
       // EpochInteractor.instance(0).addNotExecutedEvent(KitResponse())
    }

    fun generateEvent(currentEpoch: Int): Event {
        return KitRequest(currentEpoch, generateIntValue(50, 70))
    }
}