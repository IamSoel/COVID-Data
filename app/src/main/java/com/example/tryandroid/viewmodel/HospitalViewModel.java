package com.example.tryandroid.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tryandroid.source.models.hospital.HospitalDataModel;
import com.example.tryandroid.source.repository.NepalDataRepository;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HospitalViewModel extends ViewModel {

    private final NepalDataRepository nepalDataRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<HospitalDataModel> hospitalData = new MutableLiveData<>();

    @Inject

    public HospitalViewModel(NepalDataRepository nepalDataRepository) {
        this.nepalDataRepository = nepalDataRepository;

        getHospitalData();
    }

    private void getHospitalData() {
        nepalDataRepository.getHospitalData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<HospitalDataModel>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);
            }

            @Override
            public void onSuccess(HospitalDataModel hospitalDataModels) {
                if (hospitalDataModels != null) {
                    hospitalData.postValue(hospitalDataModels);
                }
                Log.d("HOSPITAL", "onSuccess: " + new Gson().toJson(hospitalDataModels));

            }

            @Override
            public void onError(Throwable e) {
                Log.d("HOSPITAL", "onSuccess: " + e.getMessage());


            }
        });
    }

    public LiveData<HospitalDataModel> getData() {
        return hospitalData;
    }
}
