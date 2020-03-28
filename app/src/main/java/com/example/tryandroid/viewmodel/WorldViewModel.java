package com.example.tryandroid.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tryandroid.source.models.WorldDataModel;
import com.example.tryandroid.source.repository.NepalDataRepository;

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

    @Inject
    public WorldViewModel(NepalDataRepository nepalDataRepository) {
        this.nepalDataRepository = nepalDataRepository;

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
        return worldData;
    }
}
