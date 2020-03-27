package com.example.tryandroid.di.modules;

import com.example.tryandroid.source.server.DataNepal;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.tryandroid.constants.ConstantData.BASEURL;

@Module
public class ApplicationModule {

    private static Retrofit retrofit = null;

    @Provides
    @Singleton
    static OkHttpClient providesOkHttpClient() {
        int REQUEST_TIMEOUT = 100;
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT,
                        TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT,
                        TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT,
                        TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Request-Type", "Android")
                    .addHeader("Content-Type", "application/json");

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        return httpClient.build();

    }


    @Provides
    @Singleton
    static Retrofit providesRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .client(providesOkHttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    @Provides
    @Singleton
    static DataNepal providesWebApi(Retrofit retrofit) {
        return retrofit.create(DataNepal.class);
    }
//
//    //shared preferences helper
//    @Provides
//    @Singleton
//    static SharedPreferences provideSharedPreference(Context context) {
//        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//    }
//
//
//    //Database
//    @Provides
//    @Singleton
//    static DbDatabase provideDbDatabase(Application application) {
//        return Room.databaseBuilder(application, DbDatabase.class, "Sifaris.db")
//                .fallbackToDestructiveMigration()
//                .allowMainThreadQueries()
//                .build();
//
//    }
//
//    //DAO
//    @Provides
//    @Singleton
//    static DbDao providesDbDOA(DbDatabase database) {
//        return database.dao();
//    }

}
