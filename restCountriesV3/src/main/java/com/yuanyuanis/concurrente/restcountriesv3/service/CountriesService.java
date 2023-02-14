package com.yuanyuanis.concurrente.restcountriesv3.service;

import com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail.domain.Country;
import com.yuanyuanis.concurrente.restcountries.restcountries2_countriesdetail.util.Constants;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class CountriesService {

    private CountriesApiService api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(CountriesApiService.class);
    }

    public List<Country> getAllCountries() {
        Call<List<Country>> allCountriesCall = api.getAllCountries();
        try {
            Response<List<Country>> response = allCountriesCall.execute();
            return response.body();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return null;
    }

}
