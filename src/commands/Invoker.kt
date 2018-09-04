package commands

class Invoker(val receiver: Receiver) {
    var command: String? = null

    fun run() {
        if (command == "tcs calcul") {
            Calcul(receiver).execute()
            return
        }
        if (command == "tcs status") {
            receiver.matrix?.forEach { println(it.arrayToString()) }
            return
        }
        var currentCommand: ICommand? = null
        val regex = Regex("""tcs (vertex|matrix) (add|remove) ([1-9]+)""", RegexOption.IGNORE_CASE)
        val regexList = regex.matchEntire(command!!)?.groupValues
        when (regexList?.get(1)) {
            "vertex" -> {
                when (regexList[2]) {
                    "add" -> currentCommand = AddVertex(receiver)
                    "remove" -> currentCommand = DeleteVertex(receiver,regexList[3]?.toInt())
                }
            }
            "matrix" -> {
                when (regexList[2]) {
                    "add" -> currentCommand = AddMatrix(receiver, regexList[regexList.size - 1].toInt())
                    "remove" -> {
                    }
                }
            }
        }
        if (currentCommand != null) currentCommand.execute()
        else println("Unsupported command")
    }
}

fun Array<Int>.arrayToString(): String {
    var str = ""
    this.forEach { str += " " + it }
    return str
}