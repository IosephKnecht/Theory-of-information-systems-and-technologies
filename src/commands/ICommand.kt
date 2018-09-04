package commands

interface ICommand {
    fun execute()
    fun revert()
}