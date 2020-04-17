package com.example.tryandroid.ui.fragments;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.FragmentAnimBinding;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimFragment extends DaggerFragment implements View.OnClickListener {

    public AnimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAnimBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anim, container, false);

        binding.fade.setOnClickListener(this);
        binding.scale.setOnClickListener(this);
        binding.translate.setOnClickListener(this);
        binding.rotate.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fade:
                ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(getContext(), R.animator.fade);
                animator.setTarget(R.id.image);
                animator.start();
                break;
            case R.id.scale:
                ObjectAnimator animatorScale = (ObjectAnimator) AnimatorInflater.loadAnimator(getContext(), R.animator.scale);
                animatorScale.setTarget(R.id.image);
                animatorScale.start();
        }

    }
}
