package com.example.asus.roomfirsttry.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.asus.roomfirsttry.entity.Post;

import java.util.List;

@Dao
public interface PostDao {

    @Insert
    void insert(Post... posts);

    @Delete
    void delete(Post... posts);

    @Update
    void update(Post... posts);

    @Query("SELECT * FROM post")
    List<Post> getAllPosts();

    @Query("SELECT COUNT(*) FROM post")
    int numberOfAllPosts();
}
