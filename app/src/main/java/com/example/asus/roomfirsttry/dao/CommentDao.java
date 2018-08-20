package com.example.asus.roomfirsttry.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.asus.roomfirsttry.entity.Comment;

import java.util.List;

@Dao
public interface CommentDao {

    @Insert
    void insert(Comment... comments);

    @Update
    void update(Comment... comments);

    @Delete
    void delete(Comment... comments);

    @Query("SELECT * FROM comment")
    List<Comment> getAllComments();

    @Query("SELECT COUNT(*) FROM comment")
    int numberOfAlComments();
}
