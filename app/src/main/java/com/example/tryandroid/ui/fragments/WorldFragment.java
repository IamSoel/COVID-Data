package com.example.tryandroid.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.FragmentWorldBinding;
import com.example.tryandroid.viewmodel.WorldViewModel;
import com.example.tryandroid.viewmodel.util.ViewModelFactory;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorldFragment extends DaggerFragment {

    BarDataSet barDataSet;

    String[] cases = new String[]{"Total Cases", "Active Cases", "Critical Cases", "New Cases", "Total Deaths", "New Deaths"};

    @Inject
    ViewModelFactory factory;


    public WorldFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentWorldBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_world, container, false);
        WorldViewModel worldViewModel = new ViewModelProvider(this, factory).get(WorldViewModel.class);
        binding.setWorld(worldViewModel);


        worldViewModel.getData().observe(getViewLifecycleOwner(), data -> {
            ArrayList<BarEntry>[] entries = new ArrayList[data.size()];


            for (int i = 0; i < data.size(); i++) {
                entries[i] = new ArrayList<>();

            }

            for (int i = 0; i < data.size(); i++) {

                int j = 1;
                entries[i].add(new BarEntry(j, data.get(i).getTotalCases()));
                ++j;
                entries[i].add(new BarEntry(j, data.get(i).getActiveCases()));
                ++j;
                entries[i].add(new BarEntry(j, data.get(i).getCriticalCases()));
                ++j;
                entries[i].add(new BarEntry(j, data.get(i).getNewCases()));
                ++j;
                entries[i].add(new BarEntry(j, data.get(i).getTotalDeaths()));
                ++j;
                entries[i].add(new BarEntry(j, data.get(i).getNewDeaths()));

                barDataSet = new BarDataSet(entries[i], data.get(i).getCountry());
                barDataSet.setColors(ColorTemplate.PASTEL_COLORS);

            }

            BarData barData = new BarData(barDataSet);
            XAxis xAxis = binding.barGraph.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(cases));
            binding.barGraph.setFitBars(true);
            binding.barGraph.setData(barData);


            binding.barGraph.animateXY(2000, 2000);
            binding.barGraph.invalidate();

        });


        return binding.getRoot();
    }
}
