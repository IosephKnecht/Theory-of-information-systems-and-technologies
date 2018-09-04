package model.events

import interactor.EpochInteractor
import interactor.generateIntValue
import model.Event

class DelayRestoreKits(override var currentEpoch: Int, override var value: Int) : Event {
    override fun execute(executeEpoch: Int) {
        EpochInteractor.instance(0).addNotExecutedEvent(ResponseRestoreKits(executeEpoch, generateIntValue(55, 65)))
    }
}