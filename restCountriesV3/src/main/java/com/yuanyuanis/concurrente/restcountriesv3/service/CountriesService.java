package com.yuanyuanis.concurrente.restcountriesv3.service;

import com.yuanyuanis.concurrente.restcountriesv3.domain.Country;
import rx.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class CountriesService {

    private CountriesApiService api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(CountriesApiService.class);
    }

    public Observable<List<Country>> getAllCountries() {
        return api.getAllCountries();
    }

    public Observable<List<Country>> getCountry(String name) {
        return api.getCountry(name);
    }

}
