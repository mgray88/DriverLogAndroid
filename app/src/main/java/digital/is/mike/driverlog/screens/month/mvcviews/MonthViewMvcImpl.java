package digital.is.mike.driverlog.screens.month.mvcviews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import digital.is.mike.driverlog.R;

public class MonthViewMvcImpl implements MonthViewMvc {

    private View mRootView;

    public MonthViewMvcImpl( LayoutInflater inflater, ViewGroup container ) {
        mRootView = inflater.inflate(R.layout.calendar_view, container, false);


    }

    @Override
    public View getRootView () {
        return mRootView;
    }

    @Override
    public Bundle getViewState () {
        return null;
    }
}
