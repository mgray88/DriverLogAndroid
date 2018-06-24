package com.prolificinteractive.materialcalendarview;

@Experimental
public class SingleDayPagerAdapter extends CalendarPagerAdapter<SingleDayView> {
    SingleDayPagerAdapter ( MaterialCalendarView mcv ) {
        super(mcv);
    }

    @Override
    protected SingleDayView createView ( int position ) {
        return null;
    }

    @Override
    protected int indexOf ( SingleDayView view ) {
        return 0;
    }

    @Override
    protected boolean isInstanceOfView ( Object object ) {
        return false;
    }

    @Override
    protected DateRangeIndex createRangeIndex ( CalendarDay min, CalendarDay max ) {
        return null;
    }
}
