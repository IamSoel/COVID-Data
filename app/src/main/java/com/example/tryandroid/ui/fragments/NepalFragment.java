package com.example.tryandroid.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.FragmentNepalBinding;
import com.example.tryandroid.viewmodel.NepalViewModel;
import com.example.tryandroid.viewmodel.util.ViewModelFactory;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NepalFragment extends DaggerFragment {

    @Inject
    ViewModelFactory factory;

    public NepalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentNepalBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nepal, container, false);
        NepalViewModel nepalViewModel = new ViewModelProvider(this, factory).get(NepalViewModel.class);
        binding.setNepal(nepalViewModel);


        nepalViewModel.getData().observe(this, nepalData -> {
            binding.testedPositive.setText(nepalData.getTestedPositive());
            binding.testedNegative.setText(nepalData.getTestedNegative());
            binding.testedTotal.setText(nepalData.getTestedTotal());

            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(Integer.parseInt(nepalData.getTestedPositive()), "Tested Positive"));
            entries.add(new PieEntry(Integer.parseInt(nepalData.getTestedNegative()), "Tested Negative"));
            entries.add(new PieEntry(Integer.parseInt(nepalData.getTestedTotal()), "Total Tested Case"));

            PieDataSet nepalDataSet = new PieDataSet(entries, "Corona Data of Nepal");
            nepalDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

            PieData nepalPieData = new PieData(nepalDataSet);
            binding.pieChart.setData(nepalPieData);
            binding.pieChart.animateXY(1000, 1000);

            binding.pieChart.setDrawEntryLabels(false);
            binding.pieChart.getDescription().setEnabled(false);

            Legend legend = binding.pieChart.getLegend();
             legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
            legend.setOrientation(Legend.LegendOrientation.VERTICAL);
            legend.setDrawInside(false);

        });
        return binding.getRoot();

    }
}
