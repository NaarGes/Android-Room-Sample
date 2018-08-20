package com.example.asus.roomfirsttry.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.asus.roomfirsttry.dao.CommentDao;
import com.example.asus.roomfirsttry.dao.MyDao;
import com.example.asus.roomfirsttry.dao.PostDao;
import com.example.asus.roomfirsttry.dao.UserDao;
import com.example.asus.roomfirsttry.entity.Comment;
import com.example.asus.roomfirsttry.entity.Post;
import com.example.asus.roomfirsttry.entity.User;

import org.parceler.Parcel;

@Database(entities = {User.class, Post.class, Comment.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;


    public abstract UserDao userDao();
    public abstract PostDao postDao();
    public abstract CommentDao commentDao();
    public abstract MyDao myDao();


    public static AppDatabase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "app-db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}

