package com.wang.base.testing.camera.injection.Component;

import com.wang.base.testing.camera.MainActivity;
import com.wang.base.testing.camera.injection.Module.ActivityModule;
import com.wang.base.testing.camera.injection.PerActivity;
import com.wang.base.testing.camera.ui.dashboard.DashboardFragment;
import com.wang.base.testing.camera.ui.home.HomeFragment;
import com.wang.base.testing.camera.ui.notifications.NotificationsFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(HomeFragment homeFragment);

    void inject(DashboardFragment dashboardFragment);

    void inject(NotificationsFragment notificationsFragment);
}
