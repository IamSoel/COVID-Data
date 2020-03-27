package com.example.tryandroid.source.repository;

import com.example.tryandroid.source.models.NepalDataModel;
import com.example.tryandroid.source.server.DataNepal;

import javax.inject.Inject;

import io.reactivex.Single;


public class NepalDataRepository {
    private DataNepal dataNepal;

    @Inject
    public NepalDataRepository(DataNepal dataNepal) {
        this.dataNepal = dataNepal;
    }

    public Single<NepalDataModel> getDataNepal() {
        return dataNepal.getNepalData();
    }

}
