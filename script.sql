/* https://sqliteonline.com/ */

-- create tables

REATE TABLE user (
    ssid integer PRIMARY KEY,
    first_name text NOT NULL,
    last_name text NOT NULL,
    avatar_url text
);

CREATE TABLE post (
    id integer PRIMARY KEY,
    title text NOT NULL,
    post_desc text,
    image_url text,
    user_id integer NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (ssid)  
);

CREATE TABLE comment (
    id integer PRIMARY KEY,
    comment_text text NOT NULL,
    user_id integer NOT NULL,
    post_id integer NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (ssid),
    FOREIGN KEY (post_id) REFERENCES post (id)
);

-- insert data into tables

INSERT INTO user VALUES 
                (1, "Narges", "Sadeghi", "https://en.gravatar.com/userimage/138295633/163d579e4e6d35c8d1dc2538902ae6fd.jpg?size=200"),
                (2, "Arezoo", "Nazer", "https://cdn1.iconfinder.com/data/icons/user-pictures/100/female1-512.png"),
                (3, "Mahshid", "Ganjeh", "https://www.tm-town.com/assets/default_female600x600-3702af30bd630e7b0fa62af75cd2e67c.png");

INSERT INTO post VALUES
                (1, "First Post", "lorem ipsum dolor sit amet", "", 1),
                (2, "Second Post", "lorem ipsum dolor sit amet", "", 1),
                (3, "Third Post", "lorem ipsum dolor sit amet", "", 1),
                (4, "first", "lorem ipsum dolor sit amet", "", 2),
                (5, "second", "lorem ipsum dolor sit amet", "", 2),
                (6, "un", "lorem ipsum dolor sit amet", "", 3),
                (7, "dos", "lorem ipsum dolor sit amet", "", 3),
                (8, "tres", "lorem ipsum dolor sit amet", "", 3);

INSERT INTO comment VALUES
                    (1, "like", 1, 4),
                    (2, "likee", 1, 5),
                    (3, "likeee", 1, 8),
                    (4, "ali", 2, 1),
                    (5, "awli", 2, 2),
                    (6, "awwli", 2, 5),
                    (7, "nice", 3, 1),
                    (8, "nicee", 3, 8),
                    (9, "niceee", 3, 5),
                    (10, "niceeee", 3, 2);
                
-- queries
-- 1: users commented on a post
SELECT *
FROM user
WHERE ssid IN (SELECT user_id
                    FROM comment
                    WHERE post_id = 8);

-- 2: comments of a post
SELECT *
FROM comment
WHERE post_id = 4;

-- 3: comments of a user
SELECT * 
FROM comment
WHERE user_id = 1;

-- 4: number of a user's comments
SELECT COUNT(*)
FROM comment
WHERE user_id = 1;
