import io.reactivex.disposables.CompositeDisposable

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val compositeDisposable = CompositeDisposable()
            compositeDisposable.add(Provider.generator.subscribe {
                if (it.isValid()) Resource.validPackets++ else Resource.invalidPackets++
                println(it)
            })

            //Time experiment...
            Thread.sleep(5000000)

            compositeDisposable.clear()
            println(Resource.invalidPackets.toDouble() / (Resource.invalidPackets + Resource.validPackets) * 100)
            println(Resource.enabledResource.toDouble() / (Resource.validPackets + Resource.invalidPackets) * 100)
        }
    }
}