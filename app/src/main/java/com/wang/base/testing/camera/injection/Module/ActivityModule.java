package com.wang.base.testing.camera.injection.Module;

import android.app.Activity;
import android.content.Context;

import com.wang.base.testing.camera.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideApplication() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeSubscription() {
        return new CompositeDisposable();
    }
}
