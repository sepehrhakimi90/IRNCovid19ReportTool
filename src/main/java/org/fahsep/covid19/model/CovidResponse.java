package org.fahsep.covid19.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CovidResponse implements Serializable {


    @JsonProperty("Country")
    private String Country;
    @JsonProperty("CountryCode")
    private String CountryCode;
    @JsonProperty("Province")
    private String Province;
    @JsonProperty("City")
    private String City;
    @JsonProperty("CityCode")
    private String CityCode;
    @JsonProperty("Lat")
    private String Lat;
    @JsonProperty("Lon")
    private String Lon;
    @JsonProperty("Cases")
    private int Cases;
    @JsonProperty("Status")
    private String Status;
    @JsonProperty("Date")
    private String Date;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLon() {
        return Lon;
    }

    public void setLon(String lon) {
        Lon = lon;
    }

    public int getCases() {
        return Cases;
    }

    public void setCases(int cases) {
        Cases = cases;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


}


