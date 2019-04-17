package com.example.placeholderviewer.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.placeholderviewer.database.base.DbEntity;

import java.io.Serializable;

public class Compagny extends DbEntity implements Serializable, Parcelable {

    private String name;
    private String catchPhrase;
    private String bs;

    public Compagny() {
    }

    public Compagny(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    protected Compagny(Parcel in) {
        name = in.readString();
        catchPhrase = in.readString();
        bs = in.readString();
    }

    public static final Creator<Compagny> CREATOR = new Creator<Compagny>() {
        @Override
        public Compagny createFromParcel(Parcel in) {
            return new Compagny(in);
        }

        @Override
        public Compagny[] newArray(int size) {
            return new Compagny[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(catchPhrase);
        dest.writeString(bs);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Compagny{");
        sb.append("name='").append(name).append('\'');
        sb.append(", catchPhrase='").append(catchPhrase).append('\'');
        sb.append(", bs='").append(bs).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
