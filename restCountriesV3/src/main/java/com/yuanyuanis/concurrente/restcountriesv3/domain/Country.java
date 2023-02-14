package com.yuanyuanis.concurrente.restcountriesv3.domain;

public class Country {

    private String name;
    private String capital;
    private String region;
    private String subregion;
    private Boolean independent;
    private Integer population;

    public Country(){

    }

    public Country(String name, String capital, String region, String subregion, Boolean independent, Integer population) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.independent = independent;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Boolean getIndependent() {
        return independent;
    }

    public void setIndependent(Boolean independent) {
        this.independent = independent;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", independent=" + independent +
                ", population=" + population +
                '}';
    }
}
