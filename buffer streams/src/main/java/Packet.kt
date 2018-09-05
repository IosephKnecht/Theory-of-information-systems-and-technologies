class Packet(val start: Long, val stop: Long) {
    override fun toString(): String {
        return (stop - start).toString()
    }

    fun isValid(): Boolean {
        return stop - start <= 10_000
    }
}