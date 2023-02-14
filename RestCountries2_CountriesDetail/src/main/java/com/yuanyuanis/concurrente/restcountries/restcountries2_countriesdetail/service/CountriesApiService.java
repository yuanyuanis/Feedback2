package com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail.service;


import com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail.domain.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;


public interface CountriesApiService {

    @GET("/v2/all")
    Call<List<Country>> getAllCountries();

    @GET("/v2/name/{name}")
    Call<List<Country>> getCountry(@Path("name") String name);
}
