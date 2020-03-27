package com.example.tryandroid.di.modules;

import com.example.tryandroid.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {


    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();


}
