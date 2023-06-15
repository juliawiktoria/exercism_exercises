import java.time.DayOfWeek
import java.time.LocalDate
class Meetup(val month: Int, val year: Int) {
    fun day(dow: DayOfWeek, sched: MeetupSchedule): LocalDate =
        daysInMonth.filter { it.dayOfWeek == dow }.let { days ->
            when(sched) {
                MeetupSchedule.FIRST -> days.first()
                MeetupSchedule.LAST -> days.last()
                MeetupSchedule.SECOND -> days.drop(1).first()
                MeetupSchedule.THIRD -> days.drop(2).first()
                MeetupSchedule.FOURTH -> days.drop(3).first()
                MeetupSchedule.TEENTH -> days.find { it.dayOfMonth > 12 }!!
            }
        }
    val daysInMonth = generateSequence(LocalDate.of(year, month, 1)) {
        it.plusDays(1).let { day -> if (day.month.value != month) null else day }
    }
}