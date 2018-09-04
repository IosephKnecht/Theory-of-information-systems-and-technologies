package model

import interactor.generateIntValue
import java.util.*

class GeneralWarehouse(val name: String = "General Warehouse",
                            val id: UUID = UUID.randomUUID()) : EventHandler {
    override fun executeEvent() {

    }
}