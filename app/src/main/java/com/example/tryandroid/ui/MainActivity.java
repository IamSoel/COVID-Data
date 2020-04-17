package com.example.tryandroid.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.ActivityMainBinding;
import com.example.tryandroid.ui.fragments.AnimFragment;
import com.example.tryandroid.ui.fragments.HospitalFragment;
import com.example.tryandroid.ui.fragments.NepalFragment;
import com.example.tryandroid.ui.fragments.WorldFragment;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.displayFragment, new NepalFragment()).commit();

        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.nepal:
                    binding.toolbar.setTitle("Nepal Corona Virus Data");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.displayFragment, new NepalFragment())
                            .commit();
                   return true;

                case R.id.world:
                    binding.toolbar.setTitle("World Corona Virus Data");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.displayFragment, new WorldFragment())
                            .commit();
                    return true;

                case R.id.hospital:
                    binding.toolbar.setTitle("Isolation Beds");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.displayFragment, new HospitalFragment())
                            .commit();
                    return true;
//                case R.id.anim:
//                    binding.toolbar.setTitle("Anim");
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.displayFragment, new AnimFragment())
//                            .commit();
//                    break;

                default:

                    break;
            }

            return false;
        });


    }
}
