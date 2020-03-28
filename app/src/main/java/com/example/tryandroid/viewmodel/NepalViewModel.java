package com.example.tryandroid.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tryandroid.source.models.NepalDataModel;
import com.example.tryandroid.source.repository.NepalDataRepository;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NepalViewModel extends ViewModel {

    private final NepalDataRepository nepalDataRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<NepalDataModel> nepalData = new MutableLiveData<>();

    @Inject
    public NepalViewModel(NepalDataRepository nepalDataRepository) {
        this.nepalDataRepository = nepalDataRepository;

        getNepalData();
    }

    private void getNepalData() {
        nepalDataRepository.getDataNepal().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<NepalDataModel>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);

            }

            @Override
            public void onSuccess(NepalDataModel nepalDataModel) {
                if (nepalDataModel != null) {
                    nepalData.postValue(nepalDataModel);
                }

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public LiveData<NepalDataModel> getData() {
        return nepalData;
    }
}
