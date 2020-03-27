package com.example.tryandroid;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.tryandroid.databinding.ActivityMainBinding;
import com.example.tryandroid.viewmodel.MainViewModel;
import com.example.tryandroid.viewmodel.util.ViewModelFactory;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject
    ViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);
        binding.setMain(mainViewModel);

        mainViewModel.getNepalData().observe(this, nepalData -> {
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
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            legend.setOrientation(Legend.LegendOrientation.VERTICAL);
            legend.setDrawInside(false);

        });
    }
}
