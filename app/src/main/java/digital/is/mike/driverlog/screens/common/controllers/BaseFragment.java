package digital.is.mike.driverlog.screens.common.controllers;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

public abstract class BaseFragment extends Fragment {

    private AbstractFragmentCallback mCallback;

    @Override
    public void onAttach ( Activity activity ) {
        super.onAttach(activity);

        try {
            mCallback = (AbstractFragmentCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                " must implement " + AbstractFragmentCallback.class.getCanonicalName());
        }
    }

    public void replaceFragment(Class<? extends Fragment> claz, boolean addToBackStack, Bundle args) {
        mCallback.replaceFragment(claz, addToBackStack, args);
    }

    public interface AbstractFragmentCallback {
        void replaceFragment ( Class<? extends Fragment> claz, boolean addToBackStack, Bundle args );
    }
}
