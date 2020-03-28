package com.example.tryandroid.source.models.hospital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Location implements Serializable {


    @SerializedName("coordinates")
    @Expose
    private List<String> coordinates;

    @SerializedName("type")
    @Expose
    private String type;
}
