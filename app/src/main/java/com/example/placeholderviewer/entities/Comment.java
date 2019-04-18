package com.example.placeholderviewer.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.placeholderviewer.database.base.DbEntity;
import java.io.Serializable;

public class Comment extends DbEntity implements Serializable, Parcelable {

    private String name;
    private String body;
    private Post post;

    public Comment() {
    }

    public Comment(String name, String body, Post post) {
        this.name = name;
        this.body = body;
        this.post = post;
    }

    protected Comment(Parcel in) {
        name = in.readString();
        body = in.readString();
        post = in.readParcelable(Post.class.getClassLoader());
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(body);
        dest.writeParcelable(post, flags);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
