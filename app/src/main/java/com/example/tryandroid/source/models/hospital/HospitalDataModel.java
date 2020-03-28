package com.example.tryandroid.source.models.hospital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HospitalDataModel implements Serializable {

    @SerializedName("total")
    @Expose
    private String total;

    @SerializedName("data")
    @Expose
    private List<Data> data;

    @SerializedName("limit")
    @Expose
    private String limit;

    @SerializedName("start")
    @Expose
    private String start;

    @SerializedName("page")
    @Expose
    private String page;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
