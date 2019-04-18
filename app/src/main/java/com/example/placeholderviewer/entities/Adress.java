package com.example.placeholderviewer.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.placeholderviewer.data.database.base.DbEntity;

import java.io.Serializable;

public class Adress extends DbEntity implements Serializable, Parcelable {

    private String street;
    private String suite;
    private String city;
    private String zipCode;
    private Geo geo;

    public Adress() {
    }

    public Adress(String street, String suite, String city, String zipCode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geo = geo;
    }

    protected Adress(Parcel in) {
        street = in.readString();
        suite = in.readString();
        city = in.readString();
        zipCode = in.readString();
        geo = in.readParcelable(Geo.class.getClassLoader());
    }

    public static final Creator<Adress> CREATOR = new Creator<Adress>() {
        @Override
        public Adress createFromParcel(Parcel in) {
            return new Adress(in);
        }

        @Override
        public Adress[] newArray(int size) {
            return new Adress[size];
        }
    };

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(street);
        dest.writeString(suite);
        dest.writeString(city);
        dest.writeString(zipCode);
        dest.writeParcelable(geo, flags);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Adress{");
        sb.append("street='").append(street).append('\'');
        sb.append(", suite='").append(suite).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", geo=").append(geo);
        sb.append('}');
        return sb.toString();
    }
}
