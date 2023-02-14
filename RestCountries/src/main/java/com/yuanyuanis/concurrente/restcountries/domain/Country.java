package com.yuanyuanis.concurrente.restcountries.domain;

public class Country {

    private String name;

    public Country(){

    }

    public Country(String name, String capital, String region, String subregion, Boolean independent, Integer population) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'';
    }
}
