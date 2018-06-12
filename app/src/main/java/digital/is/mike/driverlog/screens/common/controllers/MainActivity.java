package digital.is.mike.driverlog.screens.common.controllers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import digital.is.mike.driverlog.R;
import digital.is.mike.driverlog.screens.common.mvcviews.RootViewMvcImpl;
import digital.is.mike.driverlog.screens.month.controllers.MonthFragment;
import digital.is.mike.driverlog.screens.month.mvcviews.MonthViewMvcImpl;

public class MainActivity extends Activity implements BaseFragment.AbstractFragmentCallback {

    RootViewMvcImpl mViewMVC;

    @Override
    protected void onCreate ( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        /**
         * The MVC view associated with this activity is very simple, therefore the below lines
         * could be replaced with:

         setContentView(R.layout.mvc_view_frame_layout);

         * and there would be no need for RootViewMvcImpl class.
         * However, for the sake of consistency, we should try to stick to a single coding style,
         * therefore we employ full MVC approach even in this simple case
         */

        // Instantiate MVC view associated with this activity
        mViewMVC = new RootViewMvcImpl(this, null);

        // set the root view of the associated MVC view as the content of this activity
        setContentView(mViewMVC.getRootView());

        // show the default fragment if the application is not restored
        if (savedInstanceState == null) {
            // TODO: put default class instantiation here
            replaceFragment(MonthFragment.class, false, null);
        }
    }

    // ---------------------------------------------------------------------------------------------
    //region Fragments Management

    @Override
    public void replaceFragment ( Class<? extends Fragment> claz, boolean addToBackStack, Bundle args ) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        Fragment newFragment;

        try {
            // Create new fragment
            newFragment = claz.newInstance();
            if (args != null) newFragment.setArguments(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        if (addToBackStack) {
            // Add this transaction to the back stack
            ft.addToBackStack(null);
        }

        // Change to a new fragment
        ft.replace(R.id.frame_contents, newFragment, claz.getClass().getSimpleName());
        ft.commit();
    }

    //endregion
    // ---------------------------------------------------------------------------------------------
}
