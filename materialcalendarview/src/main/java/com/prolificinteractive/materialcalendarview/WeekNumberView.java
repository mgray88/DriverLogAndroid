package com.prolificinteractive.materialcalendarview;

import android.content.Context;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView.ShowOtherDates;

import java.util.Calendar;

@Experimental
class WeekNumberView extends DayView {

    private int weekNumber;

    private boolean isInRange = true;
    private boolean isInMonth = true;
    private boolean isDecoratedDisabled = false;
    @ShowOtherDates
    private int showOtherDates = MaterialCalendarView.SHOW_DEFAULTS;

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
