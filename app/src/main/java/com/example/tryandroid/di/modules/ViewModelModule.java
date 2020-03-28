package com.example.tryandroid.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.tryandroid.viewmodel.HospitalViewModel;
import com.example.tryandroid.viewmodel.NepalViewModel;
import com.example.tryandroid.viewmodel.WorldViewModel;
import com.example.tryandroid.viewmodel.util.ViewModelFactory;
import com.example.tryandroid.viewmodel.util.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(NepalViewModel.class)
    abstract ViewModel bindNepalViewModel(NepalViewModel nepalViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(WorldViewModel.class)
    abstract ViewModel bindWorldViewModel(WorldViewModel worldViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(HospitalViewModel.class)
    abstract ViewModel bindHospitalViewModel(HospitalViewModel hospitalViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


}
