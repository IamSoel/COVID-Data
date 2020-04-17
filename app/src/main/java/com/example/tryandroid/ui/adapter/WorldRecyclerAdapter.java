package com.example.tryandroid.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tryandroid.databinding.WorldRecyclerLayoutBinding;
import com.example.tryandroid.source.models.WorldDataModel;
import com.example.tryandroid.viewmodel.WorldViewModel;

import java.util.ArrayList;
import java.util.List;

public class WorldRecyclerAdapter extends RecyclerView.Adapter<WorldRecyclerAdapter.ViewHolder> {
    private WorldViewModel worldViewModel;
    private List<WorldDataModel> worldDataModel = new ArrayList<>();
    private int layoutRes;

    public WorldRecyclerAdapter(@LayoutRes int layoutRes, WorldViewModel worldViewModel) {
        this.worldViewModel = worldViewModel;
        this.layoutRes = layoutRes;
    }

    public int getLayoutRes(Integer position) {
        return layoutRes;

    }

    public void setDataList(List<WorldDataModel> worldDataModel) {
        this.worldDataModel = worldDataModel;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutRes(position);
    }

    @NonNull
    @Override
    public WorldRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WorldRecyclerLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorldRecyclerAdapter.ViewHolder holder, int position) {
        holder.bind(worldViewModel, position);

    }

    @Override
    public int getItemCount() {
        return worldDataModel == null ? 0 : worldDataModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        WorldRecyclerLayoutBinding binding;

        public ViewHolder(@NonNull WorldRecyclerLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(WorldViewModel worldViewModel, Integer position) {
            binding.setPosition(position);
            binding.setViewModel(worldViewModel);
            binding.executePendingBindings();
        }
    }
}
