package model.events

import interactor.EpochInteractor
import model.Complect
import model.Event

class ResponseRestoreKits(override var currentEpoch: Int, override var value: Int) : Event {
    override fun execute(executeEpoch: Int) {
        val warehouse = EpochInteractor.instance(0).workWarehouse
        val size = 20 - warehouse.complects.size
        for (i in 0..(size - 1)) {
            warehouse.complects.add(Complect())
        }
    }
}