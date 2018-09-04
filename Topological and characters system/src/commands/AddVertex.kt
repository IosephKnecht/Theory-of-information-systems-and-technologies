package commands

class AddVertex(private val receiver: Receiver) : ICommand {
    override fun execute() {
        receiver.addVertex()
    }

    override fun revert() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}