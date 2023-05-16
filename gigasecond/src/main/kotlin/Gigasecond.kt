import java.time.LocalDateTime
import java.time.LocalDate
import java.time.LocalTime

class Gigasecond(dateTime: LocalDateTime) {
    constructor(date: LocalDate) : this(date.atStartOfDay())

    val date: LocalDateTime = dateTime.plusSeconds(1000000000)

}
