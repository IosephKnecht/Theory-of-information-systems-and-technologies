package model.events

import interactor.EpochInteractor
import interactor.generateIntValue
import model.Event

class RequestRestoreKits(override var currentEpoch: Int, override var value: Int) : Event {
    override fun execute(executeEpoch: Int) {
        EpochInteractor.instance(0).addNotExecutedEvent(DelayRestoreKits(executeEpoch, generateIntValue(40, 80)))
    }
}