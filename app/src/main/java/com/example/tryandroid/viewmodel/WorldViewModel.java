package com.example.tryandroid.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tryandroid.R;
import com.example.tryandroid.source.models.WorldDataModel;
import com.example.tryandroid.source.repository.NepalDataRepository;
import com.example.tryandroid.ui.adapter.WorldRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WorldViewModel extends ViewModel {

    private final NepalDataRepository nepalDataRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<List<WorldDataModel>> worldData = new MutableLiveData<>();
    private WorldRecyclerAdapter recyclerAdapter;

    @Inject
    public WorldViewModel(NepalDataRepository nepalDataRepository) {
        this.nepalDataRepository = nepalDataRepository;
        this.recyclerAdapter = new WorldRecyclerAdapter(R.layout.world_recycler_layout, this);
        getWorldData();
    }

    private void getWorldData() {

        nepalDataRepository.getWorldData().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new SingleObserver<List<WorldDataModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);

            }

            @Override
            public void onSuccess(List<WorldDataModel> worldDataModels) {
                if (worldDataModels != null) {
                    worldData.postValue(worldDataModels);
                }

                Log.d("WORLD", "onSuccess: " + worldDataModels);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("WORLD", "onSuccess: " + e.getMessage());


            }
        });

    }

    public LiveData<List<WorldDataModel>> getData() {
        return this.worldData;
    }

    public WorldRecyclerAdapter getRecyclerAdapter() {
        return this.recyclerAdapter;
    }

    public void setRecyclerAdapter(List<WorldDataModel> worldDataModel) {
        this.recyclerAdapter.setDataList(worldDataModel);
    }

    public WorldDataModel getWorldDataItemAt(Integer position) {
        if (this.worldData.getValue() != null && position != null) {
            return this.worldData.getValue().get(position);
        }
        return null;
    }
}
