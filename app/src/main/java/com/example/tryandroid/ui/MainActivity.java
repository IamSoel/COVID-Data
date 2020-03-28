package com.example.tryandroid.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.ActivityMainBinding;
import com.example.tryandroid.ui.fragments.HospitalFragment;
import com.example.tryandroid.ui.fragments.NepalFragment;
import com.example.tryandroid.ui.fragments.WorldFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.bottomNavigation.setItemIconTintList(null);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.nepal:
                    binding.toolbar.setTitle("Nepal Corona Virus Data");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.displayFragment, new NepalFragment())
                            .commit();

                    break;
                case R.id.world:
                    binding.toolbar.setTitle("World Corona Virus Data");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.displayFragment, new WorldFragment())
                            .commit();
                    break;

                case R.id.hospital:
                    binding.toolbar.setTitle("Isolation Beds");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.displayFragment, new HospitalFragment())
                            .commit();
                    break;
                default:
                    break;
            }

            return false;
        });


    }
}
