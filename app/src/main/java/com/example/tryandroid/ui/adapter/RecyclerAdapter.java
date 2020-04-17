package com.example.tryandroid.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tryandroid.R;
import com.example.tryandroid.databinding.RecyclerLayoutBinding;
import com.example.tryandroid.source.models.hospital.Data;
import com.example.tryandroid.viewmodel.HospitalViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<Data> hospitalDataModels = new ArrayList<>();
    private HospitalViewModel hospitalViewModel;
    private int layoutRes;
    private Boolean arrow = true;

    public RecyclerAdapter(@LayoutRes int layoutRes, HospitalViewModel hospitalViewModel) {
        this.hospitalViewModel = hospitalViewModel;
        this.layoutRes = layoutRes;
    }

    public int getLayoutRes(Integer position) {
        return layoutRes;

    }

    public void setDataList(List<Data> hospitalDataModels) {
        this.hospitalDataModels = hospitalDataModels;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return getLayoutRes(position);
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);

        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {

        holder.bind(hospitalViewModel, position);

        holder.binding.dropDown.setOnClickListener(v -> {
            arrow=!arrow;
            if (arrow) {
                holder.binding.hide.setVisibility(View.GONE);
                holder.binding.dropDown.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
            } else {
                holder.binding.hide.setVisibility(View.VISIBLE);
                holder.binding.dropDown.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);

            }

        });

    }

    @Override
    public int getItemCount() {
        return hospitalDataModels == null ? 0 : hospitalDataModels.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private RecyclerLayoutBinding binding;

        public RecyclerViewHolder(@NonNull RecyclerLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HospitalViewModel hospitalViewModel, Integer position) {
            binding.setViewModel(hospitalViewModel);
            binding.setPosition(position);
            binding.executePendingBindings();
        }

    }
}

