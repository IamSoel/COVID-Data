package com.example.tryandroid.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tryandroid.source.models.NepalDataModel;
import com.example.tryandroid.source.repository.NepalDataRepository;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private final NepalDataRepository nepalDataRepository;
    private MutableLiveData<NepalDataModel> nepalData = new MutableLiveData<>();

    @Inject
    public MainViewModel(NepalDataRepository nepalDataRepository) {
        this.nepalDataRepository = nepalDataRepository;
        nepalData();
    }

    private void nepalData() {
        nepalDataRepository.getDataNepal().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<NepalDataModel>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(NepalDataModel nepalDataModel) {
                nepalData.postValue(nepalDataModel);
                Log.d("NepalData", "onSuccess: " + new Gson().toJson(nepalDataModel));

            }

            @Override
            public void onError(Throwable e) {
                Log.d("NepalData", "onSuccess: " + e.getMessage());

            }
        });
    }

    public LiveData<NepalDataModel> getNepalData() {
        return nepalData;
    }

}
