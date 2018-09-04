package model.events

import interactor.EpochInteractor
import interactor.generateIntValue
import model.Event

class KitResponse(override var currentEpoch: Int, override var value: Int) : Event {
    override fun execute(executeEpoch: Int) {
        val interactor = EpochInteractor.instance(0)
        val size = interactor.workWarehouse.complects.size
        if (size != 0) interactor.workWarehouse.complects.removeAt(size - 1)
        if (interactor.workWarehouse.complects.size <= 3)
            interactor.addNotExecutedEvent(RequestRestoreKits(executeEpoch, 60))
    }

}