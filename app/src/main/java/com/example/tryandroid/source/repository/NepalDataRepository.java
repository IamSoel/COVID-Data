package com.example.tryandroid.source.repository;

import com.example.tryandroid.source.models.hospital.HospitalDataModel;
import com.example.tryandroid.source.models.NepalDataModel;
import com.example.tryandroid.source.models.WorldDataModel;
import com.example.tryandroid.source.server.DataNepal;

import java.util.List;

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

    public Single<List<WorldDataModel>> getWorldData() {
        return dataNepal.getWorldData();
    }

    public Single<HospitalDataModel> getHospitalData()
    {
        return dataNepal.getHospitalData();
    }

}
