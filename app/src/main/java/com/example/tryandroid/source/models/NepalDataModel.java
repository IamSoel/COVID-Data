package com.example.tryandroid.source.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NepalDataModel implements Serializable {

    @SerializedName("tested_positive")
    @Expose
    private String testedPositive;
    @SerializedName("tested_negative")
    @Expose
    private String testedNegative;
    @SerializedName("tested_total")
    @Expose
    private String testedTotal;
    @SerializedName("source")
    @Expose
    private String source;
//    @SerializedName("lastest_sit_report")
//    @Expose
//    private LastestSitReport lastestSitReport;

    public String getTestedPositive() {
        return testedPositive;
    }

    public void setTestedPositive(String testedPositive) {
        this.testedPositive = testedPositive;
    }

    public String getTestedNegative() {
        return testedNegative;
    }

    public void setTestedNegative(String testedNegative) {
        this.testedNegative = testedNegative;
    }

    public String getTestedTotal() {
        return testedTotal;
    }

    public void setTestedTotal(String testedTotal) {
        this.testedTotal = testedTotal;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
