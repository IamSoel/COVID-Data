package com.example.tryandroid.di.modules;

import com.example.tryandroid.ui.fragments.HospitalFragment;
import com.example.tryandroid.ui.fragments.NepalFragment;
import com.example.tryandroid.ui.fragments.WorldFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract NepalFragment contributesNepalFragment();

    @ContributesAndroidInjector
    abstract WorldFragment contributesWorldFragment();

    @ContributesAndroidInjector
    abstract HospitalFragment contributesHospitalFragment();
}
