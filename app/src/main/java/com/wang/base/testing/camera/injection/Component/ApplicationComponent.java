package com.wang.base.testing.camera.injection.Component;

import android.app.Application;
import android.content.Context;

import com.wang.base.testing.camera.injection.ApplicationContext;
import com.wang.base.testing.camera.injection.Module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();
}
