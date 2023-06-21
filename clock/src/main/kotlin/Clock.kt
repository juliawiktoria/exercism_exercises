class Clock(hh: Int, mm: Int) {
    private var hh = 0
    private var mm = 0
    init {
        setup(hh, mm)
    }
    fun subtract(minutes: Int) {
        add(-minutes)
    }
    fun add(minutes: Int) {
        setup(hh, mm + minutes)
    }
    private fun setup(hh: Int, mm: Int) {
        this.hh = ((hh + mm / 60) % 24)
            .let { (if (mm % 60 < 0) it - 1 else it) }
            .let { if (it < 0) it + 24 else it }
        this.mm = (mm % 60)
            .let { if (it < 0) it + 60 else it }
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is Clock) return hh == other.hh && mm == other.mm
        return false
    }

    override fun toString(): String = "%02d:%02d".format(hh, mm)
}