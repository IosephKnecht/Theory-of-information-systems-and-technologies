package model

import interactor.generateIntValue
import java.util.*


class WorkWarehouse(val name: String = "Work Warehouse",
                    val id: UUID = UUID.randomUUID(),
                    val complects: MutableList<Complect> = MutableList(20) { Complect() }) : EventHandler {
    override fun executeEvent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}