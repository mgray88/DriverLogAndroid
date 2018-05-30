package digital.is.mike.driverlog.common;

import android.arch.persistence.room.TypeConverter;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.time.LocalDate;

public class CalendarUtils {
    /**
     * {@link TypeConverter} for retrieving a {@link CalendarDay}
     * object stored in the database as a 'YYYY-MM-DD' date string
     * @param dateString
     * @return CalendarDay
     */
    @TypeConverter
    public static CalendarDay dateStringToCalendarDay( String dateString ) {
        return null;
    }

    /**
     * {@link TypeConverter} for storing a {@link CalendarDay}
     * object in the database.
     * @param day The {@link CalendarDay} object to store
     * @return The timestamp value for the database
     */
    @TypeConverter
    public static String calendarDayToDateString( CalendarDay day ) {
        return String.format("%1$Y-%2$m-%3$d", day.getYear(), day.getMonth(), day.getDay());
    }
}
