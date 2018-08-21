package com.example.asus.roomfirsttry.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.asus.roomfirsttry.entity.Comment;
import com.example.asus.roomfirsttry.entity.User;

import java.util.List;

@Dao
public interface MyDao {

    @Query(" SELECT * FROM user " +
            "WHERE ssid IN (SELECT user_id " +
            "                    FROM comment" +
            "                    WHERE post_id = :postId)")
    public List<User> UsersCommentedOnAPost(int postId);


    @Query("SELECT * " +
            "FROM comment " +
            "WHERE user_id = :userId")
    public List<Comment> CommentsOfAUser(int userId);

    @Query("SELECT * " +
            "FROM comment " +
            "WHERE post_id = :postId")
    public List<Comment> commentsOfAPost(int postId);



}
