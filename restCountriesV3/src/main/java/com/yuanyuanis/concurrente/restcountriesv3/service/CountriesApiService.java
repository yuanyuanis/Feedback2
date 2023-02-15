package com.yuanyuanis.concurrente.restcountriesv3.service;


import com.yuanyuanis.concurrente.restcountriesv3.domain.Country;

import rx.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;


public interface CountriesApiService {

    @GET("/rest/v2/all")
    Observable<List<Country>> getAllCountries();

    // Cuidado! Aunque la respuesta en un solo país viene en forma de array
    @GET("/rest/v2/name/{name}")
    Observable<List<Country>> getCountry(@Path("name") String name);
}
