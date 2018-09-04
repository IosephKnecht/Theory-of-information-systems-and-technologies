package commands

class AddMatrix(private val receiver: Receiver, val rank: Int) : ICommand {
    override fun execute() {
        receiver.addMatrix(rank)
    }

    override fun revert() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}