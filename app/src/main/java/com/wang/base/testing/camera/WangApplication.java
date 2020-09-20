package com.wang.base.testing.camera;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDexApplication;

import com.wang.base.testing.camera.injection.Component.ApplicationComponent;
import com.wang.base.testing.camera.injection.Component.DaggerApplicationComponent;
import com.wang.base.testing.camera.injection.Module.ApplicationModule;

public class WangApplication extends MultiDexApplication {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private ApplicationComponent mApplicationComponent;

    public static WangApplication get(Context context) {
        return (WangApplication) context.getApplicationContext();
    }

    public synchronized ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }
}
