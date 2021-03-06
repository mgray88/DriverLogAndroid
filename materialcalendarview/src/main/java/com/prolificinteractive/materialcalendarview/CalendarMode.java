package com.prolificinteractive.materialcalendarview;

@Experimental
public enum CalendarMode {

    MONTHS(6),
    WEEKS(1),
    SINGLEDAY(0);

    final int visibleWeeksCount;

    CalendarMode(int visibleWeeksCount) {
        this.visibleWeeksCount = visibleWeeksCount;
    }
}
