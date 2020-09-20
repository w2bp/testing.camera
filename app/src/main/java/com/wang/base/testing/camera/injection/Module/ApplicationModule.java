package com.wang.base.testing.camera.injection.Module;

import android.app.Application;
import android.content.Context;

import com.wang.base.testing.camera.data.local.PreferenceHelper;
import com.wang.base.testing.camera.data.local.RealmHelper;
import com.wang.base.testing.camera.data.remote.RetrofitService;
import com.wang.base.testing.camera.injection.ApplicationContext;
import com.wang.base.testing.camera.utils.AppUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    RetrofitService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitInstance(RealmHelper realmHelper, PreferenceHelper preferenceHelper) {
        return RetrofitService.Creator.newRetrofitInstance(mApplication.getApplicationContext(),
                AppUtils.isConnectivityAvailable(mApplication.getApplicationContext()), realmHelper,
                preferenceHelper);
    }
}
