package com.yuanyuanis.concurrente.restcountriesv3.service;

import com.yuanyuanis.concurrente.restcountriesv3.domain.Country;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import java.util.List;
public class CountriesService {

    public final static String URL = "https://restcountries.com/";

    private CountriesApiService api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
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
