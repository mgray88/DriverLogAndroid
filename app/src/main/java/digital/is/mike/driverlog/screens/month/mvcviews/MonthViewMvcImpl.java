package digital.is.mike.driverlog.screens.month.mvcviews;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnWeekSelectedListener;

import digital.is.mike.driverlog.R;

public class MonthViewMvcImpl implements MonthViewMvc {

    private static final CalendarDay TODAY = CalendarDay.today();

    private View mRootView;
    private Resources mResources;
    private MaterialCalendarView mCalendarView;

    public MonthViewMvcImpl( LayoutInflater inflater, ViewGroup container ) {
        mRootView = inflater.inflate(R.layout.calendar_view, container, false);
        mResources = container.getResources();

        mCalendarView = mRootView.findViewById(R.id.calendarView);
        mCalendarView.state().edit()
                .setMaximumDate(CalendarDay.today())
                //.setCalendarDisplayMode(CalendarMode.WEEKS)
                .setShowWeekNumbers(true)
                .commit();
        mCalendarView.addDecorators(
                currentDateDecorator);

//        mCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
//            @Override
//            public void onDateSelected ( @NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected ) {
//                if (selected) {
//                    switch (widget.getCalendarMode()) {
//                        case MONTHS:
//                            widget.state().edit()
//                                    .setCalendarDisplayMode(CalendarMode.WEEKS)
//                                    .commit();
//                            break;
//                        case WEEKS:
//                            widget.state().edit()
//                                    .setCalendarDisplayMode(CalendarMode.SINGLEDAY)
//                                    .commit();
//                            break;
//                    }
//                }
//            }
//        });
        mCalendarView.setOnWeekSelectedListener(new OnWeekSelectedListener() {
            @Override
            public void onWeekSelected ( @NonNull MaterialCalendarView widget, @NonNull CalendarDay date ) {
                widget.selectRange(date, CalendarDay.from(date.getYear(), date.getMonth(), date.getDay()+6));
            }
        });
    }

    @Override
    public View getRootView () {
        return mRootView;
    }

    @Override
    public Bundle getViewState () {
        return null;
    }

    /**
     * Calendar decorator which highlights the current day
     */
    DayViewDecorator currentDateDecorator = new DayViewDecorator() {
        @Override
        public boolean shouldDecorate ( CalendarDay day ) {
            if (day.equals(TODAY)) return true;
            else return false;
        }

        @Override
        public void decorate ( DayViewFacade view ) {
            view.addSpan(new StyleSpan(Typeface.BOLD));
            view.addSpan(new RelativeSizeSpan(1.5f));
            view.addSpan(new ForegroundColorSpan(mResources.getColor(R.color.colorAccent)));
        }
    };
}
