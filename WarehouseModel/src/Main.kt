import interactor.EpochInteractor

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            EpochInteractor.instance(400).execute()
        }
    }
}