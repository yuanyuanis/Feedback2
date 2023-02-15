package com.yuanyuanis.concurrente.restcountriesv3.service;


import com.yuanyuanis.concurrente.restcountriesv3.domain.Country;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;


public interface CountriesApiService {

    @GET("/v2/all")
    Observable<List<Country>> getAllCountries();

    @GET("/v2/name/{name}")
    Observable<List<Country>> getCountry(@Path("name") String name);
}
