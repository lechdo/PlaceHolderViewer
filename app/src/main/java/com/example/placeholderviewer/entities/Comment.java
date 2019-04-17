package com.example.placeholderviewer.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.placeholderviewer.database.base.DbEntity;
import java.io.Serializable;

public class Comment extends DbEntity implements Serializable, Parcelable {

    private Post post;
    private User commentator;
    private String body;

    public Comment() {
    }

    public Comment(Post post, User commentator, String body) {
        this.post = post;
        this.commentator = commentator;
        this.body = body;
    }

    protected Comment(Parcel in) {
        post = in.readParcelable(Post.class.getClassLoader());
        commentator = in.readParcelable(User.class.getClassLoader());
        body = in.readString();
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
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
        dest.writeParcelable(post, flags);
        dest.writeParcelable(commentator, flags);
        dest.writeString(body);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Comment{");
        sb.append("post=").append(post);
        sb.append(", commentator=").append(commentator);
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
