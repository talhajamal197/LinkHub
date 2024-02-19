drop TABLE profile_visits;
drop TABLE user_likes;
drop TABLE user_profiles;


CREATE TABLE user_profiles ( user_id INT PRIMARY KEY, name 	VARCHAR(255), age INT );
CREATE TABLE profile_visits ( visit_id INT PRIMARY KEY, visitor_id 	INT, profile_id INT, visit_timestamp TIMESTAMP, FOREIGN KEY 	(visitor_id) REFERENCES user_profiles(user_id), FOREIGN KEY 	(profile_id) REFERENCES user_profiles(user_id) );
CREATE TABLE user_likes ( like_id INT PRIMARY KEY, liker_id INT, 	liked_profile_id INT, like_timestamp TIMESTAMP, FOREIGN KEY 	(liker_id) REFERENCES user_profiles(user_id), FOREIGN KEY 	(liked_profile_id) REFERENCES user_profiles(user_id) );