package commands

class Calcul(private val receiver: Receiver) : ICommand {
    override fun execute() {
        receiver.calcul()
    }

    override fun revert() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}