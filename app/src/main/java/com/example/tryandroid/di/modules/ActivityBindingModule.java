package com.example.tryandroid.di.modules;

import com.example.tryandroid.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {


    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributesMainActivity();


}
