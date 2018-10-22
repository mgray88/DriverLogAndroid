package com.prolificinteractive.materialcalendarview;

import android.content.Context;

import java.util.Calendar;

/**
 * Display the week number similarly to {@linkplain DayView}
 */
@Experimental
class WeekNumberView extends DayView {

    private int weekNumber;

    /**
     *
     * @param context
     * @param day       first day of the week
     */
    public WeekNumberView ( Context context, CalendarDay day ) {
        super(context);

        this.date = day;
        setWeekNumber(day);
    }

    public void setWeekNumber(CalendarDay day) {
        this.weekNumber = day.getCalendar().get(Calendar.WEEK_OF_YEAR);
        setText(Integer.toString(this.weekNumber));
    }

    public int getWeekNumber() {
        return weekNumber;
    }
}
