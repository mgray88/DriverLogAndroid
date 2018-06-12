package digital.is.mike.driverlog.screens.month.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import digital.is.mike.driverlog.screens.common.controllers.BaseFragment;
import digital.is.mike.driverlog.screens.month.mvcviews.MonthViewMvc;
import digital.is.mike.driverlog.screens.month.mvcviews.MonthViewMvcImpl;

public class MonthFragment extends BaseFragment {

    private MonthViewMvc mMonthViewMvc;

    @Nullable
    @Override
    public View onCreateView ( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {

        mMonthViewMvc = new MonthViewMvcImpl(inflater, container);

        return mMonthViewMvc.getRootView();
    }
}
