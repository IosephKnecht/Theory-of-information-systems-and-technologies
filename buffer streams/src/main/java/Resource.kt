object Resource {
    var invalidPackets = 0
    var validPackets = 0

    var enabledResource = 0
        private set

    fun checkThreadSpeed(): Boolean {
        if (invalidPackets > 0 && validPackets == 0) {
            enabledResource++
            return false
        }

        if (invalidPackets == 0 && validPackets == 0) return true

        return if (invalidPackets.toDouble() / (invalidPackets + validPackets) * 100 < 30) {
            true
        } else {
            enabledResource++
            false
        }
    }
}