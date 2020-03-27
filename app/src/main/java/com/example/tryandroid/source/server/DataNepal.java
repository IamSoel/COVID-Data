package com.example.tryandroid.source.server;

import com.example.tryandroid.source.models.NepalDataModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DataNepal {

    @Headers("Cache-control:no-cache")
    @GET("data/nepal")
    Single<NepalDataModel> getNepalData();

}
