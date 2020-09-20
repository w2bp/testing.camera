package com.wang.base.testing.camera.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.wang.base.testing.camera.WangApplication;
import com.wang.base.testing.camera.injection.Component.ActivityComponent;
import com.wang.base.testing.camera.injection.Component.DaggerActivityComponent;
import com.wang.base.testing.camera.injection.Module.ActivityModule;

public class BaseFragment extends Fragment {
    protected FragmentActivity activity;
    ActivityComponent mActivityComponent;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(WangApplication.get(getActivity()).getComponent())
                    .activityModule(new ActivityModule(getActivity()))
                    .build();
        }
        return mActivityComponent;
    }
}
