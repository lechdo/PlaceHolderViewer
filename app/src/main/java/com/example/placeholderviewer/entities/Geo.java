package com.example.placeholderviewer.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.placeholderviewer.database.base.DbEntity;

import java.io.Serializable;

public class Geo extends DbEntity implements Serializable, Parcelable {

    private Float lat;
    private Float lon;

    public Geo() {
    }

    public Geo(Float lat, Float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    protected Geo(Parcel in) {
        if (in.readByte() == 0) {
            lat = null;
        } else {
            lat = in.readFloat();
        }
        if (in.readByte() == 0) {
            lon = null;
        } else {
            lon = in.readFloat();
        }
    }

    public static final Creator<Geo> CREATOR = new Creator<Geo>() {
        @Override
        public Geo createFromParcel(Parcel in) {
            return new Geo(in);
        }

        @Override
        public Geo[] newArray(int size) {
            return new Geo[size];
        }
    };

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (lat == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(lat);
        }
        if (lon == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(lon);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Geo{");
        sb.append("lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append('}');
        return sb.toString();
    }
}
