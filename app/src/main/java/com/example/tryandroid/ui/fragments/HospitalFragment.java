package com.example.tryandroid.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.FragmentHospitalBinding;
import com.example.tryandroid.viewmodel.HospitalViewModel;
import com.example.tryandroid.viewmodel.util.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalFragment extends DaggerFragment {

    @Inject
    ViewModelFactory factory;

    public HospitalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentHospitalBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hospital, container, false);
        HospitalViewModel hospitalViewModel = new ViewModelProvider(this, factory).get(HospitalViewModel.class);
        binding.setHospital(hospitalViewModel);

        hospitalViewModel.getData().observe(this,data->{

        });


        return binding.getRoot();
    }
}
