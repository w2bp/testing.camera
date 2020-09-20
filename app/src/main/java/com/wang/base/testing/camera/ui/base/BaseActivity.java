package com.wang.base.testing.camera.ui.base;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.wang.base.testing.camera.R;
import com.wang.base.testing.camera.WangApplication;
import com.wang.base.testing.camera.injection.Component.ActivityComponent;
import com.wang.base.testing.camera.injection.Component.DaggerActivityComponent;
import com.wang.base.testing.camera.injection.Module.ActivityModule;

public class BaseActivity extends AppCompatActivity {
    ActivityComponent mActivityComponent;

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(WangApplication.get(this).getComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }


    public void replaceFragment(Fragment fragment, int containerId) {
        replaceFragment(fragment, containerId, true);
    }

    public void replaceFragment(Fragment fragment, int containerId, boolean addToBackStack) {
        closeSoftKeyboard();
        if (fragment != null) {
            String backStateName = fragment.getClass().getName();
            boolean fragmentPopped;
            try {
                fragmentPopped = getSupportFragmentManager().popBackStackImmediate(backStateName, 0);
            } catch (IllegalStateException exception) {
                fragmentPopped = false;
            }

            if (!fragmentPopped) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_to_left, R.anim.slide_in_from_right, R.anim.slide_out_to_right);
                transaction.replace(containerId, fragment, fragment.getClass().getSimpleName());

                if (addToBackStack) {
                    transaction.addToBackStack(fragment.getClass().getSimpleName()).commitAllowingStateLoss();
                } else {
                    transaction.commitAllowingStateLoss();
                }
            }
        }
    }

    public void closeSoftKeyboard() {
        View focusedView = getCurrentFocus();
        if (focusedView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null)
                inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }
}
