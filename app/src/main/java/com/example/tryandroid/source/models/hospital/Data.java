package com.example.tryandroid.source.models.hospital;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Data implements Serializable {

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("notes")
    @Expose
    private String notes;

    @SerializedName("contact_person")
    @Expose
    private String contact_person;

    @SerializedName("image_url")
    @Expose
    private String image_url;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("contact_person_number")
    @Expose
    private String contact_person_number;

    @SerializedName("hospital_id")
    @Expose
    private String hospital_id;

    @SerializedName("capacity")
    @Expose
    private Capacity capacity;

    @SerializedName("is_full")
    @Expose
    private String is_full;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("__v")
    @Expose
    private String __v;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("government_approved")
    @Expose
    private String government_approved;

    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("email")
    @Expose
    private String email;


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContact_person_number() {
        return contact_person_number;
    }

    public void setContact_person_number(String contact_person_number) {
        this.contact_person_number = contact_person_number;
    }

    public String getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(String hospital_id) {
        this.hospital_id = hospital_id;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public String getIs_full() {
        return is_full;
    }

    public void setIs_full(String is_full) {
        this.is_full = is_full;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getGovernment_approved() {
        return government_approved;
    }

    public void setGovernment_approved(String government_approved) {
        this.government_approved = government_approved;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
