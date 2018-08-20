package com.example.asus.roomfirsttry.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
@Entity(foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "ssid", childColumns = "user_id"),
                        @ForeignKey(entity = Post.class, parentColumns = "id", childColumns = "post_id")})
public class Comment {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String comment;

    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "post_id")
    private int postId;

    @ParcelConstructor
    public Comment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
