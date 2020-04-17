package com.example.tryandroid.source.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WorldDataModel implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("totalCases")
    @Expose
    private long totalCases;

    @SerializedName("newCases")
    @Expose
    private long newCases;

    @SerializedName("totalDeaths")
    @Expose
    private long totalDeaths;

    @SerializedName("newDeaths")
    @Expose
    private long newDeaths;

    @SerializedName("activeCases")
    @Expose
    private long activeCases;

    @SerializedName("totalRecovered")
    @Expose
    private long totalRecovered;

    @SerializedName("criticalCases")
    @Expose
    private long criticalCases;

    @SerializedName("__v")
    @Expose
    private long v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(long totalCases) {
        this.totalCases = totalCases;
    }

    public long getNewCases() {
        return newCases;
    }

    public void setNewCases(long newCases) {
        this.newCases = newCases;
    }

    public long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public long getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(long activeCases) {
        this.activeCases = activeCases;
    }

    public long getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(long totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public long getCriticalCases() {
        return criticalCases;
    }

    public void setCriticalCases(long criticalCases) {
        this.criticalCases = criticalCases;
    }

    public long getV() {
        return v;
    }

    public void setV(long v) {
        this.v = v;
    }
}
