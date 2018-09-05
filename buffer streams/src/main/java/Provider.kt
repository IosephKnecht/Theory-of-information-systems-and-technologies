import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

object Provider {

    private var timeUnit = TimeUnit.SECONDS

    val generator = Observable.defer {
        Observable.interval(generateLong(3, 9), timeUnit)
                .flatMap { if (Resource.checkThreadSpeed()) Observable.just(5L) else Observable.just(4L) }
                .flatMap {
                    val delay = it
                    Observable.just(System.currentTimeMillis())
                            .delay(delay, timeUnit)
                            .flatMap {
                                Observable.just(it).delay(delay, timeUnit)
                                        .flatMap { Observable.just(Packet(it, System.currentTimeMillis())) }
                            }
                }
                .subscribeOn(Schedulers.io())

    }

    private fun generateLong(min: Int, max: Int): Long {
        return (Random().nextInt((max - min) + 1) + min).toLong()
    }
}