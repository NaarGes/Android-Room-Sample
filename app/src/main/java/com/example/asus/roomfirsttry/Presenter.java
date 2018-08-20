package com.example.asus.roomfirsttry;

import com.example.asus.roomfirsttry.database.AppDatabase;
import com.example.asus.roomfirsttry.entity.User;

import java.util.List;

public class Presenter {

    public Presenter() {

    }

    public List<User> firstQueryResult(AppDatabase database, int postId) {

        return database.myDao().UsersCommentedOnAPost(postId);
    }


}
