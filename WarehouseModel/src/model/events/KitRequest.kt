package model.events

import interactor.EpochInteractor
import interactor.generateIntValue
import model.Event

class KitRequest(override var currentEpoch: Int, override var value: Int) : Event {
    override fun execute(executeEpoch: Int) {
        EpochInteractor.instance(0).addNotExecutedEvent(KitResponse(executeEpoch, generateIntValue(50, 55)))
    }
}