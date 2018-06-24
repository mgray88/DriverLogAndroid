package com.prolificinteractive.materialcalendarview;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Collection;

@Experimental
public class SingleDayView extends CalendarPagerView {
    public SingleDayView ( @NonNull MaterialCalendarView view, CalendarDay firstViewDay, int firstDayOfWeek ) {
        super(view, firstViewDay, firstDayOfWeek, false);
    }

    @Override
    protected void buildDayViews ( Collection<DayView> dayViews, Calendar calendar ) { }

    @Override
    protected boolean isDayEnabled ( CalendarDay day ) {
        return false;
    }

    @Override
    protected int getRows () {
        return 0;
    }

    @Override
    protected int getCols () {
        return 0;
    }
}
