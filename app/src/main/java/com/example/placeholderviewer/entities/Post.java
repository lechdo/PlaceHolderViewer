package com.example.placeholderviewer.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.placeholderviewer.database.base.DbEntity;

import java.io.Serializable;

public class Post extends DbEntity implements Serializable, Parcelable {

    private User author;
    private String title;
    private String body;

    public Post() {
    }

    public Post(User author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
    }

    protected Post(Parcel in) {
        author = in.readParcelable(User.class.getClassLoader());
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(author, flags);
        dest.writeString(title);
        dest.writeString(body);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Post{");
        sb.append("Author=").append(author);
        sb.append(", title='").append(title).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
