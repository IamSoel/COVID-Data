package com.example.tryandroid.source.models.hospital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Capacity implements Serializable {

    @SerializedName("occupied_beds")
    @Expose
    private String occupied_beds;

    @SerializedName("doctors")
    @Expose
    private String doctors;

    @SerializedName("isolation_beds")
    @Expose
    private String isolation_beds;

    @SerializedName("beds")
    @Expose
    private String beds;

    @SerializedName("nurses")
    @Expose
    private String nurses;

    @SerializedName("ventilators")
    @Expose
    private String ventilators;

    public String getOccupied_beds() {
        return occupied_beds;
    }

    public void setOccupied_beds(String occupied_beds) {
        this.occupied_beds = occupied_beds;
    }

    public String getDoctors() {
        return doctors;
    }

    public void setDoctors(String doctors) {
        this.doctors = doctors;
    }

    public String getIsolation_beds() {
        return isolation_beds;
    }

    public void setIsolation_beds(String isolation_beds) {
        this.isolation_beds = isolation_beds;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getNurses() {
        return nurses;
    }

    public void setNurses(String nurses) {
        this.nurses = nurses;
    }

    public String getVentilators() {
        return ventilators;
    }

    public void setVentilators(String ventilators) {
        this.ventilators = ventilators;
    }
}
