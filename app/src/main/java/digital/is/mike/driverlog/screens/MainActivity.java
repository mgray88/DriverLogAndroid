package digital.is.mike.driverlog.screens;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import digital.is.mike.driverlog.R;

public class MainActivity extends AppCompatActivity {

    private static final CalendarDay TODAY = CalendarDay.today();

    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_view);
        calendarView = findViewById(R.id.calendarView);
        calendarView.state().edit()
                .setMaximumDate(CalendarDay.today())
                //.setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit();
        //cv.setTopbarVisible(false);
        calendarView.addDecorators(
                currentDateDecorator,
                disableFutureDatesDecorator);
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
            view.addSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)));
        }
    };

    /**
     * Calendar decorator which disables future dates,
     * since we shouldn't have data, or be able to enter it yet
     */
    DayViewDecorator disableFutureDatesDecorator = new DayViewDecorator() {
        @Override
        public boolean shouldDecorate ( CalendarDay day ) {
            if (day.isAfter(TODAY)) return true;
            else return false;
        }

        @Override
        public void decorate ( DayViewFacade view ) {
            //view.addSpan(new ForegroundColorSpan(Color.GRAY));
            view.setDaysDisabled(true);
        }
    };
}
