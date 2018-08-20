package com.example.asus.roomfirsttry.util;

import com.example.asus.roomfirsttry.database.AppDatabase;
import com.example.asus.roomfirsttry.entity.Comment;
import com.example.asus.roomfirsttry.entity.Post;
import com.example.asus.roomfirsttry.entity.User;

import java.util.List;

public class DataGenerator {

    private static DataGenerator instance;
    private static AppDatabase database;

    public static DataGenerator with(AppDatabase appDatabase) {

        if(database == null)
            database = appDatabase;

        if(instance == null)
            instance = new DataGenerator();

        return instance;
    }

    public void generateUsers() {
        if(database == null)
            return;

        User[] users = new User[3];

        users[0] = userInstance("Narges", "Sadeghi", "https://en.gravatar.com/userimage/138295633/163d579e4e6d35c8d1dc2538902ae6fd.jpg?size=200");
        users[1] = userInstance("Arezoo", "Nazer", "https://cdn1.iconfinder.com/data/icons/user-pictures/100/female1-512.png");
        users[2] = userInstance("Mahshid", "Ganjeh", "https://www.tm-town.com/assets/default_female600x600-3702af30bd630e7b0fa62af75cd2e67c.png");

        database.userDao().insert(users);
    }

    public void generatePosts() {
        if(database == null)
            return;

        Post[] posts = new Post[8];

        posts[0] = postInstance("first post", "lorem ipsum dolor sit amet", "", 1);
        posts[1] = postInstance("second post", "lorem ipsum dolor sit amet", "", 1);
        posts[2] = postInstance("Third Post", "lorem ipsum dolor sit amet", "", 1);
        posts[3] = postInstance( "first", "lorem ipsum dolor sit amet", "", 2);
        posts[4] = postInstance("second", "lorem ipsum dolor sit amet", "", 2);
        posts[5] = postInstance("un", "lorem ipsum dolor sit amet", "", 3);
        posts[6] = postInstance("dos", "lorem ipsum dolor sit amet", "", 3);
        posts[7] = postInstance("tres", "lorem ipsum dolor sit amet", "", 3);

        database.postDao().insert(posts);
    }

    public void generateComments() {
        if(database == null)
            return;

        Comment[] comments = new Comment[10];

        comments[0] = commentInstance("like", 1, 4);
        comments[1] = commentInstance("likee", 1, 5);
        comments[2] = commentInstance("likeee", 1, 8);
        comments[3] = commentInstance("ali", 2, 1);
        comments[4] = commentInstance("awli", 2, 2);
        comments[5] = commentInstance("awwli", 2, 5);
        comments[6] = commentInstance("nice", 3, 1);
        comments[7] = commentInstance("nicee", 3, 2);
        comments[8] = commentInstance("niceee", 3, 5);
        comments[9] = commentInstance("niceeee", 3, 8);

        database.commentDao().insert(comments);
    }

    private User userInstance(String firstName, String lastName, String avatarUrl) {

        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAvatarUrl(avatarUrl);

        return user;
    }

    private Post postInstance(String title, String description, String imageUrl, int userId) {

        Post post = new Post();

        post.setTitle(title);
        post.setDescription(description);
        post.setImageUrl(imageUrl);
        post.setUserId(userId);

        return post;
    }

    private Comment commentInstance(String comment_text, int userId, int postId) {

        Comment comment = new Comment();

        comment.setComment(comment_text);
        comment.setUserId(userId);
        comment.setPostId(postId);

        return comment;
    }
}
