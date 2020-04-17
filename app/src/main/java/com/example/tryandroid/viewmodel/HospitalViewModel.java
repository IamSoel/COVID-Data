package com.example.tryandroid.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tryandroid.R;
import com.example.tryandroid.source.models.hospital.Data;
import com.example.tryandroid.source.models.hospital.HospitalDataModel;
import com.example.tryandroid.source.repository.NepalDataRepository;
import com.example.tryandroid.ui.adapter.RecyclerAdapter;
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
    private CompositeDisposable disposable ;
    private RecyclerAdapter recyclerAdapter;
    private MutableLiveData<HospitalDataModel> hospitalData = new MutableLiveData<>();
    private MutableLiveData<List<Data>> datalive = new MutableLiveData<>();

    @Inject
    public HospitalViewModel(NepalDataRepository nepalDataRepository) {
        this.nepalDataRepository = nepalDataRepository;
        disposable=new CompositeDisposable();
        this.recyclerAdapter = new RecyclerAdapter(R.layout.recycler_layout, this);
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

                    List<Data> data = hospitalDataModels.getData();
                    datalive.setValue(data);
                }
                Log.d("HOSPITAL", "onSuccess: " + new Gson().toJson(hospitalDataModels));

            }

            @Override
            public void onError(Throwable e) {
                Log.d("HOSPITAL", "onSuccess: " + e.getMessage());


            }
        });
    }

    public LiveData<List<Data>> getData() {
        return this.datalive;
    }

    public RecyclerAdapter getRecyclerAdapter() {
        return this.recyclerAdapter;
    }

    public void setRecyclerAdapter(List<Data> data) {
        this.recyclerAdapter.setDataList(data);
    }

    public Data getHospitaltemAt(Integer position) {
        if (this.datalive.getValue() != null && position != null) {
            return this.datalive.getValue().get(position);
        }
        return null;
    }
}
