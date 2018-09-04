package commands

class DeleteVertex(private val receiver: Receiver, val index: Int) : ICommand {
    override fun revert() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun execute() {
        receiver.removeVertex(index)
    }
}