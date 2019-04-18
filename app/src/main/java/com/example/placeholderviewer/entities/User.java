package com.example.placeholderviewer.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.placeholderviewer.data.database.base.DbEntity;

import java.io.Serializable;

public class User extends DbEntity implements Serializable, Parcelable {

    private String name;
    private String userName;
    private String email;
    private Adress adress;
    private String phone;
    private String website;
    private Compagny compagny;

    public User() {
    }

    public User(String name, String userName, String email, Adress adress, String phone, String website, Compagny compagny) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.adress = adress;
        this.phone = phone;
        this.website = website;
        this.compagny = compagny;
    }

    protected User(Parcel in) {
        name = in.readString();
        userName = in.readString();
        email = in.readString();
        adress = in.readParcelable(Adress.class.getClassLoader());
        phone = in.readString();
        website = in.readString();
        compagny = in.readParcelable(Compagny.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Compagny getCompagny() {
        return compagny;
    }

    public void setCompagny(Compagny compagny) {
        this.compagny = compagny;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(userName);
        dest.writeString(email);
        dest.writeParcelable(adress, flags);
        dest.writeString(phone);
        dest.writeString(website);
        dest.writeParcelable(compagny, flags);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", adress=").append(adress);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", website='").append(website).append('\'');
        sb.append(", compagny=").append(compagny);
        sb.append('}');
        return sb.toString();
    }
}
