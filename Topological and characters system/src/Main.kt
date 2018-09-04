import commands.Invoker
import commands.Receiver

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val receiver = Invoker(Receiver())
            var currentText: String? = ""
            while (currentText != "exit") {
                currentText = readLine()
                receiver.command = currentText
                receiver.run()
            }
        }
    }
}
