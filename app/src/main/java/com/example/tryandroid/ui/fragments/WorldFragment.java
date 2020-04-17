package com.example.tryandroid.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.FragmentWorldBinding;
import com.example.tryandroid.viewmodel.WorldViewModel;
import com.example.tryandroid.viewmodel.util.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorldFragment extends DaggerFragment {

    @Inject
    ViewModelFactory factory;

    private WorldViewModel worldViewModel;

    public WorldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentWorldBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_world, container, false);
        worldViewModel = new ViewModelProvider(this, factory).get(WorldViewModel.class);
        binding.setWorld(worldViewModel);


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        worldViewModel.getData().observe(getViewLifecycleOwner(), data -> {

            worldViewModel.setRecyclerAdapter(data);

        });
    }
}
