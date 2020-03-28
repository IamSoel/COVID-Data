package com.example.tryandroid.source.server;

import com.example.tryandroid.source.models.hospital.HospitalDataModel;
import com.example.tryandroid.source.models.NepalDataModel;
import com.example.tryandroid.source.models.WorldDataModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DataNepal {

    @Headers("Cache-control:no-cache")
    @GET("data/nepal")
    Single<NepalDataModel> getNepalData();

    @Headers("Cache-control:no-cache")
    @GET("data/world")
    Single<List<WorldDataModel>> getWorldData();

    @Headers("Cache-control:no-cache")
    @GET("hospitals")
    Single<HospitalDataModel> getHospitalData();

}
