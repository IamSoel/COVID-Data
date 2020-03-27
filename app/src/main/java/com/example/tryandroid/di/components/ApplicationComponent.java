package com.example.tryandroid.di.components;

import android.app.Application;

import com.example.tryandroid.BaseApplication;
import com.example.tryandroid.di.modules.ActivityBindingModule;
import com.example.tryandroid.di.modules.ApplicationModule;
import com.example.tryandroid.di.modules.ContextModule;
import com.example.tryandroid.di.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {ApplicationModule.class, ContextModule.class, AndroidSupportInjectionModule.class, ViewModelModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication baseApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}

